package com.ysan.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Administrator
 * @description
 * @since 2023/7/10 10:19
 **/
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
