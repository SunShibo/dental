package com.jrtc.base.entity.bo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Banner)实体类
 *
 * @author makejava
 * @since 2020-03-27 22:45:19
 */
public class BannerBO implements Serializable {
    private static final long serialVersionUID = 436991378936746140L;
    /**
    * banner
    */
    private Long id;
    
    private Integer sort;
    /**
    * 跳转的文章id
    */
    private Long tId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getTId() {
        return tId;
    }

    public void setTId(Long tId) {
        this.tId = tId;
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