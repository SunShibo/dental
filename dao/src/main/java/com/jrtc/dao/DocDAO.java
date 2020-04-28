package com.jrtc.dao;

import com.jrtc.base.entity.bo.DocBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * (Doc)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 14:17:09
 */
@Component
public interface DocDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DocBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DocBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<DocBO> queryAll();

    /**
     * 新增数据
     *
     * @param doc 实例对象
     * @return 影响行数
     */
    int insert(DocBO doc);

    /**
     * 修改数据
     *
     * @param doc 实例对象
     * @return 影响行数
     */
    int update(DocBO doc);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}