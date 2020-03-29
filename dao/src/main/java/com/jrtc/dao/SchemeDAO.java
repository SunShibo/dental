package com.jrtc.dao;

import com.jrtc.base.entity.bo.SchemeBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Scheme)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-28 18:19:40
 */
@Component
public interface SchemeDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SchemeBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<SchemeBO> queryAllByUserId(@Param("userId")Long userId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param scheme 实例对象
     * @return 对象列表
     */
    List<SchemeBO> queryAll(SchemeBO scheme);

    /**
     * 新增数据
     *
     * @param scheme 实例对象
     * @return 影响行数
     */
    int insert(SchemeBO scheme);

    /**
     * 修改数据
     *
     * @param scheme 实例对象
     * @return 影响行数
     */
    int update(SchemeBO scheme);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}