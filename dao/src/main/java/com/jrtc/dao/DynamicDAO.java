package com.jrtc.dao;

import com.jrtc.base.entity.bo.DynamicBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * (Dynamic)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 15:57:31
 */
@Component
public interface DynamicDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DynamicBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<DynamicBO> queryAllByType(@Param("userId") Long userId, @Param("type")String type);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dynamic 实例对象
     * @return 对象列表
     */
    List<DynamicBO> queryAll(DynamicBO dynamic);

    /**
     * 新增数据
     *
     * @param dynamic 实例对象
     * @return 影响行数
     */
    int insert(DynamicBO dynamic);

    /**
     * 修改数据
     *
     * @param dynamic 实例对象
     * @return 影响行数
     */
    int update(DynamicBO dynamic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}