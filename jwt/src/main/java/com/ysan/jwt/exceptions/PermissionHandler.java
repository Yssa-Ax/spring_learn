package com.ysan.jwt.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

/**
 * @author Administrator
 * @description
 * @since 2023/3/1 15:05
 **/
@RestControllerAdvice
public class PermissionHandler {
    @ExceptionHandler(value = {SignatureException.class})
    @ResponseBody
    public String authorzationException(SignatureException e){
        return "这是一个全局处理异常 "  + e.getMessage();
    }
}
