package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.TalkCommentBO;
import com.jrtc.base.entity.bo.TalkReplyBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.TalkReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * (TalkReply)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 18:39:07
 */
@Service("talkReplyService")
public class TalkReplyService {
    @Autowired
    private TalkReplyDAO talkReplyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TalkReplyBO queryById(Long id) {
        return this.talkReplyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public IPage<TalkReplyBO> queryAllByLimit(PageUtil pageUtil,Long mentId) {
        Page<TalkReplyBO> page = new Page<TalkReplyBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<TalkReplyBO> iPage = talkReplyDao.queryAllByLimit(page,mentId);
        return iPage;
    }

    /**
     * 新增数据
     *
     * @param talkReply 实例对象
     * @return 实例对象
     */
    public TalkReplyBO insert(UserBO user, TalkReplyBO talkReply) {
        talkReply.setCreateTime(new Date());
        talkReply.setUserId(user.getId());
        talkReply.setUserHead(user.getHead());
        talkReply.setUserName(user.getName());
        this.talkReplyDao.insert(talkReply);
        return talkReply;
    }

    /**
     * 修改数据
     *
     * @param talkReply 实例对象
     * @return 实例对象
     */
    public TalkReplyBO update(TalkReplyBO talkReply) {
        this.talkReplyDao.update(talkReply);
        return this.queryById(talkReply.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.talkReplyDao.deleteById(id) > 0;
    }
}