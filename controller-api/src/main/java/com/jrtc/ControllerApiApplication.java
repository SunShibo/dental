package com.jrtc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.jrtc.dao"})
@EnableTransactionManagement
public class ControllerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApiApplication.class, args);
    }

}
