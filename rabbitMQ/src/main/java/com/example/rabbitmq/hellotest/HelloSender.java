package com.example.rabbitmq.hellotest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:14
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("tom", context);
    }
}
