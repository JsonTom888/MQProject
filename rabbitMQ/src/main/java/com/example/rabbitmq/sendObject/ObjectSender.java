package com.example.rabbitmq.sendObject;

import com.example.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送的对象要实现序列化接口
 *
 * @author tom
 * @version V1.0
 * @date 2020/9/13 21:06
 */
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.amqpTemplate.convertAndSend("tom", user);
    }
}
