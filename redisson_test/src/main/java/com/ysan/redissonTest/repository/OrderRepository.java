package com.ysan.redissonTest.repository;

import com.ysan.redissonTest.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OrderRepository extends JpaSpecificationExecutor<OrderModel>, JpaRepository<OrderModel, Integer> {
}
