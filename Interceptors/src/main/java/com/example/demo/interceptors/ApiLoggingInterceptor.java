package com.example.demo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ApiLoggingInterceptor.class) ;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("User-Agent " + request.getHeader("User-Agent"));

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.info("Ricevuta richiesta: " + request.getRequestURL().toString() + " | start time: " + startTime);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("Chiamato postHandle()");

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        logger.info("Ricevuta richiesta: " + request.getRequestURL().toString() + " | end time: " + endTime);
        logger.info("Richiesta:  " + request.getRequestURL().toString() + " | gestita in " + (endTime - startTime) + "ms");
    }

}




