package com.ysan.security.controller;

import com.ysan.security.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 * @description
 * @since 2023/3/10 16:38
 **/


@Controller
public class HealthRecordController {

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/healthrecord")
    public String healthTest(Authentication a, Model model) {
        String name = a.getName();
        model.addAttribute("username", name);
        model.addAttribute("healthRecords", healthRecordService.getHealthRecordsByUsername(name));
        return "health_record";
    }
}
