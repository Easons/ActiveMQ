package com.pangpan.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Consumer {

    @Autowired
    JmsTemplate jmsTemplate;

    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        SpringMQ_Consumer consumer = (SpringMQ_Consumer) ctx.getBean("springMQ_Consumer");
//
//        String returnValue = (String) consumer.jmsTemplate.receiveAndConvert();
//
//
//        System.out.println("*******收到"+returnValue);




    }

}
