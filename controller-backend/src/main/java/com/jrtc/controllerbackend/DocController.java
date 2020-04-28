package com.jrtc.controllerbackend;

import com.jrtc.base.entity.bo.BannerBO;
import com.jrtc.base.entity.bo.DocBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseController;
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
     * 添加说明
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addDoc", method = RequestMethod.POST)
    public ResultDTO addDoc(HttpServletRequest request, HttpServletResponse response, DocBO docBO) {
        //验证参数
        if (!verifyParam(docBO.getTitle(),docBO.getType())) {
            return ResultDTOBuilder.failure("00001");
        }
        docService.insert(docBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 修改说明
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updDoc", method = RequestMethod.POST)
    public ResultDTO updDoc(HttpServletRequest request, HttpServletResponse response, DocBO docBO) {
        if (!verifyParam(docBO.getId(),docBO.getType())) {
            return ResultDTOBuilder.failure("00001");
        }
        docService.update(docBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除delDoc
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delDoc", method = RequestMethod.POST)
    public ResultDTO delBan(HttpServletRequest request, HttpServletResponse response, Long id) {
        //验证参数
        if (id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        docService.deleteById(id);
        return ResultDTOBuilder.success();
    }

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