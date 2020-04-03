package com.jrtc.controllerapi;

import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.BraceBO;
import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.DateUtil;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.BraceMsgService;
import com.jrtc.service.BraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 牙套方案
 */
@RestController
@RequestMapping("/brace")
public class BraceController extends BaseController {
    @Autowired
    private BraceService braceService;
    @Autowired
    private BraceMsgService braceMsgService;

    /**
     * 添加阶段
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addBrace", method = RequestMethod.POST)
    public ResultDTO queryBan(HttpServletRequest request, HttpServletResponse response, BraceBO braceBO) {
        if(!verifyParam(braceBO.getStage())){
            return ResultDTOBuilder.failure("00001");
        }
        UserBO loginUser = super.getLoginUser(request);
        braceBO.setUserId(loginUser.getId());
        braceBO.setStatus(Constants.YES.getValue());
        braceService.insert(braceBO);
        return ResultDTOBuilder.success();
    }



    /**
     * 修改阶段
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBrace", method = RequestMethod.POST)
    public ResultDTO updBrace(HttpServletRequest request, HttpServletResponse response, BraceBO braceBO) {
        if(!verifyParam(braceBO.getStage(),braceBO.getId())){
            return ResultDTOBuilder.failure("00001");
        }
        braceService.update(braceBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除阶段
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delBrace", method = RequestMethod.POST)
    public ResultDTO delBrace(HttpServletRequest request, HttpServletResponse response, Long id) {
        if(id==null){
            return ResultDTOBuilder.failure("00001");
        }
        BraceBO braceBO = braceService.queryById(id);
        if(braceBO!=null){
            braceBO.setStatus(Constants.NO.getValue());
        }
        braceService.update(braceBO);
        return ResultDTOBuilder.success();
    }



    /**
     * 添加牙套
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addBraceMsg", method = RequestMethod.POST)
    public ResultDTO addBraceMsg(HttpServletRequest request, HttpServletResponse response, BraceMsgBO braceMsgBO) {
        if(!verifyParam(braceMsgBO.getName(),braceMsgBO.getBId(),braceMsgBO.getNum(),braceMsgBO.getStartTime())){
            return ResultDTOBuilder.failure("00001");
        }
        braceMsgBO.setEndTime(DateUtil.getEndTime(braceMsgBO.getStartTime(),braceMsgBO.getNum()));
        braceMsgBO.setStatus(Constants.YES.getValue());
        braceMsgService.insert(braceMsgBO);
        return ResultDTOBuilder.success();
    }



    /**
     * 修改牙套
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBraceMsg", method = RequestMethod.POST)
    public ResultDTO updBraceMsg(HttpServletRequest request, HttpServletResponse response, BraceMsgBO braceMsgBO) {
        if(!verifyParam(braceMsgBO.getId(),braceMsgBO.getName(),braceMsgBO.getBId(),braceMsgBO.getNum(),braceMsgBO.getStartTime())){
            return ResultDTOBuilder.failure("00001");
        }
        braceMsgBO.setEndTime(DateUtil.getEndTime(braceMsgBO.getStartTime(),braceMsgBO.getNum()));
        braceMsgBO.setStatus(Constants.YES.getValue());
        braceMsgService.update(braceMsgBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 删除牙套
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delBraceMsg", method = RequestMethod.POST)
    public ResultDTO delBraceMsg(HttpServletRequest request, HttpServletResponse response, Long id) {
        if(id==null){
            return ResultDTOBuilder.failure("00001");
        }
        BraceMsgBO braceMsgBO = braceMsgService.queryById(id);
        if(braceMsgBO!=null){
            braceMsgBO.setStatus(Constants.NO.getValue());
            braceMsgService.update(braceMsgBO);
        }

        return ResultDTOBuilder.success();
    }




    /**
     * 查询牙套方案列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryBrace", method = RequestMethod.POST)
    public ResultDTO queryBrace(HttpServletRequest request, HttpServletResponse response,Long userId) {
        if(userId==null){
            return ResultDTOBuilder.failure("00001");
        }

        List<BraceBO> braceBOS = braceService.queryAll(userId);
        return ResultDTOBuilder.success(braceBOS);
    }


    /**
     * 牙套倒计时
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryCountdown", method = RequestMethod.POST)
    public ResultDTO queryCountdown(HttpServletRequest request, HttpServletResponse response,Long userId) {
        if(userId==null){
            return ResultDTOBuilder.failure("00001");
        }
        Map<String, BraceMsgBO> reslut = braceMsgService.queryCountdown(userId);
        return ResultDTOBuilder.success(reslut);
    }


    /**
     * 确认制作
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updaMake", method = RequestMethod.POST)
    public ResultDTO updaMake(HttpServletRequest request, HttpServletResponse response,Long id) {
        if(id==null){
            return ResultDTOBuilder.failure("00001");
        }
        BraceBO braceBO = braceService.queryById(id);
        if(braceBO!=null){
            braceBO.setMake(Constants.YES.getValue());
            braceService.update(braceBO);
        }
        return ResultDTOBuilder.success();
    }


}