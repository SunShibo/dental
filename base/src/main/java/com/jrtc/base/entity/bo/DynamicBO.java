package com.jrtc.base.entity.bo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Dynamic)实体类
 *
 * @author makejava
 * @since 2020-03-29 15:57:30
 */
public class DynamicBO implements Serializable {
    private static final long serialVersionUID = 312529139978821986L;
    /**
    * 动态方案
    */
    private Long id;
    
    private Long userId;
    /**
    * 类型 front正面 ，left左面 ，right右面 above上面，below下面
    */
    private String type;
    /**
    * 图片路径
    */
    private String img;
    
    private Date createTime;
    /**
    * 状态
    */
    private Long sort;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }
}