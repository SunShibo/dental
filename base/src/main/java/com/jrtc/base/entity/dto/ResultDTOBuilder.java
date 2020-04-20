package com.jrtc.base.entity.dto;


import com.jrtc.base.config.constants.ResponseMsg;

public  class  ResultDTOBuilder {

    public ResultDTOBuilder() {}

    public static  ResultDTO success() {
        return new ResultDTO(true,"00000" , ResponseMsg.msg.get("00000"),"");
    }



    public static  ResultDTO success(Object data) {
        return new ResultDTO(true,"00000" ,ResponseMsg.msg.get("00000"),data);
    }

    public static  ResultDTO failure(String code) {
        return new ResultDTO(false,code ,ResponseMsg.msg.get(code),"");
    }

    public static  ResultDTO failure(String code,String msg) {
        return new ResultDTO(false,code ,msg,"");
    }


}