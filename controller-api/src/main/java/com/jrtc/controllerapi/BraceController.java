package com.jrtc.controllerapi;

import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.DateUtil;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.BraceMsgService;
import com.jrtc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 牙套倒计时
 */
@RestController
@RequestMapping("/brace")
public class BraceController extends BaseController {

    @Autowired
    private BraceMsgService braceMsgService;

    @Autowired
    UserService userService;

    /**
     * 初始化添加
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addBrace", method = RequestMethod.POST)
    public ResultDTO queryBan(HttpServletRequest request, HttpServletResponse response, Integer periods, Date startTime) {
        if (!verifyParam(periods)) {
            return ResultDTOBuilder.failure("00001");
        }
        if (startTime == null) {
            startTime = new Date();
        }
        UserBO loginUser = super.getLoginUser(request);
        braceMsgService.insert(loginUser.getId(), periods, startTime);
        return ResultDTOBuilder.success();
    }


    /**
     * 修改副
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBrace", method = RequestMethod.POST)
    public ResultDTO updBrace(HttpServletRequest request, HttpServletResponse response, BraceMsgBO braceBO) {
        if (!verifyParam(braceBO.getId(), braceBO.getStartTime(), braceBO.getNum(), braceBO.getName())) {
            return ResultDTOBuilder.failure("00001");
        }

        UserBO loginUser = super.getLoginUser(request);
        braceMsgService.update(braceBO,loginUser.getId());
        return ResultDTOBuilder.success();
    }


    /**
     * 确认方案
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBraceMsg", method = RequestMethod.POST)
    public ResultDTO updBraceMsg(HttpServletRequest request, HttpServletResponse response, UserBO userBO) {
        if (!verifyParam(userBO.getId(),userBO.getBraceStatus())) {
            return ResultDTOBuilder.failure("00001");
        }

        userService.updateBrace(userBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 删除一副
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delBrace", method = RequestMethod.POST)
    public ResultDTO delBrace(HttpServletRequest request, HttpServletResponse response, Long id) {
        if (id == null) {
            return ResultDTOBuilder.failure("00001");
        }
        BraceMsgBO braceMsgBO = braceMsgService.queryById(id);
        if(braceMsgBO==null || braceMsgBO.getStatus().equals("yes")){
            return ResultDTOBuilder.failure("02009");
        }
        braceMsgService.deleteById(id);
        return ResultDTOBuilder.success();
    }


    /**
     * 单独添加一副
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addBraceMsg", method = RequestMethod.POST)
    public ResultDTO addBraceMsg(HttpServletRequest request, HttpServletResponse response, BraceMsgBO braceMsgBO) {
        if (!verifyParam(braceMsgBO.getName(), braceMsgBO.getNum(), braceMsgBO.getStartTime())) {
            return ResultDTOBuilder.failure("00001");
        }
        UserBO loginUser = super.getLoginUser(request);
        int i = braceMsgService.queryCont(loginUser.getId(), braceMsgBO.getStartTime());
        if(i>=1){
            return ResultDTOBuilder.failure("02010");
        }
        braceMsgBO.setEndTime(DateUtil.getEndTime(braceMsgBO.getStartTime(), braceMsgBO.getNum()));
        braceMsgBO.setStatus(Constants.NO.getValue());
        braceMsgBO.setUserId(loginUser.getId());
        braceMsgService.insert(braceMsgBO);
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
    public ResultDTO queryBrace(HttpServletRequest request, HttpServletResponse response, Long userId) {
        if (userId == null) {
            return ResultDTOBuilder.failure("00001");
        }
        List<BraceMsgBO> braceBOS = braceMsgService.queryAll(userId);
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
    public ResultDTO queryCountdown(HttpServletRequest request, HttpServletResponse response, Long userId) {
        if (userId == null) {
            return ResultDTOBuilder.failure("00001");
        }
        Map<String, Object> reslut = braceMsgService.queryCountdown(userId);
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
    public ResultDTO updaMake(HttpServletRequest request, HttpServletResponse response, Long userId) {
        if (userId == null) {
            return ResultDTOBuilder.failure("00001");
        }
        braceMsgService.updaMake(userId);

        return ResultDTOBuilder.success();
    }


}