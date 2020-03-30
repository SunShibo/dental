package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.ArticleCommentBO;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.ArticleCommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * (ArticleComment)表服务实现类
 *
 * @author makejava
 * @since 2020-03-27 16:17:09
 */
@Service("articleCommentService")
public class ArticleCommentService  {
    @Autowired
    private ArticleCommentDAO articleCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ArticleCommentBO queryById(Long id) {
        return this.articleCommentDao.queryById(id);
    }

    /**
     * 查询多条数据
     * @return 对象列表
     */
    public IPage<ArticleCommentBO> queryAllByLimit(PageUtil pageUtil,Long id) {
        Page<ArticleCommentBO> page = new Page<ArticleCommentBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<ArticleCommentBO> iPage = articleCommentDao.queryAllByLimit(page,id);
        return iPage;
    }

    /**
     * 新增数据
     *
     * @param articleComment 实例对象
     * @return 实例对象
     */
    public ArticleCommentBO insert(ArticleCommentBO articleComment) {
        this.articleCommentDao.insert(articleComment);
        return articleComment;
    }

    /**
     * 修改数据
     *
     * @param articleComment 实例对象
     * @return 实例对象
     */
    public ArticleCommentBO update(ArticleCommentBO articleComment) {
        this.articleCommentDao.update(articleComment);
        return this.queryById(articleComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        ArticleCommentBO articleCommentBO = articleCommentDao.queryById(id);
        if(articleCommentBO!=null){
            articleCommentBO.setStatus(Constants.NO.getValue());
            articleCommentDao.update(articleCommentBO);
        }
        return true;
    }

    /**
     * 置顶评论
     * @param id
     */
    public void stickArticMent(Long id) {
        ArticleCommentBO articleCommentBO = articleCommentDao.queryById(id);
        if(articleCommentBO!=null){
            if(articleCommentBO.getPId()!=null && articleCommentBO.getPId().equals(Long.parseLong("0"))){
                articleCommentBO.setPId(Long.parseLong("1"));
            }else{
                articleCommentBO.setPId(Long.parseLong("0"));
            }
            articleCommentDao.update(articleCommentBO);
        }
    }
}