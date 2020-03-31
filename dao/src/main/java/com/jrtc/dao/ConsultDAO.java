package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.ConsultBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Consult)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-31 14:03:33
 */
@Component
public interface ConsultDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ConsultBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<ConsultBO> queryAllByLimit(Page<ConsultBO> page, Long userId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param consult 实例对象
     * @return 对象列表
     */
    List<ConsultBO> queryAll(ConsultBO consult);

    /**
     * 新增数据
     *
     * @param consult 实例对象
     * @return 影响行数
     */
    int insert(ConsultBO consult);

    /**
     * 修改数据
     *
     * @param consult 实例对象
     * @return 影响行数
     */
    int update(ConsultBO consult);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int queryReply(@Param("userId")Long userId,@Param("cation")String cation);

    int queryCount(@Param("userId")Long userId);
}