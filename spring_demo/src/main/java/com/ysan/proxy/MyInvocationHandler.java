package com.ysan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 10:46
 **/
public class MyInvocationHandler implements InvocationHandler {
    // 委托对象
    private Object object = null;

    // 返回代理对象
    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 实现业务代码和非业务代码的解耦合
        System.out.println(method.getName() + "方法的参数是：" + Arrays.toString(args));
        Object res = method.invoke(this.object, args);
        System.out.println(method.getName() + "方法的结果是:" + res);
        return res;
    }
}
