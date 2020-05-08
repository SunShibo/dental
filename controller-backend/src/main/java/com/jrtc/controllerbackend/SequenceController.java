package com.jrtc.controllerbackend;

import com.jrtc.base.entity.bo.AdminBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.StsUtil;
import com.jrtc.controllerbackend.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/sequence")
public class SequenceController extends BaseController {

    /**
      *  获取OSS临时凭证
      */
    @RequestMapping(value = "/getStsOss" , method = RequestMethod.POST)
    public ResultDTO getOssSts(HttpServletRequest request, HttpServletResponse response) {
        AdminBO loginUser = super.getLoginAdmin(request);
        if(loginUser==null){
            return ResultDTOBuilder.failure("00002");
        }

        Map<String, String> stsMessage = StsUtil.getStsOss(loginUser.getId()+"AdminOss");
        return ResultDTOBuilder.success(stsMessage);
    }

}
