package com.jrtc.base.util;

import com.aliyuncs.utils.StringUtils;

public class PageUtil {
    private Long pageNo=new Long(1);
    private Long pageSize=new Long(10);


    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        if(!StringUtils.isEmpty(pageNo)){
            this.pageNo = Long.parseLong(pageNo);
        }

    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        if(!StringUtils.isEmpty(pageSize)){
            this.pageSize = Long.parseLong(pageSize);
        }

    }
}
