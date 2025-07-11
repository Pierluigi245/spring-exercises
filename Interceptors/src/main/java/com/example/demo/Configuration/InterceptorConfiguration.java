package com.example.demo.Configuration;

import com.example.demo.interceptors.ApiLoggingInterceptor;
import com.example.demo.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private LegacyInterceptor legacyInterceptor ;

    @Autowired
    private ApiLoggingInterceptor loggingInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy/**");

    }


}
