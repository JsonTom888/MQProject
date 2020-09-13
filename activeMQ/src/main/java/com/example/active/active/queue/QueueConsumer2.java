package com.example.active.active.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 15:32
 */
@Component
public class QueueConsumer2 {
    @JmsListener(destination = "neo.queue")
    public void receiveQueue(String text) {
        System.err.println("Consumer2 queue msg : "+text);
    }
}
