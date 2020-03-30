package com.jrtc.controllerbackend;

import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.BraceBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseCotroller;
import com.jrtc.service.BraceService;
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
public class BraceController extends BaseCotroller {
    @Autowired
    private BraceService braceService;


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