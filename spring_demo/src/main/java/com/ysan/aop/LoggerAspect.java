package com.ysan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 10:57
 **/

@Component
@Aspect
public class LoggerAspect {

    @Before("execution(public int com.ysan.service.impl.CarServiceImpl.*(..))")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(name + "方法的参数是：" + Arrays.toString(args));
    }

    @After("execution(public int com.ysan.service.impl.CarServiceImpl.*(..))")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行完毕");
    }

    @AfterReturning(value = "execution(public int com.ysan.service.impl.CarServiceImpl.*(..))", returning = "rs")
    public void afterReturning(JoinPoint joinPoint, Object rs){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行的结果是:" + rs);
    }

    @AfterThrowing(value = "execution(public int com.ysan.service.impl.CarServiceImpl.*(..))", throwing = "ex")
    public void afterReturning(JoinPoint joinPoint, Exception ex){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法抛出异常:" + ex);
    }
}
