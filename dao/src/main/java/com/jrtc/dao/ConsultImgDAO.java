package com.jrtc.dao;


import com.jrtc.base.entity.bo.ConsultImgBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (ConsultImg)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 14:03:41
 */
@Component
public interface ConsultImgDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ConsultImgBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ConsultImgBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param consultImg 实例对象
     * @return 对象列表
     */
    List<ConsultImgBO> queryAll(ConsultImgBO consultImg);

    /**
     * 新增数据
     *
     * @param consultImg 实例对象
     * @return 影响行数
     */
    int insert(ConsultImgBO consultImg);

    /**
     * 修改数据
     *
     * @param consultImg 实例对象
     * @return 影响行数
     */
    int update(ConsultImgBO consultImg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}