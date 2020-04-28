package com.jrtc.controllerapi;

import com.jrtc.base.entity.bo.DocBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 说明
 */
@RestController
@RequestMapping("/doc")
public class DocController extends BaseController {
    @Autowired
    private DocService docService;


    /**
     * 查询Doc
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryDoc", method = RequestMethod.POST)
    public ResultDTO queryBan(HttpServletRequest request, HttpServletResponse response) {
        List<DocBO> docBOS = docService.queryAll();
        return ResultDTOBuilder.success(docBOS);
    }

}