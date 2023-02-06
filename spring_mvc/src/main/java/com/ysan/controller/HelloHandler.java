package com.ysan.controller;

import com.ysan.pojo.User;
import com.ysan.pojo.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @description
 * @since 2023/1/31 16:05
 **/
@Controller
@RequestMapping("/hello")
public class HelloHandler {

    /**
     *
     * @return java.lang.String
     * @since 2023/1/31 16:06
     * @author Administrator
     * @description 当客户端访问index请求时，直接关联到这个方法，执行这个方法后，会返回结果
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(@RequestParam("num") Integer id, @RequestParam("str") String name){
        System.out.println("接收到了请求！,参数是id=" + id + ",name=" + name);
        // 返回逻辑视图，逻辑视图相当于视图的别名，通过这个找到物理视图，也就是真正的视图
        // 这个返回的只是页面的名称，不是完整的页面访问路径
        return "index";
    }

    /**
     *
     * @param id [null]
     * @param name [null]
     * @return java.lang.String
     * @since 2023/2/1 10:37
     * @author Administrator
     * @description restful风格
     */
    @RequestMapping("/restful/{id}/{name}")
    public String restful(@PathVariable("id") Integer id, @PathVariable("name") String name){
        System.out.println(id + "===" + name);
        return "index";
    }


    @RequestMapping("/cookie")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(User user){
        System.out.println(user);
        return user.toString();
    }


    @RequestMapping("/listType")
    @ResponseBody
    public String listType(UserList userList){
        StringBuffer buffer = new StringBuffer();
        for (User user:userList.getUserList()){
            buffer.append(user);
        }
        return "用户:"+buffer.toString();
    }

    @RequestMapping("/jsonType")
    @ResponseBody
    public User jsonType(@RequestBody User user) {
        return user;
    }


    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id", required = true) Integer id) {
        System.out.println("拦截的方法...");
        return "id=" + id;
    }




}
