package com.ysan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @description
 * @since 2023/2/2 11:17
 **/
public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * 在目标Handler(方法)执行前执行
     * 返回true:执行Handler方法
     * 返回false:阻止目标Handler方法执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("2.目标Handler执行前执行MyInterceptor2---->preHandle方法...");
        return true;
    }

    /**
     * 在目标Handler(方法)执行后，视图生成前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("3.目标Handler执行后，视图执行前执行MyInterceptor2---->postHandle方法...");
    }

    /**
     * 在目标方法执行后，视图生成后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("5.目标Handler执行后，视图执行后执行MyInterceptor2---->afterCompletion方法...");
    }
}


