package com.example.rocketproject.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tom
 * @version V1.0
 * @date 2020/8/17 23:58
 */
public class ProducerMultiMsg {
    public static void main(String[] args) throws Exception {
        // 指定生产组名为my-producer
        DefaultMQProducer producer = new DefaultMQProducer("my-producer");
        // 配置namesrv地址
        producer.setNamesrvAddr("139.155.54.93:9876");
        // 启动Producer
        producer.start();

        String topic = "myTopic001";
        String topic2 = "myTopic002";
        // 创建消息对象，topic为：myTopic001，消息内容为：hello world1/2/3
        Message msg1 = new Message(topic, "hello world1".getBytes());
        Message msg2 = new Message(topic, "hello world2".getBytes());
        Message msg3 = new Message(topic, "hello world3".getBytes());
        // 创建消息对象的集合，用于批量发送
        List<Message> msgs = new ArrayList<>();
        msgs.add(msg1);
        msgs.add(msg2);
        msgs.add(msg3);
        // 批量发送的api的也是send()，只是他的重载方法支持List<Message>，同样是同步发送。
        SendResult result = producer.send(msgs);
        System.out.println("发送消息成功！result is : " + result);
        // 关闭Producer
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
