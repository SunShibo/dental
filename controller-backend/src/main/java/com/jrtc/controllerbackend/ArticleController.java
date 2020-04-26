package com.jrtc.controllerbackend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.entity.bo.ArticleBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文章/案例
 */
@RestController
@RequestMapping("/artic")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;


    /**
     * 新增文章或案例
     *
     * @param request
     * @param response
     * @param articleBO
     * @return
     */
    @RequestMapping(value = "/addArtic", method = RequestMethod.POST)
    public ResultDTO addArtic(HttpServletRequest request, HttpServletResponse response, ArticleBO articleBO) {
        //验证参数
        if (!verifyParam(articleBO.getImg(), articleBO.getType(), articleBO.getContent(), articleBO.getTitle(),articleBO.getName())) {
            return ResultDTOBuilder.failure("00001");
        }
        articleService.insert(articleBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 修改文章或案例
     *
     * @param request
     * @param response
     * @param articleBO
     * @return
     */
    @RequestMapping(value = "/updArtic", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, ArticleBO articleBO) {
        //验证参数
        if (!verifyParam(articleBO.getImg(), articleBO.getType(), articleBO.getContent(), articleBO.getTitle(),articleBO.getId())) {
            return ResultDTOBuilder.failure("00001");
        }
        articleService.update(articleBO);
        return ResultDTOBuilder.success();
    }

    /**
     * 删除文章或案例
     *
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/delArtic", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, Long id) {
        //验证参数
        if (id == null) {
            return ResultDTOBuilder.failure("00001");
        }
        articleService.deleteById(id);
        return ResultDTOBuilder.success();
    }

    /**
     * 查询文章或案例
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryArtic", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, PageUtil pageUtil, String title,String type,String name) {
        IPage<ArticleBO> articles = articleService.queryAllByTitle(pageUtil, title,type,name);
        return ResultDTOBuilder.success(articles);
    }



}