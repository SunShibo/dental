package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-26 01:25:31
 */
@Service("userService")
public class UserService  {
    @Autowired
    private UserDAO userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public UserBO queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<UserBO> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }



    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public UserBO insert(UserBO user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public UserBO update(UserBO user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    public String queryByOpenid(String openid, String status) {
        return null;
    }

    /**
     * 通过手机号查询用户
     * @param mobile
     * @return
     */
    public UserBO queryByPhone(String mobile) {
        UserBO userBO = userDao.queryByPhone(mobile);
        return userBO;
    }

    public void removeOpenId(Long id, String status) {


    }
}