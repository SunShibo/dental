package com.jrtc.dao;

import com.jrtc.base.entity.bo.ClinicalOperation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ClinicalOperation)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-20 20:07:22
 */
public interface ClinicalOperationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClinicalOperation queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClinicalOperation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param clinicalOperation 实例对象
     * @return 对象列表
     */
    List<ClinicalOperation> queryAll(ClinicalOperation clinicalOperation);

    /**
     * 新增数据
     *
     * @param clinicalOperation 实例对象
     * @return 影响行数
     */
    int insert(ClinicalOperation clinicalOperation);

    /**
     * 修改数据
     *
     * @param clinicalOperation 实例对象
     * @return 影响行数
     */
    int update(ClinicalOperation clinicalOperation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}