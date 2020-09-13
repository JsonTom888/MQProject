package com.example.active.active.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 15:01
 */
@Component
public class QueueConsumer {
    @JmsListener(destination = "neo.queue")
    public void receiveQueue(String text){
        System.out.println("Consumer queue msg:"+text);
    }
}
