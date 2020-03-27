package com.jrtc.base.entity.bo;

import java.util.Date;

/**
 * (ArticleComment)实体类
 *
 * @author makejava
 * @since 2020-03-27 16:17:09
 */
public class ArticleCommentBO {
    private static final long serialVersionUID = -57095340849407476L;
    /**
    * 评论表
    */
    private Long id;
    /**
    * 父id
    */
    private Long pId;
    /**
    * 文章id
    */
    private Long cId;
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
    private String head;

    /**
    * 状态
    */
    private String status;
    /**
    * 内容
    */
    private String content;
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

    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}