package com.jrtc.dao;

import com.jrtc.base.entity.bo.BannerBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Banner)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-27 22:45:20
 */
@Component
public interface BannerDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BannerBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<BannerBO> queryAllByLimit();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param banner 实例对象
     * @return 对象列表
     */
    List<BannerBO> queryAll(BannerBO banner);

    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 影响行数
     */
    int insert(BannerBO banner);

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 影响行数
     */
    int update(BannerBO banner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}