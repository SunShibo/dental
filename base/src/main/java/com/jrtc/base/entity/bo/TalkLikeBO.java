package com.jrtc.base.entity.bo;

import java.io.Serializable;

/**
 * (TalkLike)实体类
 *
 * @author makejava
 * @since 2020-03-29 18:39:02
 */
public class TalkLikeBO implements Serializable {
    private static final long serialVersionUID = -22101888326274935L;
    /**
    * 用户点赞
    */
    private Long id;
    /**
    * 说说id
    */
    private Long cId;
    /**
    * 用户id
    */
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}