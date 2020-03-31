package com.jrtc.base.entity.bo;

import java.io.Serializable;

/**
 * (ConsultImg)实体类
 *
 * @author makejava
 * @since 2020-03-31 14:03:41
 */
public class ConsultImgBO implements Serializable {
    private static final long serialVersionUID = 895519524862792322L;
    /**
    * 咨询图片
    */
    private Long id;
    
    private Long cId;
    
    private String img;


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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}