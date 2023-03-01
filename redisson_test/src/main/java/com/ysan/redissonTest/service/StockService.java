package com.ysan.redissonTest.service;

/**
 * @author
 * @date
 */
public interface StockService {

    int getByProduct(Integer productId);

    boolean decrease(Integer productId);

}
