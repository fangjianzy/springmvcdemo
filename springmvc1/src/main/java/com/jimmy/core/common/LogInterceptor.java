package com.jimmy.core.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 日志拦截器
 * @author jimmy
 */
public class LogInterceptor implements HandlerInterceptor{

    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.err.println("LogInterceptor preHandle");
        return true;
    }
    
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.err.println("LogInterceptor postHandle");
    }
    
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.err.println("LogInterceptor afterCompletion");
    }
}