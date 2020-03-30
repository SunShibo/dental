package com.jrtc.base.entity.bo;

import java.io.Serializable;

/**
 * (TalkImg)实体类
 *
 * @author makejava
 * @since 2020-03-29 18:38:55
 */
public class TalkImgBO implements Serializable {
    private static final long serialVersionUID = -60437793652528339L;
    
    private Long id;
    /**
    * 说说Id
    */
    private Long tId;
    /**
    * 图片
    */
    private String img;


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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}