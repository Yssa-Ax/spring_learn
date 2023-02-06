package com.ysan;

import com.ysan.entity.Student;
import com.ysan.service.CarService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @description
 * @since 2023/1/30 15:56
 **/
public class SpringTest {

    @Test
    public void test(){
        //读取配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = applicationContext.getBean("stu", Student.class);
//        Address address = applicationContext.getBean("address", Address.class);
        System.out.println(stu);

    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        CarService stu = applicationContext.getBean("carServiceImpl", CarService.class);
        stu.add(10 ,3);
        stu.sub(10 ,3);
        stu.mul(10 ,3);
        stu.div(10 ,3);
    }

}
