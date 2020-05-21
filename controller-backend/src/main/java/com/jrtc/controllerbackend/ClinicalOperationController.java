package com.jrtc.controllerbackend;

import com.jrtc.base.entity.bo.ClinicalOperation;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.ClinicalOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/ClinicalOperationBackend")
public class ClinicalOperationController extends BaseController {

    @Autowired
    ClinicalOperationService clinicalOperationService;

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getClinicalOperation", method = RequestMethod.POST)
    public ResultDTO getClinicalOperation(HttpServletRequest request, HttpServletResponse response,Integer userId) {

        ClinicalOperation clinicalOperation=new ClinicalOperation();
        clinicalOperation.setUserId(userId);

        List<ClinicalOperation>  ClinicalOperation= clinicalOperationService.queryAll(clinicalOperation);
        return ResultDTOBuilder.success(ClinicalOperation);
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updClinicalOperation", method = RequestMethod.POST)
    public ResultDTO updClinicalOperation(HttpServletRequest request, HttpServletResponse response,ClinicalOperation clinicalOperation) {
        clinicalOperationService.update(clinicalOperation);
        return ResultDTOBuilder.success();
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delClinicalOperation", method = RequestMethod.POST)
    public ResultDTO delClinicalOperation(HttpServletRequest request, HttpServletResponse response,Integer id) {
        clinicalOperationService.deleteById(id);
        return ResultDTOBuilder.success();
    }

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addClinicalOperation", method = RequestMethod.POST)
    public ResultDTO addClinicalOperation(HttpServletRequest request, HttpServletResponse response,ClinicalOperation clinicalOperation) {
        clinicalOperationService.insert(clinicalOperation);
        return ResultDTOBuilder.success();
    }



}
