package com.jrtc.controllerbackend;

import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.BraceMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 牙套方案
 */
@RestController
@RequestMapping("/brace")
public class BraceController extends BaseController {
    @Autowired
    private BraceMsgService braceService;


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

        List<BraceMsgBO> braceMsgBOS = braceService.queryAll(userId);
        return ResultDTOBuilder.success(braceMsgBOS);
    }


    /**
     * 修改
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBrace", method = RequestMethod.POST)
    public ResultDTO update(HttpServletRequest request, HttpServletResponse response,BraceMsgBO braceMsgBO) {
        if(braceMsgBO.getId()==null){
            return ResultDTOBuilder.failure("00001");
        }
        BraceMsgBO braceBO = braceService.update(braceMsgBO,braceMsgBO.getUserId());
        return ResultDTOBuilder.success(braceBO);
    }


}