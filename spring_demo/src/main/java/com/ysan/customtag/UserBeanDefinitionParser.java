package com.ysan.customtag;

import com.ysan.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author Administrator
 * @description
 * @since 2023/7/6 17:51
 **/
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    // Element 对应的类
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    // 从 element 中解析并提取对应得元素

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        // 将提取得数据放入到 BeanDefinitionBuilder 中，待到完成所有 bean 得解析后统一注册到 beanFactory 中
        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }

        if (StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
    }
}
