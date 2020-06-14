package com.leospiritlee.springBootDemo.activeMq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Project: SpringBootDemo
 * @ClassName MsgProducer
 * @description: 消息生产者
 * @author: leospiritlee
 * @create: 2020-06-14 16:37
 **/
@Service
public class MsgProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg){
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }

}
