package com.example.active.active.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 15:37
 */
@Configuration
public class MqTopicConfig {
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("com.topic");
    }
}
