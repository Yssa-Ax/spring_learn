package com.ysan.service.impl;
import com.ysan.service.CarService;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 10:32
 **/
@Component
public class CarServiceImpl implements CarService {
    @Override
    public int add(int num1, int num2) {
        int res = num1 + num2;
        return res;
    }

    @Override
    public int sub(int num1, int num2) {
        int res = num1 - num2;
        return res;
    }

    @Override
    public int mul(int num1, int num2) {
        int res = num1 * num2;
        return res;
    }

    @Override
    public int div(int num1, int num2) {
        int res=num1/num2;
        return res;
    }
}
