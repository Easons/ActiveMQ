package com.pangpan.activemq.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.UUID;

@Component
public class SpringBootMQ_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void produceMsg() {
//        jmsMessagingTemplate.convertAndSend(queue,"***"+ UUID.randomUUID().toString().substring(0,6));

    }

    @Scheduled(fixedDelay = 3000)
    public void produceTopic() {
        jmsMessagingTemplate.convertAndSend(topic, "主题消息***" + UUID.randomUUID().toString().substring(0, 6));
                System.out.println("Send Topic OK*****************");

    }

    /**
     * 间隔时间3秒钟定时投递
     */
//    @Scheduled(fixedDelay = 3000)
//    public void produceMsgScheduled() {
//        jmsMessagingTemplate.convertAndSend(queue, "***" + UUID.randomUUID().toString().substring(0, 6));
//        System.out.println("Send OK*****************");
//    }
}
