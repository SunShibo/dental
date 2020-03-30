package com.jrtc.service;

import com.jrtc.base.entity.bo.TalkImgBO;
import com.jrtc.dao.TalkImgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * (TalkImg)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 18:38:55
 */
@Service("talkImgService")
public class TalkImgService {
    @Autowired
    private TalkImgDAO talkImgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TalkImgBO queryById(Long id) {
        return this.talkImgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<TalkImgBO> queryAllByLimit(int offset, int limit) {
        return this.talkImgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param talkImg 实例对象
     * @return 实例对象
     */
    public TalkImgBO insert(TalkImgBO talkImg) {
        this.talkImgDao.insert(talkImg);
        return talkImg;
    }

    /**
     * 修改数据
     *
     * @param talkImg 实例对象
     * @return 实例对象
     */
    public TalkImgBO update(TalkImgBO talkImg) {
        this.talkImgDao.update(talkImg);
        return this.queryById(talkImg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.talkImgDao.deleteById(id) > 0;
    }
}