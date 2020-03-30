package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.TalkCommentBO;
import com.jrtc.base.entity.bo.TalkReplyBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.TalkCommentDAO;
import com.jrtc.dao.TalkReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (TalkComment)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 18:38:47
 */
@Service("talkCommentService")
public class TalkCommentService {
    @Autowired
    private TalkCommentDAO talkCommentDao;
    @Autowired
    private TalkReplyDAO talkReplyDao;
    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    public TalkCommentBO queryById(Long id) {
        return this.talkCommentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public IPage<TalkCommentBO> queryAllByLimit(PageUtil pageUtil,Long talkId) {
        Page<TalkCommentBO> page = new Page<TalkCommentBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<TalkCommentBO> iPage = talkCommentDao.queryAllByLimit(page,talkId);
        List<TalkCommentBO> records = iPage.getRecords();
        if(records!=null && records.size()>0){
            for(TalkCommentBO ment: records){
                IPage<TalkReplyBO> talkReplyBOIPage = talkReplyDao.queryAllByLimit(new Page<TalkReplyBO>(1,10), ment.getId());
                if(talkReplyBOIPage.getTotal()>0){
                    ment.setTalkReply(talkReplyBOIPage);
                }
            }
        }
        return iPage;
    }

    /**
     * 新增数据
     *
     * @param talkComment 实例对象
     * @return 实例对象
     */
    public TalkCommentBO insert(UserBO user, TalkCommentBO talkComment) {
        talkComment.setCreateTime(new Date());
        talkComment.setUserHead(user.getHead());
        talkComment.setUserName(user.getName());
        talkComment.setUserId(user.getId());
        talkComment.setStatus(Constants.YES.getValue());
        this.talkCommentDao.insert(talkComment);
        return talkComment;
    }

    /**
     * 修改数据
     *
     * @param talkComment 实例对象
     * @return 实例对象
     */
    public TalkCommentBO update(TalkCommentBO talkComment) {
        this.talkCommentDao.update(talkComment);
        return this.queryById(talkComment.getId());
    }

    /**
     * 通过主键删除数据
     * @param  id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.talkCommentDao.deleteById(id) > 0;
    }


}