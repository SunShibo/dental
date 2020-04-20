package com.jrtc.controllerapi;


import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(DoctorController.class);


    @Autowired
    private UserService userService;


    /**
     * 查询患者
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryPatient", method = RequestMethod.POST)
    public ResultDTO queryPatient(HttpServletResponse response, HttpServletRequest request,String state,PageUtil pageUtil) {
        if (!verifyParam(state)) {
            return ResultDTOBuilder.failure("00001");
        }
        log.info("获取登录用户");
        UserBO loginUser = getLoginUser(request);
        log.info("调用service");
        Map<String, Object> resultMap = userService.queryPatient(state, loginUser.getId(), pageUtil);
        log.info("返回信息");
        return ResultDTOBuilder.success(resultMap);
    }




}