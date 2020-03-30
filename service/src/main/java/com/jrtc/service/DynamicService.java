package com.jrtc.service;

import com.jrtc.base.entity.bo.DynamicBO;
import com.jrtc.dao.DynamicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Dynamic)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 15:57:31
 */
@Service("dynamicService")
public class DynamicService {
    @Autowired
    private DynamicDAO dynamicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public DynamicBO queryById(Long id) {
        return this.dynamicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public List<DynamicBO> queryAllByType(Long userId , String type) {
        return this.dynamicDao.queryAllByType(userId,type);
    }

    /**
     * 新增数据
     *
     * @param dynamic 实例对象
     * @return 实例对象
     */
    public DynamicBO insert(DynamicBO dynamic) {
        this.dynamicDao.insert(dynamic);
        return dynamic;
    }

    /**
     * 修改数据
     *
     * @param dynamic 实例对象
     * @return 实例对象
     */
    public DynamicBO update(DynamicBO dynamic) {
        this.dynamicDao.update(dynamic);
        return this.queryById(dynamic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.dynamicDao.deleteById(id) > 0;
    }
}