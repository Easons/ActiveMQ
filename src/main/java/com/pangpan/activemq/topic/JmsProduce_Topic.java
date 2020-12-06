package com.pangpan.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Topic {

    public  static  final String ACTIVEMQ_URL = "tcp://192.168.56.10:61616/";
    public  static  final String TOPIC_NAME = "topic-pangpan";

    public static void main(String[] args) throws JMSException {

        //1.创建连接和给定的地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工场，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3.创建会话session
        // 参数1：事务   参数2：签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列还是Topic) Destination 下有QUEUE 和 TOPIC
        Topic topic = session.createTopic(TOPIC_NAME);
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);
        messageProducer.setPriority(10);
        //6.通过使用消息生产者生产3条消息到MQ队列里
        for (int i = 1; i <= 3  ; i++)
        {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("message******" + i);//理解为一个字符串
            //8.通过messageProducer发送给MQ
            messageProducer.send(textMessage);
        }

        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("***TOPIC 发送完成***");
    }

}
