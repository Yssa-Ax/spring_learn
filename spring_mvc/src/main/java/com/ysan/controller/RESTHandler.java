package com.ysan.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @description
 * @since 2023/2/1 17:52
 **/
@Component
@RequestMapping("/rest")
public class RESTHandler {
    //    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @GetMapping("/find")
    @ResponseBody
    public String find(){
        return "Hello";
    }
    @PostMapping("/save")
    public void save(){

    }
    @PutMapping("/update")
    public void update(){

    }
    @DeleteMapping("/delete")
    public void delete(){

    }
}

