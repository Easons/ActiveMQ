package com.pangpan.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * topic 持久
 */
public class JmsConsumer_Topic_Persist {

    public static final String ACTIVEMQ_URL = "tcp://192.168.56.10:61616";
    public static final String TOPIC_NAME = "topic-pangpan";

    public static void main(String[] args) throws JMSException, IOException {

        //1.创建连接和给定的地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工场，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("z3");//表明一个叫z3的用户订阅了

        //3.创建会话session
        // 参数1：事务   参数2：签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列还是Topic) Destination 下有QUEUE 和 TOPIC
        Topic topic = session.createTopic(TOPIC_NAME);

        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark");//第二个参数不重要
        connection.start();

        Message message = topicSubscriber.receive();

        while (null != message)
        {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("**************持久化的Topic==="+textMessage.getText());
            message = topicSubscriber.receive();//加了超时时间，就会变离线，不加时间
        }


        session.close();
        connection.close();


    }
}
