package com.jrtc.service;

import com.jrtc.base.entity.bo.TestBO;
import com.jrtc.dao.TestDAO;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestBO getTestBo(){
        TestDAO testDAO=new TestDAO();
        return testDAO.getTestBo("WangYang");
    }

}
