package com.jrtc.dao;

import com.jrtc.base.entity.bo.TestBO;

public class TestDAO {
    public TestBO getTestBo(String name){
        TestBO testBO=new TestBO();
        testBO.setName(name);
        return testBO;
    }
}
