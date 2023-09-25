package com.ysan.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description
 * @since 2023/8/10 11:44
 **/
public class PullConsumerTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        Thread t = new Thread(new Task(semaphore));
        t.start();
        CountDownLatch cdh = new CountDownLatch(1);

        try {
            cdh.await(120 * 1000, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.running = false;
        }
    }





    static class Task implements Runnable {
        Semaphore s = new Semaphore();

        public Task(Semaphore s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("du_pull_consumer");
                consumer.setNamesrvAddr("127.0.0.1:9876");
                consumer.start();

                Map<MessageQueue, Long> offsetTable = new HashMap<MessageQueue, Long>();
                Set<MessageQueue> messageQueueSet = consumer.fetchSubscribeMessageQueues("TOPIC_TEST");// 获取该Topic所有队列

                if (messageQueueSet != null && !messageQueueSet.isEmpty()) {
                    boolean noFoundFlag = false;
                    while (this.s.running) {
                        if (noFoundFlag) { // 没有找到消息，暂停一下消费
                            Thread.sleep(1000);
                        }

                        for (MessageQueue q : messageQueueSet) {
                            Long aLong = offsetTable.get(q);
                            PullResult pullResult = consumer.pull(q, "*", aLong, 20, 3000);
                            System.out.println("pullStatus: " + pullResult.getPullStatus());
                            switch (pullResult.getPullStatus()) {
                                case FOUND:
                                    doSomething(pullResult.getMsgFoundList());
                                    break;
                                case NO_NEW_MSG:
                                case OFFSET_ILLEGAL:
                                    noFoundFlag = true;
                                    break;
                                case NO_MATCHED_MSG:
                                    break;
                                default:
                                    continue;
                            }

                            // 提交
                            consumer.updateConsumeOffset(q, pullResult.getNextBeginOffset());
                        }
                        System.out.println("balance queue is empty：" + consumer.fetchMessageQueuesInBalance("TOPIC_TEST").isEmpty());
                    }
                } else {
                    System.out.println("end, because queue is empty");
                }
                consumer.shutdown();
                System.out.println("consumer shutdown");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 拉取到消息后具体的处理逻辑
    private static void doSomething(List<MessageExt> msgs) {
        System.out.println("本次拉取到的消息条数：" + msgs.size());
    }

    public static long decivePulloffset(Map<MessageQueue, Long> offsetTable, MessageQueue queue, DefaultMQPullConsumer consumer) throws MQClientException {
        long offset = consumer.fetchConsumeOffset(queue, false);
        if (offset < 0) {
            offset = 0;
        }
        System.out.println("offset: " + offset);
        return offset;
    }


    static class Semaphore {
        public volatile boolean running = true;
    }
}
