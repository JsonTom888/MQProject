package com.example.rabbitmq.exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 21:23
 */
@Component
@RabbitListener(queues = "topic.messages")
public class ExchangeConsumer2 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver2 : " + message);
    }
}
