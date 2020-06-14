package com.leospiritlee.springBootDemo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;


/**
 * @Project: SpringBootDemo
 * @ClassName ActiveMqConfig
 * @description: activeMq 配置
 * @author: leospiritlee
 * @create: 2020-06-14 16:33
 **/
@Configuration
public class ActiveMqConfig {

    public static final String TOPIC_NAME = "activeMQ.topic";

    public static final String QUEUE_NAME = "activeMQ.queue";

    @Bean
    public Destination topic(){
        return new ActiveMQTopic(TOPIC_NAME);
    }

    @Bean
    public Destination queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

    @Bean
    public JmsListenerContainerFactory topicListenerContainer(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory){

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);

        return factory;
    }

}
