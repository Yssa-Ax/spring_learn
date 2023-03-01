package com.ysan.controller;


import com.ysan.pojo.Course;
import com.ysan.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zengyihong
 * @create 2022--07--11 16:14
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseList");
        modelAndView.addObject("list", courseRepository.findAll());

        return modelAndView;
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        courseRepository.deleteById(id);
        return "redirect:/course/findAll";
    }
    @PostMapping("/save")
    public String save(Course course) {
        courseRepository.saveOrUpdate(course);
        /**
         * 添加信息后要求返回列表页面
         * 重定向
         */
        return "redirect:/course/findAll";
    }


    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("courser", courseRepository.findById(id));
        return modelAndView;
    }
    @PutMapping("/update")
    public String update(Course course){
        courseRepository.saveOrUpdate(course);
        return "redirect:/course/findAll";
    }


}

