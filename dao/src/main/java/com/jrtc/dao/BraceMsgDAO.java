package com.jrtc.dao;

import com.jrtc.base.entity.bo.BraceMsgBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;



/**
 * (BraceMsg)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 18:55:16
 */
@Component
public interface BraceMsgDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BraceMsgBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BraceMsgBO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<BraceMsgBO> queryAll(@Param("userId")Long userId);

    /**
     * 新增数据
     *
     * @param braceMsg 实例对象
     * @return 影响行数
     */
    int insert(BraceMsgBO braceMsg);

    /**
     * 修改数据
     *
     * @param braceMsg 实例对象
     * @return 影响行数
     */
    int update(BraceMsgBO braceMsg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    BraceMsgBO queryNext(@Param("date")String date,@Param("userId")Long userId);

    BraceMsgBO queryThis(@Param("date")String date,@Param("userId")Long userId);

    Integer queryThisNumber(@Param("date")String date,@Param("userId")Long userId);

    /**
     * 以制作数量
     * @param userId
     * @return
     */
    int first(@Param("userId")Long userId);

    /**
     * 大于当前时间 确认制作数量
     * @param date
     * @param userId
     * @return
     */
    int showNext(@Param("date")String date,@Param("userId") Long userId,@Param("status")String status);


    List<Long> queryMake(@Param("userId") Long userId);


    void updaMake(@Param("ids")List<Long> ids);
    /**
     * 开始时间是否在已确认中间
     */
    int queryCont(@Param("userId")Long userId, @Param("startTime")Date startTime) ;



    List<BraceMsgBO> queryBrace(@Param("userId") Long userId,@Param("id") Long id);
}