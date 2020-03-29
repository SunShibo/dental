package com.jrtc.controllerapi;


import com.jrtc.base.entity.bo.SchemeBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerapi.base.BaseCotroller;
import com.jrtc.service.SchemeService;
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
@RequestMapping("/scheme")
public class SchemeController extends BaseCotroller {
    static final Logger log = LoggerFactory.getLogger(SchemeController.class);

    @Autowired
    private SchemeService schemeService;

    /**
     * 查询方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryScheme" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, Long userId) {
        if(!verifyParam(userId)){
            return ResultDTOBuilder.failure("00001");
        }
        List<SchemeBO> schemeBOS = schemeService.queryAllByUserId(userId);
        return ResultDTOBuilder.success(schemeBOS);
    }


}