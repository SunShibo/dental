package com.jrtc.controllerapi;

import com.jrtc.base.entity.bo.BannerBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Banner
 */
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {
    @Autowired
    private BannerService bannerService;

    /**
     * 查询Banner
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryBan", method = RequestMethod.POST)
    public ResultDTO queryBan(HttpServletRequest request, HttpServletResponse response) {
        List<BannerBO> bannerBOS = bannerService.queryAll();
        return ResultDTOBuilder.success(bannerBOS);
    }

}