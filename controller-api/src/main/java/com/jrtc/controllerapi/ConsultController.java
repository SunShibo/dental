package com.jrtc.controllerapi;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.ConsultBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.ConsultService;
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
@RequestMapping("/consult")
public class ConsultController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(ConsultController.class);


    @Autowired
    private ConsultService consultService;


    /**
     * 添加/回复咨询
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/addConsult", method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, ConsultBO consultBO, String imgJsonStr) {
        if (!verifyParam(consultBO.getUserId(),consultBO.getContent(),consultBO.getCation())) {
            return ResultDTOBuilder.failure("00001");
        }
        consultService.insert(consultBO, imgJsonStr);
        return ResultDTOBuilder.success();
    }



    /**
     * 删除咨询
     */
    /**
     * 添加咨询
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/delConsult", method = RequestMethod.POST)
    public ResultDTO delConsult(HttpServletResponse response, HttpServletRequest request,Long id) {
        if(id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        ConsultBO consultBO = consultService.queryById(id);
        if(consultBO!=null){
            consultBO.setStatus(Constants.NO.getValue());
            consultService.update(consultBO);
        }
        return ResultDTOBuilder.success();
    }


    /**
     * 已读咨询/回复
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/updConsult", method = RequestMethod.POST)
    public ResultDTO updConsult(HttpServletResponse response, HttpServletRequest request,Long id) {
        if(id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        ConsultBO consultBO = consultService.queryById(id);
        if(consultBO!=null){
            consultBO.setRead(Constants.YES.getValue());
            consultService.update(consultBO);
        }
        return ResultDTOBuilder.success();
    }


    /**
     * 查询医生新消息
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryReply", method = RequestMethod.POST)
    public ResultDTO queryReply(HttpServletResponse response, HttpServletRequest request) {
        UserBO loginUser = getLoginUser(request);
        int count = consultService.queryReply(loginUser.getId(),"doctor");
        return ResultDTOBuilder.success(count);
    }




    /**
     * 查询记录
     */
    @RequestMapping(value = "/queryConsult", method = RequestMethod.POST)
    public ResultDTO queryConsult(HttpServletResponse response, HttpServletRequest request, PageUtil pageUtil,Long userId,String cation) {
        if (!verifyParam(userId)) {
            return ResultDTOBuilder.failure("00001");
        }
        IPage<ConsultBO> consultBOIPage = consultService.queryAllByLimit(pageUtil, userId,cation);
        return ResultDTOBuilder.success(consultBOIPage);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public ResultDTO getInfo(HttpServletResponse response, HttpServletRequest request, ConsultBO consultBO) {
        if (!verifyParam(consultBO.getPid())) {
            return ResultDTOBuilder.failure("00001");
        }
        List<ConsultBO> consultBOList = consultService.queryAll(consultBO);
        return ResultDTOBuilder.success(consultBOList);
    }



    /**
     * 查询记录总数
     */
    @RequestMapping(value = "/queryCount", method = RequestMethod.POST)
    public ResultDTO queryCount(HttpServletResponse response, HttpServletRequest request, Long userId) {
        if (!verifyParam(userId)) {
            return ResultDTOBuilder.failure("00001");
        }
        int count = consultService.queryCount(userId);
        return ResultDTOBuilder.success(count);
    }

}