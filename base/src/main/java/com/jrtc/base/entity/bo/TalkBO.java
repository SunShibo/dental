package com.jrtc.base.entity.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Talk)实体类
 *
 * @author makejava
 * @since 2020-03-29 18:38:38
 */
public class TalkBO implements Serializable {
    private static final long serialVersionUID = 998566906263306304L;
    /**
    * 说说
    */
    private Long id;
    /**
    * 内容
    */
    private String content;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 状态
    */
    private String status;
    
    private Long userId;
    
    private String userName;
    
    private String userHead;

    private String like;

    private List<TalkImgBO> imgs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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


    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public List<TalkImgBO> getImgs() {
        return imgs;
    }

    public void setImgs(List<TalkImgBO> imgs) {
        this.imgs = imgs;
    }
}