package com.ysan.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/8/11 14:21
 **/
public class PushConsumerDemo {
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragely());
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
               try {
                   System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                   return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
               } catch (Exception e) {
                   e.printStackTrace();
                   return ConsumeConcurrentlyStatus.RECONSUME_LATER;
               }
            }
        });

    }
}
