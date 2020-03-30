package com.jrtc.dao;

import com.jrtc.base.entity.bo.TalkImgBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * (TalkImg)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 18:38:55
 */
@Component
public interface TalkImgDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TalkImgBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TalkImgBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param talkImg 实例对象
     * @return 对象列表
     */
    List<TalkImgBO> queryAll(TalkImgBO talkImg);

    /**
     * 新增数据
     *
     * @param talkImg 实例对象
     * @return 影响行数
     */
    int insert(TalkImgBO talkImg);

    /**
     * 修改数据
     *
     * @param talkImg 实例对象
     * @return 影响行数
     */
    int update(TalkImgBO talkImg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}