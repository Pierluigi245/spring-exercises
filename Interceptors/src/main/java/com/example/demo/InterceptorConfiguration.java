package com.example.demo;

import com.example.demo.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private LegacyInterceptor legacyInterceptor ;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy/**");
    }
}
