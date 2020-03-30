package com.jrtc.base.entity.bo;

import java.io.Serializable;
import java.util.List;

/**
 * (Brace)实体类
 *
 * @author makejava
 * @since 2020-03-30 18:55:06
 */
public class BraceBO implements Serializable {
    private static final long serialVersionUID = 850874042574202273L;
    /**
    * 牙套
    */
    private Long id;
    
    private Long userId;
    /**
    * 阶段名称
    */
    private String stage;
    /**
    * 制作状态 未确认 以确认 以制作
    */
    private String status;

    private String make;

    private List<BraceMsgBO> braces;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BraceMsgBO> getBraces() {
        return braces;
    }

    public void setBraces(List<BraceMsgBO> braces) {

        this.braces = braces;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}