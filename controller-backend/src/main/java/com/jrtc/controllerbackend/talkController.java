package com.jrtc.controllerbackend;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.TalkBO;
import com.jrtc.base.entity.bo.TalkCommentBO;
import com.jrtc.base.entity.bo.TalkReplyBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.PageUtil;
import com.jrtc.controllerbackend.base.BaseController;
import com.jrtc.service.TalkCommentService;
import com.jrtc.service.TalkLikeService;
import com.jrtc.service.TalkReplyService;
import com.jrtc.service.TalkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/talk")
public class talkController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(talkController.class);

    @Autowired
    private TalkService talkService;
    @Autowired
    private TalkLikeService talkLikeService;
    @Autowired
    private TalkCommentService talkCommentService;
    @Autowired
    private TalkReplyService talkReplyService;


    /**
     * 删除说说
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/delTalk" , method = RequestMethod.POST)
    public ResultDTO delTalk(HttpServletResponse response, HttpServletRequest request,Long talkId) {
        if(talkId==null){
            return ResultDTOBuilder.failure("00001");
        }
        TalkBO talkBO = talkService.queryById(talkId);
        talkBO.setStatus(Constants.NO.getValue());
        talkService.update(talkBO);
        return ResultDTOBuilder.success();
    }



    /**
     * 查询说说列表
     * @param
     */
    @RequestMapping(value = "/queryTalk" , method = RequestMethod.POST)
    public ResultDTO queryTalk(HttpServletResponse response, HttpServletRequest request, PageUtil pageUtil) {
        IPage<TalkBO> talkBOIPage = talkService.queryAllByLimit(null, pageUtil);
        return ResultDTOBuilder.success(talkBOIPage);
    }


    /**
     * 查询说说评论
     */
    @RequestMapping(value = "/queryTalkCmt" , method = RequestMethod.POST)
    public ResultDTO queryTalkCmt(HttpServletResponse response, HttpServletRequest request, PageUtil pageUtil,Long talkId) {
        if(talkId==null){
            return ResultDTOBuilder.failure("00001");
        }
        IPage<TalkCommentBO> comments = talkCommentService.queryAllByLimit(pageUtil, talkId);
        return ResultDTOBuilder.success(comments);
    }


    /**
     * 删除评论
     */
    @RequestMapping(value = "/delTalkCmt" , method = RequestMethod.POST)
    public ResultDTO delTalkCmt(HttpServletResponse response, HttpServletRequest request, Long commentId) {
        if(commentId==null){
            return ResultDTOBuilder.failure("00001");
        }
        TalkCommentBO talkCommentBO = talkCommentService.queryById(commentId);
        talkCommentBO.setStatus(Constants.NO.getValue());
        talkCommentService.update(talkCommentBO);
        return ResultDTOBuilder.success();
    }


    /**
     * 查询评论回复
     */
    @RequestMapping(value = "/queryReply" , method = RequestMethod.POST)
    public ResultDTO queryReply(HttpServletResponse response, HttpServletRequest request, PageUtil pageUtil,Long commentId) {
        if(commentId==null){
            return ResultDTOBuilder.failure("00001");
        }
        IPage<TalkReplyBO> replys = talkReplyService.queryAllByLimit(pageUtil, commentId);
        return ResultDTOBuilder.success(replys);
    }


    /**
     * 添加评论回复
     */
    @RequestMapping(value = "/delReply" , method = RequestMethod.POST)
    public ResultDTO delReply(HttpServletResponse response, HttpServletRequest request,Long replyId) {
        if(replyId==null){
            return ResultDTOBuilder.failure("00001");
        }
        talkReplyService.deleteById(replyId);
        return ResultDTOBuilder.success();
    }



}