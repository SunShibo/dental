package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.InformDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * (Inform)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 16:09:29
 */
@Service("informService")
public class InformService {

    @Autowired
    private InformDAO informDao;


    /**
     * 查询未读的信息
     * @return 实例对象
     */
    public List<InformBO> queryNewInform(Long userId) {
        if(userId==null){
            return this.informDao.queryNewInform();
        }else{
            return this.informDao.queryInformUserById(userId);
        }

    }

    /**
     * 查询未读的信息
     * @return 实例对象
     */
    public List<InformBO> queryDoctorNewInform() {
        return this.informDao.queryDoctorNewInform();
    }



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public InformBO queryById(Long id) {
        return this.informDao.queryById(id);
    }

    /**
     * 查询多条数据
     * @return 对象列表
     */
    public IPage<InformBO>  queryAllByLimit(PageUtil pageUtil,Long userId) {
        Page<InformBO> page = new Page<InformBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<InformBO> iPage = informDao.queryAllByLimit(page,userId);
        return iPage;
    }

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    public InformBO insert(InformBO inform) {
        inform.setCreateTime(new Date());
        inform.setStatus(Constants.NO.getValue());
        this.informDao.insert(inform);
        return inform;
    }

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    public InformBO insertDoctor(InformBO inform) {
        inform.setCreateTime(new Date());
        inform.setStatus(Constants.NO.getValue());
        this.informDao.insert(inform);
        return inform;
    }

    /**
     * 修改数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    public InformBO update(InformBO inform) {
        this.informDao.update(inform);
        return this.queryById(inform.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.informDao.deleteById(id) > 0;
    }

    public int newInform(Long userId) {
        return informDao.newInform(userId);
    }
}