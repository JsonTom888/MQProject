package com.example.rabbitmq.onetomany;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 20:24
 */
@Component
public class TomSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i){
        String context = "spring boot com queue:"+" ****** "+i;
        System.out.println("Sender1 : " + context);
        this.amqpTemplate.convertAndSend("tom",context);
    }

}
