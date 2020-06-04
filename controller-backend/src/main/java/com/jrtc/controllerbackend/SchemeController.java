package com.jrtc.controllerbackend;


import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.bo.SchemeBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.InformService;
import com.jrtc.service.SchemeService;
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
@RequestMapping("/scheme")
public class SchemeController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(SchemeController.class);

    @Autowired
    private SchemeService schemeService;
    @Autowired
    private InformService informService;
    /**
     * 用户确认方案后管理员收到通知
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/notice" , method = RequestMethod.POST)
    public ResultDTO notice(HttpServletResponse response, HttpServletRequest request) {
        return ResultDTOBuilder.success(informService.queryNewInform());
    }

    /**
     * 管理员设置为以读
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/confirmationNotice" , method = RequestMethod.POST)
    public ResultDTO confirmationNotice(HttpServletResponse response, HttpServletRequest request,Long id) {
        if(!verifyParam(id)){
            return ResultDTOBuilder.failure("00001");
        }
        InformBO informBO=new InformBO();
        informBO.setId(id);
        informBO.setStatus("yes");
        informService.update(informBO);

        return ResultDTOBuilder.success();
    }

    /**
     * 添加方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/addScheme" , method = RequestMethod.POST)
    public ResultDTO queryDocId(HttpServletResponse response, HttpServletRequest request, SchemeBO  schemeBO) {
        if(!verifyParam(schemeBO.getImg(),schemeBO.getUserId())){
            return ResultDTOBuilder.failure("00001");
        }
        schemeBO.setCreateTime(new Date());
        SchemeBO schemeBO1=schemeService.insertSendDoctorMes(schemeBO);
        if(schemeBO1==null){
            return ResultDTOBuilder.failure("02012");
        }
        return ResultDTOBuilder.success();
    }


    /**
     * 删除方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/delScheme" , method = RequestMethod.POST)
    public ResultDTO delScheme(HttpServletResponse response, HttpServletRequest request, Long id) {
        if(!verifyParam(id)){
            return ResultDTOBuilder.failure("00001");
        }
        schemeService.deleteById(id);
        return ResultDTOBuilder.success();
    }


    /**
     * 查询方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryScheme" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, Long userId) {
        if(!verifyParam(userId)){
            return ResultDTOBuilder.failure("00001");
        }
        List<SchemeBO> schemeBOS = schemeService.queryAllByUserId(userId);
        return ResultDTOBuilder.success(schemeBOS);
    }


    /**
     * 修改方案
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/updScheme" , method = RequestMethod.POST)
    public ResultDTO queryScheme(HttpServletResponse response, HttpServletRequest request, SchemeBO schemeBO) {
        if(!verifyParam(schemeBO.getImg(),schemeBO.getId())){
            return ResultDTOBuilder.failure("00001");
        }
        schemeService.update(schemeBO);
        return ResultDTOBuilder.success();
    }
}