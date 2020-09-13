package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:13
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue() {
        return new Queue("tom");
    }
}
