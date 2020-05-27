package com.jrtc.service;


import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.bo.SchemeBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.dao.InformDAO;
import com.jrtc.dao.SchemeDAO;
import com.jrtc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Scheme)表服务实现类
 *
 * @author makejava
 * @since 2020-03-28 18:19:41
 */
@Service("schemeService")
public class SchemeService {
    @Autowired
    private SchemeDAO schemeDao;

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InformDAO informDAO;

    public void confirmScheme(Long userId, String cation) {
        UserBO userBOOld = userDAO.queryById(userId);

        //修改user表 方案状态
        UserBO userBO = new UserBO();
        userBO.setId(userId);
        if (cation.equals("user")) {
            userBO.setBraceStatus("yes");
        } else {
            userBO.setScheme("yes");
        }
        userDAO.update(userBO);

        //后台添加通知
        InformBO informBO = new InformBO();
        informBO.setUserId(-1L);
        informBO.setStatus("no");
        if (cation.equals("user")) {
            informBO.setContent("用户:" + userBOOld.getName() + ",手机号:" + userBOOld.getPhone() + ",用户以确认制作");
        } else {
            informBO.setContent("用户:" + userBOOld.getName() + ",手机号:" + userBOOld.getPhone() + "，医生以确认制作");
        }
        informDAO.insert(informBO);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public SchemeBO queryById(Long id) {
        return this.schemeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public List<SchemeBO> queryAllByUserId(Long userId) {
        return this.schemeDao.queryAllByUserId(userId);
    }

    /**
     * 新增数据
     *
     * @param scheme 实例对象
     * @return 实例对象
     */

    public SchemeBO insert(SchemeBO scheme) {
        this.schemeDao.insert(scheme);
        return scheme;
    }

    /**
     * 修改数据
     *
     * @param scheme 实例对象
     * @return 实例对象
     */
    public SchemeBO update(SchemeBO scheme) {
        this.schemeDao.update(scheme);
        return this.queryById(scheme.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.schemeDao.deleteById(id) > 0;
    }
}