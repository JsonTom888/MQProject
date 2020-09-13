package com.example.active.active.queue;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 14:52
 */
@Configuration
public class MqQueueConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("neo.queue");
    }

}
