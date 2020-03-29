package com.jrtc.controllerbackend;

import com.jrtc.base.entity.bo.BannerBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.controllerbackend.base.BaseCotroller;
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
public class BannerController extends BaseCotroller {
    @Autowired
    private BannerService bannerService;


    /**
     * 添加Banner
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addBan", method = RequestMethod.POST)
    public ResultDTO addArtic(HttpServletRequest request, HttpServletResponse response, BannerBO bannerBO) {
        //验证参数
        if (!verifyParam(bannerBO.getImg())) {
            return ResultDTOBuilder.failure("00001");
        }
        bannerService.insert(bannerBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 修改Banner
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updBan", method = RequestMethod.POST)
    public ResultDTO updBan(HttpServletRequest request, HttpServletResponse response, BannerBO bannerBO) {
        //验证参数
        if (!verifyParam(bannerBO.getImg(),bannerBO.getId())) {
            return ResultDTOBuilder.failure("00001");
        }
        bannerService.update(bannerBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除Banner
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delBan", method = RequestMethod.POST)
    public ResultDTO delBan(HttpServletRequest request, HttpServletResponse response, Long id) {
        //验证参数
        if (id==null) {
            return ResultDTOBuilder.failure("00001");
        }
        bannerService.deleteById(id);
        return ResultDTOBuilder.success();
    }

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