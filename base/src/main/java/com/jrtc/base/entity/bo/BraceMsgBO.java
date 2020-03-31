package com.jrtc.base.entity.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * (BraceMsg)实体类
 *
 * @author makejava
 * @since 2020-03-30 18:55:16
 */
public class BraceMsgBO implements Serializable {
    private static final long serialVersionUID = 455923978351282002L;
    /**
    * 方案详情
    */
    private Long id;
    /**
    * 方案id
    */
    private Long bId;
    /**
    * 名称
    */
    private String name;
    /**
    * 佩戴天数
    */
    private Integer num;
    /**
    * 开始时间
    */
    private Date startTime;
    /**
    * 结束时间
    */
    private Date endTime;

    private String status;

    private String stage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBId() {
        return bId;
    }

    public void setBId(Long bId) {
        this.bId = bId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}