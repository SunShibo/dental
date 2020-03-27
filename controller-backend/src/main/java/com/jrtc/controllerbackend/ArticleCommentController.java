package com.jrtc.controllerbackend;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.entity.bo.ArticleCommentBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseCotroller;
import com.jrtc.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文章/案例 评论
 */
@RestController
@RequestMapping("/articMent")
public class ArticleCommentController extends BaseCotroller {
    @Autowired
    private ArticleCommentService articleCommentService;


    /**
     * 删除文章或案例
     *
     * @param request
     * @param response
     * @param id
     * @return
     */
    @RequestMapping(value = "/delArticMent", method = RequestMethod.POST)
    public ResultDTO updArtic(HttpServletRequest request, HttpServletResponse response, Long id) {
        //验证参数
        if (id == null) {
            return ResultDTOBuilder.failure("00001");
        }
        articleCommentService.deleteById(id);
        return ResultDTOBuilder.success();
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



}