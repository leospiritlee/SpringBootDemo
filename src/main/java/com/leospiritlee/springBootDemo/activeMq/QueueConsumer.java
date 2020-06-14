package com.leospiritlee.springBootDemo.activeMq;

import com.leospiritlee.springBootDemo.config.ActiveMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Project: SpringBootDemo
 * @ClassName QueueConsumer
 * @description: queue 消费者
 * @author: leospiritlee
 * @create: 2020-06-14 16:44
 **/
@Service
public class QueueConsumer {

    private static final Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg){
        logger.info("receive queue msg: {}", msg);
    }

    @JmsListener(destination = ActiveMqConfig.TOPIC_NAME, containerFactory = "topicListenerContainer")
    public void receiveTopicMsg(String msg){
        logger.info("receive topic msg: {}", msg);
    }

}
