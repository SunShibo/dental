package com.jrtc.service;

import com.jrtc.base.entity.bo.BannerBO;
import com.jrtc.dao.BannerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Banner)表服务实现类
 *
 * @author makejava
 * @since 2020-03-27 22:45:21
 */
@Service("bannerService")
public class BannerService  {
    @Autowired
    private BannerDAO bannerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public BannerBO queryById(Long id) {
        return this.bannerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public List<BannerBO> queryAll() {
        return this.bannerDao.queryAllByLimit();
    }

    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    public BannerBO insert(BannerBO banner) {
        banner.setCreateTime(new Date());
        this.bannerDao.insert(banner);
        return banner;
    }

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    public BannerBO update(BannerBO banner) {
        this.bannerDao.update(banner);
        return this.queryById(banner.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.bannerDao.deleteById(id) > 0;
    }
}