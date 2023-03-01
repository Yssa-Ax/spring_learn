package com.ysan.redissonTest.controller;


import com.ysan.redissonTest.domain.request.OrderRequestVO;
import com.ysan.redissonTest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 这应该是一个业务网关服务
     */
    @PostMapping("/create")
    public boolean create(@RequestBody OrderRequestVO orderRequestVO,
                          @RequestHeader(name = "userid") Integer userId) {
        orderService.save(userId, orderRequestVO.getProductId());
        return true;
    }

}
