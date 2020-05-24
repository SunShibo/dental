package com.jrtc.base.entity.bo;

import java.util.List;

public class PatientBO {
    private Long id;
    private String stage;
    private String phone;
    private int consult;
    private String head;
    private String name;
    private String diagnose;
    //临床操作
    private List<ClinicalOperation> clinicalOperations;

    public List<ClinicalOperation> getClinicalOperations() {
        return clinicalOperations;
    }

    public void setClinicalOperations(List<ClinicalOperation> clinicalOperations) {
        this.clinicalOperations = clinicalOperations;
    }


    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getConsult() {
        return consult;
    }

    public void setConsult(int consult) {
        this.consult = consult;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
