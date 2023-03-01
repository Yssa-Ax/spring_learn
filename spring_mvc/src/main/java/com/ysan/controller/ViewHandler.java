package com.ysan.controller;

import com.ysan.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/2/1 15:05
 **/

@Controller
@RequestMapping("/view")
@SessionAttributes(value = "user")
public class ViewHandler {

    @RequestMapping("/map")
    public String map(Map<String, Object> objectMap){
        /**
         * 创建一个User对象，希望把它传给JSP页面
         */
        User user = new User();
        user.setId(1);
        user.setName("张三");
        objectMap.put("user", user);
        return "show";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        model.addAttribute("user", user);
        return "show";
    }

    @RequestMapping("/mav1")
    public ModelAndView modelAndView() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("王五");
        // 填充业务数据
        mav.addObject("user", user);
        // 填充视图信息
        mav.setViewName("show");
        return mav;
    }

    @RequestMapping("/mav2")
    public ModelAndView modelAndView2(){
        ModelAndView mav = new ModelAndView();
        User user = new User();
        user.setId(4);
        user.setName("赵六");
        // 填充业务数据
        mav.addObject("user", user);
        // 绑定视图信息
        View view = new InternalResourceView("/show.jsp");
        mav.setView(view);
        return mav;
    }

    @RequestMapping("/mav3")
    public ModelAndView modelAndView3(){
        // 直接写上视图名字
        ModelAndView mav = new ModelAndView("show");
        User user = new User();
        user.setId(5);
        user.setName("赵三");
        // 填充业务数据
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/mav4")
    public ModelAndView modelAndView4(){
        View view = new InternalResourceView("/show.jsp");
        // 传view对象
        ModelAndView mav = new ModelAndView(view);
        User user = new User();
        user.setId(5);
        user.setName("赵7");
        // 填充业务数据
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/mav5")
    public ModelAndView modelAndView5(){
        HashMap<String, Object> map = new HashMap<>();
        User user = new User();
        user.setId(5);
        user.setName("赵g");
        map.put("user", user);
        ModelAndView modelAndView = new ModelAndView("show", map);
        return modelAndView;
    }


    @RequestMapping("/servlet")
    public String request(HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        request.setAttribute("user", user);
        return "show";
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "show";
    }

    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }


    @ModelAttribute
    public void getUser(Model model){
        User user=new User();
        user.setId(1);
        user.setName("张三");
        model.addAttribute("user",user);
    }


    @RequestMapping("/session")
    public String session(HttpSession session){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        session.setAttribute("user",user);
        return "show";
    }


    @RequestMapping("/sessionAnnotation")
    private ModelAndView sessionAnnotation(){
        ModelAndView mav = new ModelAndView("show");
        User user = new User();
        user.setId(1);
        user.setName("张三");
        modelAndView().addObject("user", user);
        return mav;
    }

}
