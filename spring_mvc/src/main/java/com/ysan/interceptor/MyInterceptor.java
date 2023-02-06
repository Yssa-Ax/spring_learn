package com.ysan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @description
 * @since 2023/2/2 10:42
 **/
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 
     * @param request [null] 
     * @param response [null] 
     * @param handler [null]
     * @return boolean
     * @since 2023/2/2 10:42
     * @author Administrator
     * @description 在目标Handler(方法)执行前执行  返回true，执行Handler方法，返回false，阻止目标Handler方法执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("目标Handler执行前执行MyInterceptor--------->preHandle");
        return true;
    }

    /**
     *
     * @param request [null]
     * @param response [null]
     * @param handler [null]
     * @param modelAndView [null]
     * @return void
     * @since 2023/2/2 10:45
     * @author Administrator
     * @description 在目标Handler(方法)执行后，视图生成前执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("目标Handler执行后，视图执行前执行MyInterceptor--------->postHandle");
    }

    /**
     * 
     * @param request [null] 
     * @param response [null] 
     * @param handler [null] 
     * @param ex [null] 
     * @return void
     * @since 2023/2/2 10:46
     * @author Administrator
     * @description 在目标方法执行后，视图生成后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("目标Handler执行后，视图执行后执行MyInterceptor--------->afterCompletion");
    }
}
