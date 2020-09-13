package com.example.rocketproject.rocket;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author tom
 * @version V1.0
 * @date 2020/8/18 23:16
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        // 指定消费组名为my-consumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-consumer1");
        // 配置namesrv地址
        consumer.setNamesrvAddr("139.155.54.93:9876");
        // 订阅topic：myTopic001 下的全部消息（因为是*，*指定的是tag标签，代表全部消息，不进行任何过滤）
//        consumer.subscribe("myTopic001", "*");
        // 注册监听器，进行消息消息。
        consumer.subscribe("orderTopic", "order1");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : msgs) {
                    String str = new String(msg.getBody());
                    // 输出消息内容
                    System.out.println(str);
                }
                // 默认情况下，这条消息只会被一个consumer消费，这叫点对点消费模式。也就是集群模式。
                // ack确认
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者
        consumer.start();
        System.out.println("Consumer start");
    }
}
