package com.jrtc.base.entity.bo;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.Date;

/**
 * (TalkComment)实体类
 *
 * @author makejava
 * @since 2020-03-29 18:38:47
 */
public class TalkCommentBO implements Serializable {
    private static final long serialVersionUID = 883648316189977213L;
    /**
    * 评论表
    */
    private Long id;
    /**
    * 说说id
    */
    private Long tId;
    /**
    * 评论内容
    */
    private String content;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 评论用户名
    */
    private String userName;
    /**
    * 评论的用户头像
    */
    private String userHead;
    /**
    * 创建时间
    */
    private Date createTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 回复
     * @return
     */
    IPage<TalkReplyBO> talkReply;

    public IPage<TalkReplyBO> getTalkReply() {
        return talkReply;
    }

    public void setTalkReply(IPage<TalkReplyBO> talkReply) {
        this.talkReply = talkReply;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTId() {
        return tId;
    }

    public void setTId(Long tId) {
        this.tId = tId;
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