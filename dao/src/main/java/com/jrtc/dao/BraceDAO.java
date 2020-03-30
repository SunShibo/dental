package com.jrtc.dao;

import com.jrtc.base.entity.bo.BraceBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * (Brace)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 18:55:07
 */
@Component
public interface BraceDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BraceBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BraceBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    List<BraceBO> queryAll(@Param("userId")Long userId);

    /**
     * 新增数据
     *
     * @param brace 实例对象
     * @return 影响行数
     */
    int insert(BraceBO brace);

    /**
     * 修改数据
     *
     * @param brace 实例对象
     * @return 影响行数
     */
    int update(BraceBO brace);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}