package com.pangpan.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableJms //开启JMS适配的注解
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Value("${mytopic}")
    private  String topicName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }
}
