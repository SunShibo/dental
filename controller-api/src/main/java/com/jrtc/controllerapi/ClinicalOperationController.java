package com.jrtc.controllerapi;

import com.jrtc.base.entity.bo.BannerBO;
import com.jrtc.base.entity.bo.ClinicalOperation;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.ClinicalOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/ClinicalOperation")
public class ClinicalOperationController  extends BaseController {

    @Autowired
    ClinicalOperationService clinicalOperationService;

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getClinicalOperation", method = RequestMethod.POST)
    public ResultDTO getClinicalOperation(HttpServletRequest request, HttpServletResponse response) {
        UserBO userBO=super.getLoginUser(request);

        ClinicalOperation clinicalOperation=new ClinicalOperation();
        clinicalOperation.setUserId(userBO.getId().intValue());

        List<ClinicalOperation>  ClinicalOperation= clinicalOperationService.queryAll(clinicalOperation);
        return ResultDTOBuilder.success(ClinicalOperation);
    }
}
