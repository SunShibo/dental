package com.jrtc.controllerapi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerapi.base.BaseCotroller;
import com.jrtc.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户通知
 */
@RestController
@RequestMapping("/inform")
public class InformController extends BaseCotroller {

    @Autowired
    private InformService informService;

    /**
     * 查询用户通知列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryInform", method = RequestMethod.POST)
    public ResultDTO queryInform(HttpServletRequest request, HttpServletResponse response, PageUtil pageUtil, Long userId) {
        //验证参数
        if (userId==null) {
            return ResultDTOBuilder.failure("00001");
        }
        IPage<InformBO> informs = informService.queryAllByLimit(pageUtil, userId);
        return ResultDTOBuilder.success(informs);
    }


    /**
     * 查询用户通知详情
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryInformById", method = RequestMethod.POST)
    public ResultDTO queryInformById(HttpServletRequest request, HttpServletResponse response,Long id) {
        //验证参数
        if (id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        InformBO informBO = informService.queryById(id);
        return ResultDTOBuilder.success(informBO);
    }



    /**
     * 已读通知
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updInform", method = RequestMethod.POST)
    public ResultDTO updInform(HttpServletRequest request, HttpServletResponse response,Long id) {
        //验证参数
        if (id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        InformBO informBO = informService.queryById(id);
        if(informBO!=null){
            informBO.setStatus(Constants.YES.getValue());
        }
        informService.update(informBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 新未读通知
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/newInform", method = RequestMethod.POST)
    public ResultDTO newInform(HttpServletRequest request, HttpServletResponse response) {
        UserBO loginUser = getLoginUser(request);
        int count = informService.newInform(loginUser.getId());
        return ResultDTOBuilder.success(count);
    }
}