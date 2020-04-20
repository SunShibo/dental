package com.jrtc.base.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 处理类似rest风格的接口，返回json
 */
@RestControllerAdvice
public class RestExceptionHandler{
    static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    /**
     * 返回json
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultDTO restExceptionHandle(Exception e) {
        log.error("error:{}",e);
        return ResultDTOBuilder.failure("00003");
    }


}