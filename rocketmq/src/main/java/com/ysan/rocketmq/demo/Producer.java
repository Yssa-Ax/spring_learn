package com.ysan.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/7/31 10:03
 **/
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("49.235.108.159:9876");
        producer.start();

        // 发送单条消息
        Message msg = new Message("TOPIC_TEST", "hello rocketmq".getBytes());
        SendResult sendResult = null;
        sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);

        // 发送带 key 的消息
        msg = new Message("TOPIC_TEST", null, "ODS2020072615490001", "{\"id\":1, \"orderNo\":\"ODS2020072615490001\",\"buyerId\":1,\"sellerId\":1  }".getBytes());
        sendResult = producer.send(msg);
        //　输出结果
        System.out.printf("%s%n", sendResult);
        //　批量发送
        List<Message> msgs = new ArrayList<>();
        msgs.add( new Message("TOPIC_TEST", null, "ODS2020072615490002", "{\"id\":2, \"orderNo\":\"ODS2020072615490002\",\"buyerId\":1,\"sellerId\":3  }".getBytes()) );
        msgs.add( new Message("TOPIC_TEST", null, "ODS2020072615490003", "{\"id\":4, \"orderNo\":\"ODS2020072615490003\",\"buyerId\":2,\"sellerId\":4  }".getBytes()) );
        sendResult = producer.send(msgs);
        System.out.printf("%s%n", sendResult);
        //　使用完毕后，关闭消息发送者
        producer.shutdown();

    }
}
