package com.jrtc.base.entity.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * (TalkReply)实体类
 *
 * @author makejava
 * @since 2020-03-29 18:39:07
 */
public class TalkReplyBO implements Serializable {
    private static final long serialVersionUID = 438483946985486558L;
    /**
    * 说说评论回复
    */
    private Long id;
    /**
    * 评论id
    */
    private Long cId;
    /**
    * 回复用户id
    */
    private Long replayId;
    /**
    * 回复目标用户名
    */
    private String replayName;
    /**
    * 回复目标用户头像
    */
    private String replayHead;
    /**
    * 回复内容
    */
    private String content;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户头像
    */
    private String userHead;
    /**
    * 创建时间
    */
    private Date createTime;


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

    public Long getReplayId() {
        return replayId;
    }

    public void setReplayId(Long replayId) {
        this.replayId = replayId;
    }

    public String getReplayName() {
        return replayName;
    }

    public void setReplayName(String replayName) {
        this.replayName = replayName;
    }

    public String getReplayHead() {
        return replayHead;
    }

    public void setReplayHead(String replayHead) {
        this.replayHead = replayHead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}