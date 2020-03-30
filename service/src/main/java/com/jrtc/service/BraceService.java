package com.jrtc.service;

import com.jrtc.base.entity.bo.BraceBO;
import com.jrtc.dao.BraceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Brace)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 18:55:08
 */
@Service("braceService")
public class BraceService {
    @Autowired
    private BraceDAO braceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public BraceBO queryById(Long id) {
        return this.braceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<BraceBO> queryAllByLimit(int offset, int limit) {
        return this.braceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param brace 实例对象
     * @return 实例对象
     */
    public BraceBO insert(BraceBO brace) {
        this.braceDao.insert(brace);
        return brace;
    }

    /**
     * 修改数据
     *
     * @param brace 实例对象
     * @return 实例对象
     */
    public BraceBO update(BraceBO brace) {
        this.braceDao.update(brace);
        return this.queryById(brace.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.braceDao.deleteById(id) > 0;
    }

    public List<BraceBO> queryAll(Long userId) {
       return  braceDao.queryAll(userId);
    }
}