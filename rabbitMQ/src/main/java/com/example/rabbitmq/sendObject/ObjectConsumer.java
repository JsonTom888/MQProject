package com.example.rabbitmq.sendObject;

import com.example.rabbitmq.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 21:08
 */
@Component
//@RabbitListener(queues = "tom")
public class ObjectConsumer {
    @RabbitHandler
    public void pross(User user){
        System.err.println("Receiver object: " +user);
    }
}
