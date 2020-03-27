package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.AdminBO;
import com.jrtc.base.entity.bo.ArticleBO;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2020-03-27 16:16:56
 */
@Service("articleService")
public class ArticleService {
    @Autowired
    private ArticleDAO articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ArticleBO queryById(Long id) {
        return this.articleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public IPage<ArticleBO> queryAllByTitle(PageUtil pageUtil, String title,String type) {
        Page<ArticleBO> page = new Page<ArticleBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<ArticleBO> iPage = articleDao.queryAllByTitle(page, title,type);
        return iPage;

    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    public ArticleBO insert(ArticleBO article) {
        article.setStatus(Constants.YES.getValue());
        this.articleDao.insert(article);
        return article;
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    public ArticleBO update(ArticleBO article) {
        this.articleDao.update(article);
        return this.queryById(article.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        ArticleBO articleBO = this.queryById(id);
        if (articleBO != null) {
            articleBO.setStatus(Constants.NO.getValue());
            this.update(articleBO);
        }
        return true;
    }
}