package com.pangpan.activemq.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class SpringBootMQ_Consumer {

    @Autowired
    JmsTemplate jmsTemplate;

//    @JmsListener(destination ="${myqueue}")
//    public void receive(TextMessage textMessage){
//
//        System.out.println("*************消费者获得"+textMessage);
//    }

    @JmsListener(destination ="${mytopic}")
    public void receive(TextMessage textMessage){

        System.out.println("*************Topic消费者获得"+textMessage);
    }

}
