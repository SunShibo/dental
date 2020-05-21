package com.jrtc.service;

import com.jrtc.base.entity.bo.ClinicalOperation;
import com.jrtc.dao.ClinicalOperationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ClinicalOperation)表服务实现类
 *
 * @author makejava
 * @since 2020-05-20 20:07:22
 */
@Service("clinicalOperationService")
public class ClinicalOperationService {
    @Resource
    private ClinicalOperationDao clinicalOperationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ClinicalOperation queryById(Integer id) {
        return this.clinicalOperationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<ClinicalOperation> queryAllByLimit(int offset, int limit) {
        return this.clinicalOperationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param clinicalOperation 实例对象
     * @return 对象列表
     */
    public List<ClinicalOperation> queryAll(ClinicalOperation clinicalOperation){
        return clinicalOperationDao.queryAll(clinicalOperation);
    }
    /**
     * 新增数据
     *
     * @param clinicalOperation 实例对象
     * @return 实例对象
     */
    public ClinicalOperation insert(ClinicalOperation clinicalOperation) {
        this.clinicalOperationDao.insert(clinicalOperation);
        return clinicalOperation;
    }

    /**
     * 修改数据
     *
     * @param clinicalOperation 实例对象
     * @return 实例对象
     */
    public ClinicalOperation update(ClinicalOperation clinicalOperation) {
        this.clinicalOperationDao.update(clinicalOperation);
        return this.queryById(clinicalOperation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.clinicalOperationDao.deleteById(id) > 0;
    }
}