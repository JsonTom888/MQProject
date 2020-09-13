package com.example.rocketproject.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author tom
 * @version V1.0
 * @date 2020/8/18 22:51
 */
public class ProducerASync {
    public static void main(String[] args) throws Exception {
        // 指定生产组名为my-producer
        DefaultMQProducer producer = new DefaultMQProducer("my-producer");
        // 配置namesrv地址
        producer.setNamesrvAddr("139.155.54.93:9876");
        // 启动Producer
        producer.start();
        // 创建消息对象，topic为：myTopic001，消息内容为：hello world async
        Message msg = new Message("myTopic001", "hello world async".getBytes());
        // 进行异步发送，通过SendCallback接口来得知发送的结果
        producer.send(msg, new SendCallback() {
            // 发送成功的回调接口
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送消息成功！result is : " + sendResult);
            }
            // 发送失败的回调接口
            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("发送消息失败！result is : " + throwable.getMessage());
            }
        });
        Thread.sleep(3000);
        producer.shutdown();
        System.out.println("生产者 shutdown！");
    }
}