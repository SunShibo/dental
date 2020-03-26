package com.jrtc.dao;


import com.jrtc.base.entity.bo.KeyValueBO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KeyValueDAO {

    Integer updKeyValue(KeyValueBO keyValueBO);

    List<KeyValueBO> getKeyValueList();

    KeyValueBO getValueByKey(String key);

}
