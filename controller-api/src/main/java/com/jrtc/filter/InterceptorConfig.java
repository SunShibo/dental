package com.jrtc.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {


   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAccessInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public LogCostInterceptor getAccessInterceptor(){
        return new LogCostInterceptor();
    }




}