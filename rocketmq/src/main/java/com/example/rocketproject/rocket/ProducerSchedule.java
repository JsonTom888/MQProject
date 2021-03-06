package com.example.rocketproject.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author tom
 * @version V1.0
 * @date 2020/11/15 21:58
 */
public class ProducerSchedule {
    public static void main(String[] args) throws Exception {
        // 指定生产组名为my-producer
        DefaultMQProducer producer = new DefaultMQProducer("my-producer");
        // 配置namesrv地址
        producer.setNamesrvAddr("139.155.54.93:9876");
        // 启动Producer
        producer.start();
        // 创建消息对象，topic为：myTopic001，消息内容为：hello world
        Message message = new Message("myTopic001", "schedule", "schedule-key", ("Hello schedule!").getBytes());
        //设置延迟队列的level，5表示延迟一分钟
        message.setDelayTimeLevel(5);
        // 发送消息到mq，同步
        SendResult result = producer.send(message);
        System.out.println("发送消息成功！result is : " + result);

        // 关闭Producer
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}
