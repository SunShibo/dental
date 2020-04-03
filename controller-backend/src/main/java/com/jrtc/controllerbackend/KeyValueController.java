package com.jrtc.controllerbackend;


import com.jrtc.base.entity.bo.KeyValueBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.KeyValueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/keyValue")
public class KeyValueController extends BaseController {
    @Resource
    private KeyValueService keyValueService ;

    /**
     * 获取keyvalue
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/querykeyValue" ,method = RequestMethod.POST)
    public ResultDTO getKeyValueList(HttpServletRequest request, HttpServletResponse response){
        List<KeyValueBO> gradeBOS=keyValueService.getKeyValueList();
        return ResultDTOBuilder.success(gradeBOS);
    }

    /**
     * 修改keyvalue
     * @param request
     * @param response
     * @param gradeBO
     */
    @RequestMapping(value = "/updKeyValue"  ,method = RequestMethod.POST)
    public ResultDTO updKeyValue(HttpServletRequest request, HttpServletResponse response, KeyValueBO gradeBO){
        //验证参数
        if(!verifyParam(gradeBO.getId(),gradeBO.getValues())){
            return ResultDTOBuilder.failure("00001");
        }
        keyValueService.updKeyValue(gradeBO);
        return ResultDTOBuilder.success();
    }


}
