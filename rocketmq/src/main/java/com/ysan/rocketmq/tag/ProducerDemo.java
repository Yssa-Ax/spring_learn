package com.ysan.rocketmq.tag;

import com.alibaba.fastjson.JSON;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @author Administrator
 * @description
 * @since 2023/8/7 10:05
 **/
public class ProducerDemo {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("dw_test_producer_group");
        producer.setNamesrvAddr("49.235.108.159:9876");
        producer.start();

        Order1 order = new Order1();
        order.setId(1001L);
        order.setOrderNo("2020072823270500003");
        order.setBuyerId(1L);
        order.setSellerId(2L);
        order.setTotalPrice(10000L);
        order.setStatus(0);

        Message msg = new Message("dw_test", "c", "2020072823270500003", JSON.toJSONString(order).getBytes());
        System.out.printf("%s%n", producer.send(msg));

        order.setStatus(1);
        msg = new Message("dw_test", "w", "2020072823270500003", JSON.toJSONString(order).getBytes());
        System.out.printf("%s%n", producer.send(msg));

//        producer.shutdown();




    }
}


class Order1 {
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