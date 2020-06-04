package com.jrtc.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getAccessInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**")
//                .excludePathPatterns("/**.**");
//
//    }

    @Bean
    public LogCostInterceptor getAccessInterceptor(){
        return new LogCostInterceptor();
    }




}