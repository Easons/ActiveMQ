package com.pangpan.activemq.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        if (message != null && message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("消费者接收到Topic消息*******" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
