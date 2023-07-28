package com.ysan.xml.replacedMethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @description
 * @since 2023/7/4 10:34
 **/
public class TestMethodReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我替换了原有的方法！");
        return null;
    }
}
