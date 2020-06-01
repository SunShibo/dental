package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.DoctorBO;
import com.jrtc.base.entity.bo.PatientBO;
import com.jrtc.base.entity.bo.UserBO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-26 01:25:29
 */
@Component
public interface UserDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */

    IPage<UserBO> queryAll(Page<UserBO> page, @Param("user")UserBO user);
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(UserBO user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(UserBO user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    UserBO queryByPhone(String mobile);

    /**
     * 查询医生id名称
     * @return
     */
    List<DoctorBO> queryDocId();

    int queryCount(@Param("state")String state,@Param("doctorId")Long doctorId,@Param("name")String name);

    IPage<PatientBO>  queryPatient(Page<PatientBO> page ,@Param("user")UserBO userBO);

    int queryUserByPhone(@Param("phone") String phone);
}