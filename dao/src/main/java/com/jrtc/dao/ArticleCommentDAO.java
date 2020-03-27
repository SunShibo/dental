package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.ArticleCommentBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * (ArticleBOComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 16:17:09
 */
@Component
public interface ArticleCommentDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleCommentBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<ArticleCommentBO> queryAllByLimit(Page<ArticleCommentBO> page, @Param("id")Long id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param articleComment 实例对象
     * @return 对象列表
     */
    List<ArticleCommentBO> queryAll(ArticleCommentBO articleComment);

    /**
     * 新增数据
     *
     * @param articleComment 实例对象
     * @return 影响行数
     */
    int insert(ArticleCommentBO articleComment);

    /**
     * 修改数据
     *
     * @param articleComment 实例对象
     * @return 影响行数
     */
    int update(ArticleCommentBO articleComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}