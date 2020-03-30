package com.jrtc.dao;

import com.jrtc.base.entity.bo.TalkLikeBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * (TalkLike)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 18:39:02
 */
@Component
public interface TalkLikeDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TalkLikeBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TalkLikeBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param talkLike 实例对象
     * @return 对象列表
     */
    List<TalkLikeBO> queryAll(TalkLikeBO talkLike);

    /**
     * 新增数据
     *
     * @param talkLike 实例对象
     * @return 影响行数
     */
    int insert(TalkLikeBO talkLike);

    /**
     * 修改数据
     *
     * @param talkLike 实例对象
     * @return 影响行数
     */
    int update(TalkLikeBO talkLike);

    /**
     * 通过主键删除数据
     *
     * @param cId 说说id
     * @return 影响行数
     */
    int deleteById(@Param("cId") Long cId,@Param("userId")Long userId);

    /**
     * 该用户是否点过赞
     * @param id
     * @param userId
     * @return
     */
    int queryIsLike(@Param("id")Long id,@Param("userId") Long userId);
}