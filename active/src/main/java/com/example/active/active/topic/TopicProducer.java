package com.example.active.active.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 15:39
 */
@Component
public class TopicProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
    public void sendTopic(String msg) {
        System.out.println("send topic msg :"+msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
