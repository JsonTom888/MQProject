package com.example.rabbitmq.onetomany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:30
 */
@Component
@RabbitListener(queues = "tom")
public class TomConsumer2 {
    @RabbitHandler
    public void process(String tom){
        System.err.println("Receiver 2: " +tom);
    }
}
