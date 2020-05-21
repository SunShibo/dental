package com.jrtc.base.entity.bo;

import java.io.Serializable;

/**
 * (ClinicalOperation)实体类
 *
 * @author makejava
 * @since 2020-05-20 20:07:20
 */
public class ClinicalOperation implements Serializable {
    private static final long serialVersionUID = -89914327107184778L;
    
    private Integer id;
    
    private String icon;
    
    private String type;
    
    private String content;
    
    private String pic;
    
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}