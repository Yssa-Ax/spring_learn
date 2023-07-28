package com.ysan.xml.replacedMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @description
 * @since 2023/7/4 10:58
 **/
public class Client {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("replacer-method.xml");
        TestChangeMethod test = (TestChangeMethod) bf.getBean("testChangeMethod");
        test.changeMe();
    }
}
