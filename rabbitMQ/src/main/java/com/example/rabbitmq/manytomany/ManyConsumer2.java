package com.example.rabbitmq.manytomany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:45
 */
@Component
//@RabbitListener(queues = "tom")
public class ManyConsumer2 {
    @RabbitHandler
    public void process(String tom){
        System.out.println("Receiver 2: " +tom);
    }
}
