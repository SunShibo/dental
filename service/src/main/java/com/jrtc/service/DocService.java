package com.jrtc.service;

import com.jrtc.base.entity.bo.DocBO;
import com.jrtc.dao.DocDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * (Doc)表服务实现类
 *
 * @author makejava
 * @since 2020-04-28 14:17:09
 */
@Service("docService")
public class DocService{

    @Autowired
    private DocDAO docDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public DocBO queryById(Long id) {
        return this.docDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public List<DocBO> queryAll() {
        return this.docDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param doc 实例对象
     * @return 实例对象
     */
    public DocBO insert(DocBO doc) {
        this.docDao.insert(doc);
        return doc;
    }

    /**
     * 修改数据
     *
     * @param doc 实例对象
     * @return 实例对象
     */
    public DocBO update(DocBO doc) {
        this.docDao.update(doc);
        return this.queryById(doc.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.docDao.deleteById(id) > 0;
    }
}