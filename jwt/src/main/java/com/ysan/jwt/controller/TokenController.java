package com.ysan.jwt.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ysan.jwt.utils.JWTUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 15:11
 **/
@RestController
public class TokenController {

    @PostMapping("/login")
    public String login (@RequestParam("username") String username,
                         @RequestParam("password") String password){
        JSONObject json = new JSONObject();
        Map<String, String> params = new HashMap<String, String>();
        String uuid = UUID.randomUUID().toString();
        params.put("key", uuid);
        String token = JWTUtils.getToken(params);
        if (!StringUtils.isEmpty(token)){
            json.putOpt("token", token);
        }
        return json.toString();
    }


    /**
     * 需要 Token 验证的接口
     */
    @PostMapping("/info")
    public String info (){
        return "info" ;
    }

    /**
     * 根据请求头的token获取userId
     * @param request
     * @return
     */
    @GetMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request){
        DecodedJWT decodedJWT = JWTUtils.decode(request.getHeader("token"));
        String payload = decodedJWT.getPayload();
        return "payload";
    }

    /*
        为什么项目重启后，带着之前的token还可以访问到需要info等需要token验证的接口？
        答案：只要不过期，会一直存在，类似于redis
     */


}
