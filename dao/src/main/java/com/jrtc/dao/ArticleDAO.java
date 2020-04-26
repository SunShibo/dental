package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.AdminBO;
import com.jrtc.base.entity.bo.ArticleBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 16:16:54
 */
@Component
public interface ArticleDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleBO queryById(Long id);

    /**
     * 查询指定行数据
     * @return 对象列表
     */
    IPage<ArticleBO> queryAllByTitle(Page<ArticleBO> page, @Param("title")String title,@Param("type")String type,@Param("name")String name);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<ArticleBO> queryAll(ArticleBO article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(ArticleBO article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(ArticleBO article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}