package com.jrtc.controllerbackend;


import com.jrtc.base.entity.bo.DynamicBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.DynamicService;
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
@RequestMapping("/dynamic")
public class DynamicController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(DynamicController.class);

    @Autowired
    private DynamicService dynamicService;


    /**
     * 添加动态方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/addDynamic" , method = RequestMethod.POST)
    public ResultDTO queryDocId(HttpServletResponse response, HttpServletRequest request, DynamicBO dynamicBO) {
        if(!verifyParam(dynamicBO.getImg(),dynamicBO.getType(),dynamicBO.getUserId())){
            return ResultDTOBuilder.failure("00001");
        }
        dynamicBO.setCreateTime(new Date());
        dynamicService.insert(dynamicBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除动态方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/delDynamic" , method = RequestMethod.POST)
    public ResultDTO delScheme(HttpServletResponse response, HttpServletRequest request, Long id) {
        if(!verifyParam(id)){
            return ResultDTOBuilder.failure("00001");
        }
        dynamicService.deleteById(id);
        return ResultDTOBuilder.success();
    }


    /**
     * 查询方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryDynamic" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, Long userId,String type) {
        if(!verifyParam(userId)){
            return ResultDTOBuilder.failure("00001");
        }
        List<DynamicBO> dynamicBOS = dynamicService.queryAllByType(userId, type);
        return ResultDTOBuilder.success(dynamicBOS);
    }


    /**
     * 查询方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/updDynamic" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, DynamicBO dynamicBO) {
        if(!verifyParam(dynamicBO.getImg(),dynamicBO.getType(),dynamicBO.getId())){
            return ResultDTOBuilder.failure("00001");
        }
        dynamicService.update(dynamicBO);
        return ResultDTOBuilder.success();
    }
}