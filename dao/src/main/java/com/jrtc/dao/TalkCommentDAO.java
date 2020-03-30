package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.TalkCommentBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * (TalkComment)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 18:38:47
 */
@Component
public interface TalkCommentDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    TalkCommentBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<TalkCommentBO> queryAllByLimit(Page<TalkCommentBO> page, @Param("talkId")Long talkId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param talkComment 实例对象
     * @return 对象列表
     */
    List<TalkCommentBO> queryAll(TalkCommentBO talkComment);

    /**
     * 新增数据
     *
     * @param talkComment 实例对象
     * @return 影响行数
     */
    int insert(TalkCommentBO talkComment);

    /**
     * 修改数据
     *
     * @param talkComment 实例对象
     * @return 影响行数
     */
    int update(TalkCommentBO talkComment);

    /**
     * 通过主键删除数据
     *
     * @param  id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}