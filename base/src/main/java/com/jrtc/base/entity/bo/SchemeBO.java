package com.jrtc.base.entity.bo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Scheme)实体类
 *
 * @author makejava
 * @since 2020-03-28 18:19:39
 */
public class SchemeBO implements Serializable {
    private static final long serialVersionUID = 907915167873816199L;
    /**
    * 方案
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 图片路径
    */
    private String img;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}