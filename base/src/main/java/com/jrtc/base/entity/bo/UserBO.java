package com.jrtc.base.entity.bo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-26 01:25:28
 */
public class UserBO implements Serializable {

    private String scheme;


    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    private Long id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 手机号
    */
    private String phone;
    /**
    * 性别
    */
    private String gender;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 地区
    */
    private String region;
    /**
    * 生日
    */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;
    /**
    * 机构
    */
    private String organ;
    /**
    * 诊断 多个用 ，分割 
    */
    private String diagnose;
    
    private Date createTime;
    /**
    * 密码
    */
    private String password;
    /**
    * 微信id
    */
    private String wxid;
    /**
    * 医生id
    */
    private Long doctorId;
    /**
    * 诊断状态
    */
    private String state;

    /**
     * 头像
     */
    private String head;

    /**
     * 账号状态
     */
    private String status;

    /**
     * 医生标识
     */
    private String doctor;

    //方案确定状态
    private String braceStatus;



    public String getBraceStatus() {
        return braceStatus;
    }

    public void setBraceStatus(String braceStatus) {
        this.braceStatus = braceStatus;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

}