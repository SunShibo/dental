package com.jrtc.base.entity.dto;

import java.io.Serializable;

public class ResultDTO implements Serializable {
    public boolean success = true;
    public String code ;
    public String msg ;
    public Object data ;

    public ResultDTO() {
    }

    public ResultDTO(boolean success, String code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
