package com.jrtc.service;

import com.jrtc.base.entity.bo.ConsultImgBO;
import com.jrtc.dao.ConsultImgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * (ConsultImg)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 14:03:41
 */
@Service("consultImgService")
public class ConsultImgService {
    @Autowired
    private ConsultImgDAO consultImgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ConsultImgBO queryById(Long id) {
        return this.consultImgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<ConsultImgBO> queryAllByLimit(int offset, int limit) {
        return this.consultImgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param consultImg 实例对象
     * @return 实例对象
     */
    public ConsultImgBO insert(ConsultImgBO consultImg) {
        this.consultImgDao.insert(consultImg);
        return consultImg;
    }

    /**
     * 修改数据
     *
     * @param consultImg 实例对象
     * @return 实例对象
     */
    public ConsultImgBO update(ConsultImgBO consultImg) {
        this.consultImgDao.update(consultImg);
        return this.queryById(consultImg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.consultImgDao.deleteById(id) > 0;
    }
}