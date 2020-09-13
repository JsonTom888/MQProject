package com.example.active.active.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author tom
 * @version V1.0
 * @date 2020/9/13 14:56
 */
@Component
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendQueue(String msg){
        System.out.println("send queue msg:"+msg);
        this.jmsMessagingTemplate.convertAndSend(this.queue,msg);

    }

}
