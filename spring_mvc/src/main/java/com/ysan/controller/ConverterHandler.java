package com.ysan.controller;

import com.ysan.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Administrator
 * @description
 * @since 2023/2/1 16:28
 **/
@Controller
@RequestMapping("/converter")
public class ConverterHandler {

    @RequestMapping("/date")
    @ResponseBody
    public String data(Date date){
        return date.toString();
    }

    @RequestMapping("/student")
    @ResponseBody
    public String student(Student student, HttpServletResponse response) {
        response.setContentType("text/json;charset=UTF-8");
        return student.toString();
    }
}
