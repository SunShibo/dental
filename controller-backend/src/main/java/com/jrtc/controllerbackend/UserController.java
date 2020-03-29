package com.jrtc.controllerbackend;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.DoctorBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseCotroller;
import com.jrtc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController extends BaseCotroller {
    static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     *
     * @param response
     * @param request
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/queryUser" ,method = RequestMethod.POST)
    public ResultDTO selectUser(HttpServletResponse response, HttpServletRequest request, PageUtil pageUtil,UserBO param) throws Exception {
        param.setDoctor(Constants.NO.getValue());
        IPage<UserBO> userBOIPage = userService.queryAll(pageUtil, param);
        return ResultDTOBuilder.success(userBOIPage);
    }

    /**
     * 修改用户信息
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST)
    public ResultDTO updateUser(HttpServletResponse response, HttpServletRequest request, UserBO userParam) {
        userService.update(userParam);
        return ResultDTOBuilder.success(userParam);
    }


    /**
     * 添加医生
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/addDoctor" , method = RequestMethod.POST)
    public ResultDTO addDoctor(HttpServletResponse response, HttpServletRequest request, UserBO userParam) {
        userParam.setDoctor(Constants.YES.getValue());
        userParam.setCreateTime(new Date());
        userService.insert(userParam);
        return ResultDTOBuilder.success();
    }


    /**
     * 查询医生
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryDoctor" , method = RequestMethod.POST)
    public ResultDTO queryDoctor(HttpServletResponse response, HttpServletRequest request,PageUtil pageUtil,UserBO param) {
        param.setDoctor(Constants.YES.getValue());
        IPage<UserBO> userBOIPage = userService.queryAll(pageUtil, param);
        return ResultDTOBuilder.success(userBOIPage);
    }


    /**
     * 查询医生ID名称
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryDocId" , method = RequestMethod.POST)
    public ResultDTO queryDocId(HttpServletResponse response, HttpServletRequest request) {
        List<DoctorBO> docs=userService.queryDocId();
        return ResultDTOBuilder.success(docs);
    }

}