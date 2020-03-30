package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.ArticleCommentBO;
import com.jrtc.base.entity.bo.TalkBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * (Talk)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 18:38:39
 */
@Component
public interface TalkDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TalkBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<TalkBO> queryAllByLimit(Page<TalkBO> pag);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param talk 实例对象
     * @return 对象列表
     */
    List<TalkBO> queryAll(TalkBO talk);

    /**
     * 新增数据
     *
     * @param talk 实例对象
     * @return 影响行数
     */
    int insert(TalkBO talk);

    /**
     * 修改数据
     *
     * @param talk 实例对象
     * @return 影响行数
     */
    int update(TalkBO talk);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}