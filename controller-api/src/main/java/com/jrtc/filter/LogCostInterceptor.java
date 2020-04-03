package com.jrtc.filter;

import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.JsonUtils;
import com.jrtc.controllerapi.ConsultController;
import com.jrtc.controllerapi.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogCostInterceptor  implements HandlerInterceptor {
    static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
    @Autowired
    BaseController baseController;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserBO loginUser = baseController.getLoginUser(httpServletRequest);
        if(loginUser==null){
            baseController.responsePrint(httpServletResponse, JsonUtils.getJsonString4JavaPOJO( ResultDTOBuilder.failure("00002")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}