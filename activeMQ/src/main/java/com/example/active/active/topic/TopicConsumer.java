package com.example.active.active.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 15:41
 */
@Component
public class TopicConsumer {
    @JmsListener(destination = "com.topic", containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        System.out.println("Consumer topic msg : "+text);
    }
}
