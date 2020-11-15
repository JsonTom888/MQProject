package com.example.rocketproject.rocket;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author tom
 * @version V1.0
 * @date 2020/8/22 14:33
 */
public class ProducerTransaction2 {
    public static void main(String[] args) throws MQClientException {
        TransactionMQProducer producer = new TransactionMQProducer("my-transation-producer");
        producer.setNamesrvAddr("139.155.54.93:9876");
        producer.setTransactionListener(new TransactionListener() {
            /**
             * 本地事务方法
             * @param message
             * @param arg
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object arg) {
                LocalTransactionState state = null;
                //msg-1返回COMMIT_MESSAGE
                if(message.getKeys().equals("msg-1")){
                    state = LocalTransactionState.COMMIT_MESSAGE;
                }
                //msg-2返回ROLLBACK_MESSAGE
                else if(message.getKeys().equals("msg-2")){
                    state = LocalTransactionState.ROLLBACK_MESSAGE;
                }else{
                    //这里返回unknown的目的是模拟执行本地事务突然宕机的情况（或者本地执行成功发送确认消息失败的场景）
                    state = LocalTransactionState.UNKNOW;
                }
                System.out.println(message.getKeys() + ",state:" + state);
                return state;
            }

            /**
             * 定时回查方法
             * @param messageExt
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                if (null != messageExt.getKeys()) {
                    switch (messageExt.getKeys()) {
                        case "msg-3":
                            System.out.println("msg-3 unknow");
                            return LocalTransactionState.UNKNOW;
                        case "msg-4":
                            System.out.println("msg-4 COMMIT_MESSAGE");
                            return LocalTransactionState.COMMIT_MESSAGE;
                        case "msg-5":
                            //查询到本地事务执行失败，需要回滚消息。
                            System.out.println("msg-5 ROLLBACK_MESSAGE");
                            return LocalTransactionState.ROLLBACK_MESSAGE;
                    }
                }
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        //模拟发送5条消息
        for (int i = 1; i < 6; i++) {
            try {
                Message msg = new Message("transactionTopic", null, "msg-" + i, ("测试，这是事务消息！ " + i).getBytes());
                producer.sendMessageInTransaction(msg, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
