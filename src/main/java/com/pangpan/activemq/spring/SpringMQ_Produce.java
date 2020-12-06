package com.pangpan.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service
public class SpringMQ_Produce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SpringMQ_Produce produce = (SpringMQ_Produce) ctx.getBean("springMQ_Produce");//获取的时候默认首字母小写
//
//        /**
//         * Lamda表达式
//         */
//        produce.jmsTemplate.send(session -> {
//
//                    TextMessage textMessage = session.createTextMessage("******spring和MQ的整合");
//                    return textMessage;
//                }
//        );
////        produce.jmsTemplate.send(new MessageCreator() {
////            @Override
////            public Message createMessage(Session session) throws JMSException {
////                return null;
////            }
////        });
//
//
//        System.out.println("Send 完成******");
//
    }


}
