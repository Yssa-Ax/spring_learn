package com.ysan.rocketmq.queueSelector;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @since 2023/8/4 16:39
 **/
public class QueueDemo {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("dw_test_producer_group");
        producer.setNamesrvAddr("49.235.108.159:9876");
        producer.start();

        // 订单实体
        Order order = new Order();
        order.setId(1001L);
        order.setOrderNo("2020072823270500001");
        order.setBuyerId(1L);
        order.setSellerId(1L);
        order.setTotalPrice(10000L);
        order.setStatus(0);
        System.out.printf("%s%n", sendMsg(producer, order));
        //订单状态发生变更
        order.setStatus(1);
        //重新发生消息
        System.out.printf("%s%n", sendMsg(producer, order));
        producer.shutdown();
    }


    public static SendResult sendMsg(DefaultMQProducer producer, Order order) throws Exception{
        // 这里为了方便查找消息，在构建消息的时候，使用订单编号为 key，这样可以通过订单号编号查询信息。
        Message msg = new Message("order_topic", null, order.getOrderNo(), JSON.toJSONString(order).getBytes());
        return producer.send(msg, new MessageQueueSelector() {
            // 根据订单编号的 hashCode 进行队列选择
            @Override
            public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                // 根据订单编号的 hashcode 进行队列选择
                if(mqs == null || mqs.isEmpty()) {
                    return null;
                }
                int index = Math.abs(arg.hashCode()) % mqs.size();
                return mqs.get(index < 0 ? 0 :index);
            }
        }, order.getOrderNo());
    }
}


class Order {
    private Long id;
    private String orderNo;
    private Long buyerId;
    private Long sellerId;
    private Long totalPrice;
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}