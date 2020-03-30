package com.jrtc.service;

import com.jrtc.base.entity.bo.TalkLikeBO;
import com.jrtc.dao.TalkLikeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * (TalkLike)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 18:39:02
 */
@Service("talkLikeService")
public class TalkLikeService {
    @Autowired
    private TalkLikeDAO talkLikeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TalkLikeBO queryById(Long id) {
        return this.talkLikeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<TalkLikeBO> queryAllByLimit(int offset, int limit) {
        return this.talkLikeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    public TalkLikeBO insert(Long userId,Long cId){
        TalkLikeBO talkLikeBO=new TalkLikeBO();
        if(!this.queryIsLike(cId,userId)){
            talkLikeBO.setUserId(userId);
            talkLikeBO.setCId(cId);
            this.talkLikeDao.insert(talkLikeBO);
        }else{
            this.deleteById(cId,userId);
        }

        return talkLikeBO;
    }

    /**
     * 修改数据
     *
     * @param talkLike 实例对象
     * @return 实例对象
     */
    public TalkLikeBO update(TalkLikeBO talkLike) {
        this.talkLikeDao.update(talkLike);
        return this.queryById(talkLike.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    public boolean deleteById(Long cId,Long userId) {
        return this.talkLikeDao.deleteById(cId,userId) > 0;
    }

    /**
     * 用户是否点过赞
     * @param id
     * @param userId
     */
    public boolean queryIsLike(Long id, Long userId) {
        return talkLikeDao.queryIsLike(id,userId)>0;
    }
}