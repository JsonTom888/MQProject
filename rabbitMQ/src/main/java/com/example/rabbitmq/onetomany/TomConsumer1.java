package com.example.rabbitmq.onetomany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:28
 */
@Component
@RabbitListener(queues = "tom")
public class TomConsumer1 {

    @RabbitHandler
    public void process(String tom){
        System.out.println("Receiver 1: " +tom);
    }


}
