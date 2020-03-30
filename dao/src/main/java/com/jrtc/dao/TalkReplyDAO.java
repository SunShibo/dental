package com.jrtc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.TalkReplyBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * (TalkReply)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-29 18:39:07
 */
@Component
public interface TalkReplyDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TalkReplyBO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    IPage<TalkReplyBO> queryAllByLimit(Page<TalkReplyBO> page,@Param("mentId")Long mentId);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param talkReply 实例对象
     * @return 对象列表
     */
    List<TalkReplyBO> queryAll(TalkReplyBO talkReply);

    /**
     * 新增数据
     *
     * @param talkReply 实例对象
     * @return 影响行数
     */
    int insert(TalkReplyBO talkReply);

    /**
     * 修改数据
     *
     * @param talkReply 实例对象
     * @return 影响行数
     */
    int update(TalkReplyBO talkReply);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}