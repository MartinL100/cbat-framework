package com.cbat.exception.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CbatWebMvcConfiger implements WebMvcConfigurer {
    @Autowired
    private  CbatHandlerInterceptor cbatHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cbatHandlerInterceptor)
        .addPathPatterns("/**");
    }

}
