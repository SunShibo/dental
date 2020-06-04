package com.jrtc.base.entity.bo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Inform)实体类
 *
 * @author makejava
 * @since 2020-03-30 16:09:27
 */
public class InformBO implements Serializable {
    private static final long serialVersionUID = 211765876088056269L;
    
    private Long id;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
    * 用户id
    */
    private Long userId;
    private String openId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 已读/未读
    */
    private String status;
    /**
    * 内容
    */
    private String content;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}