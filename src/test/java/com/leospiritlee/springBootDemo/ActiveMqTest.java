package com.leospiritlee.springBootDemo;

import com.leospiritlee.springBootDemo.activeMq.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Project: SpringBootDemo
 * @ClassName ActiveMqTest
 * @description: activeMq test
 * @author: leospiritlee
 * @create: 2020-06-14 16:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTest {

    private static final Logger logger = LoggerFactory.getLogger(ActiveMqTest.class);

    @Resource
    private MsgProducer msgProducer;

    @Resource
    private Destination queue;

    @Resource
    private Destination topic;

    /**
     * queue 发送消息测试
     */
    @Test
    public void sendMsgQueueTest(){
        logger.info("start send msg to queue");
        msgProducer.sendMessage(queue, "this is a test msg to queue");
        logger.info("send success!");
    }

    @Test
    public void sendMsgTopicTest(){
        logger.info("start send msg to topic");
        msgProducer.sendMessage(topic, "this is a test msg to topic");
        logger.info("send success!");
    }

}
