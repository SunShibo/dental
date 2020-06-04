package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.InformBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * (Inform)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 16:09:28
 */
@Component
public interface InformDAO {

    List<InformBO> queryNewInform();

    List<InformBO> queryDoctorNewInform();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InformBO queryById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    InformBO queryByType(String type);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<InformBO> queryAllByLimit(Page<InformBO> page,@Param("userId")Long userId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param inform 实例对象
     * @return 对象列表
     */
    List<InformBO> queryAll(InformBO inform);

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 影响行数
     */
    int insert(InformBO inform);

    /**
     * 修改数据
     *
     * @param inform 实例对象
     * @return 影响行数
     */
    int update(InformBO inform);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int newInform(Long userId);
}