package com.myy.securitydemo.config;

import com.myy.securitydemo.interceptor.PageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebmvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PageInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
