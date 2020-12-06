package com.pangpan.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerTwo_Topic {
    public static final String ACTIVEMQ_URL = "tcp://192.168.56.10:61616";
    public static final String TOPIC_NAME = "topic-pangpan";

    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("二号Topic消费者");

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
        //5.创建消息的消费者
        MessageConsumer consumer = session.createConsumer(topic);
//        while (true)
//        {
//            TextMessage receive = (TextMessage)consumer.receive(4000L);//不加时间会一直等待，加了时间4秒后停止
//            if(receive != null)
//            {
//                System.out.println("消费者接收到消息*******"+receive.getText());
//            }else{
//                break;
//            }
//        }
//        consumer.close();
//        session.close();
//        connection.close();

        //通过监听的方式来消费消息
        consumer.setMessageListener( message -> {
            if (message != null && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费者接收到Topic消息*******" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        consumer.setMessageListener(new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//            if (message != null && message instanceof TextMessage) {
//                TextMessage textMessage = (TextMessage) message;
//                try {
//                    System.out.println("消费者接收到消息*******" + textMessage.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


        System.in.read();//保证控制台不灭，不停止
        consumer.close();
        session.close();
        connection.close();


    }
}
