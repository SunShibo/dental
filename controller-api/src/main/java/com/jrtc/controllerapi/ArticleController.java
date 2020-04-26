package com.jrtc.controllerapi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.ArticleBO;
import com.jrtc.base.entity.bo.ArticleCommentBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.ArticleCommentService;
import com.jrtc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 文章/案例
 */
@RestController
@RequestMapping("/artic")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleCommentService  articleCommentService;

    /**
     * 查询文章或案例列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryArtic", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, PageUtil pageUtil,String type) {
        IPage<ArticleBO> admins = articleService.queryAllByTitle(pageUtil, null,type,null);
        return ResultDTOBuilder.success(admins);
    }



    /**
     * 查询文章或案例
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryArticById", method = RequestMethod.POST)
    public ResultDTO queryArticById(HttpServletRequest request, HttpServletResponse response,Long id) {
        if(!verifyParam(id)){
            return ResultDTOBuilder.failure("00001");
        }
        ArticleBO articleBO = articleService.queryById(id);
        return ResultDTOBuilder.success(articleBO);
    }

    /**
     * 查询文章或案例评论
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/queryArticMent", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, PageUtil pageUtil,Long id) {
        if(!verifyParam(id)){
            return ResultDTOBuilder.failure("00001");
        }
        IPage<ArticleCommentBO> comment = articleCommentService.queryAllByLimit(pageUtil,id);
        return ResultDTOBuilder.success(comment);
    }

    /**
     * 添加文章或案例评论
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/addArticMent", method = RequestMethod.POST)
    public ResultDTO addArticMent(HttpServletRequest request, HttpServletResponse response,ArticleCommentBO articleCommentBO) {
        if(!verifyParam(articleCommentBO.getContent(),articleCommentBO.getCId())){
            return ResultDTOBuilder.failure("00001");
        }
        UserBO loginUser = super.getLoginUser(request);
        articleCommentBO.setUserId(loginUser.getId());
        articleCommentBO.setCreateTime(new Date());
        articleCommentBO.setStatus(Constants.YES.getValue());
        articleCommentBO.setPId(0L);
        articleCommentService.insert(articleCommentBO);
        return ResultDTOBuilder.success();
    }

}