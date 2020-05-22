package com.jrtc.base.entity.bo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Consult)实体类
 *
 * @author makejava
 * @since 2020-03-31 14:53:04
 */
public class ConsultBO implements Serializable {
    private static final long serialVersionUID = 285883490482894819L;
    
    private Long id;
    
    private Long userId;
    
    private String status;
    
    private Date createTime;
    
    private String content;
    
    private String read;
    /**
    * 标识
    */
    private String cation;
    
    private Long doctorId;

    private Long pid;

    private List<ConsultImgBO> imgs;

    private String consultStatus;//是否有新消息


    public String getConsultStatus() {
        return consultStatus;
    }

    public void setConsultStatus(String consultStatus) {
        this.consultStatus = consultStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getCation() {
        return cation;
    }

    public void setCation(String cation) {
        this.cation = cation;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public List<ConsultImgBO> getImgs() {
        return imgs;
    }

    public void setImgs(List<ConsultImgBO> imgs) {
        this.imgs = imgs;
    }
}