package com.jrtc.service;

import com.jrtc.base.entity.bo.KeyValueBO;
import com.jrtc.dao.KeyValueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("keyValueService")
@Transactional
public class KeyValueService {

    @Autowired
    KeyValueDAO keyValueDAO;

    public Integer updKeyValue(KeyValueBO keyValueBO){
        return keyValueDAO.updKeyValue(keyValueBO);
    }

    public List<KeyValueBO> getKeyValueList(){
        return keyValueDAO.getKeyValueList();
    }

    public KeyValueBO getValueByKey(String key){
        return keyValueDAO.getValueByKey(key);
    }
}
