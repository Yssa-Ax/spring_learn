package com.ysan.rocketmq.sync;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author Administrator
 * @description
 * @since 2023/8/4 15:44
 **/
public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("testProducerGroup");
        producer.setNamesrvAddr("49.235.108.159:9876");

        try {
            producer.start();
            // 发送单条消息
            Message msg = new Message("TOPIC_TEST", "hello rocketmq".getBytes());
            producer.send(msg, new SendCallback() {
                // 消息发送成功回调
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%s%n", sendResult);
                }
                // 消息发送失败回调
                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                    // 消息发送失败，可以在这里做补偿
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            // 消息发送失败，可以在这里做补偿
        }

        Thread.sleep(3000);
        // 使用完毕后，关闭消息发送者
        // Spring Boot ，不会自动调用 shutdown()
        producer.shutdown();


    }
}
