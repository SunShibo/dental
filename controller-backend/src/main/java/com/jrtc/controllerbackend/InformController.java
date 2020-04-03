package com.jrtc.controllerbackend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseController;
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
public class InformController extends BaseController {

    @Autowired
    private InformService informService;


    /**
     * 添加用户通知
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addInform", method = RequestMethod.POST)
    public ResultDTO addInform(HttpServletRequest request, HttpServletResponse response, InformBO informBO) {
        //验证参数
        if (!verifyParam(informBO.getContent(),informBO.getUserId())) {
            return ResultDTOBuilder.failure("00001");
        }
        informService.insert(informBO);
        return ResultDTOBuilder.success();
    }

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
     * 删除用户通知详情
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delInform", method = RequestMethod.POST)
    public ResultDTO delInform(HttpServletRequest request, HttpServletResponse response,Long id) {
        //验证参数
        if (id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        informService.deleteById(id);
        return ResultDTOBuilder.success();
    }



}