package com.jrtc.controllerapi;

import com.jrtc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("test")
    public String test(){
        return testService.getTestBo().getName();
    }
}
