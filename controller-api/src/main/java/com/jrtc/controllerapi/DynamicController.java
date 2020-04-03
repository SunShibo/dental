package com.jrtc.controllerapi;


import com.jrtc.base.entity.bo.DynamicBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.DynamicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/dynamic")
public class DynamicController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(DynamicController.class);

    @Autowired
    private DynamicService dynamicService;

    /**
     * 查询方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryDynamic" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, Long userId,String type) {
        if(!verifyParam(userId)){
            return ResultDTOBuilder.failure("00001");
        }
        List<DynamicBO> dynamicBOS = dynamicService.queryAllByType(userId, type);
        return ResultDTOBuilder.success(dynamicBOS);
    }


}