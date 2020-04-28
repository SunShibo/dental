package com.jrtc.base.entity.bo;

import java.io.Serializable;

/**
 * (Doc)实体类
 *
 * @author makejava
 * @since 2020-04-28 14:17:03
 */
public class DocBO implements Serializable {
    private static final long serialVersionUID = 365726884779503214L;
    
    private Long id;
    
    private String title;
    
    private String content;
    /**
    * 文章/文本 article/text
    */
    private String type;
    
    private Long aId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAId() {
        return aId;
    }

    public void setAId(Long aId) {
        this.aId = aId;
    }

}