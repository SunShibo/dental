package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.entity.bo.DoctorBO;
import com.jrtc.base.entity.bo.PatientBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.DateUtil;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.BraceMsgDAO;
import com.jrtc.dao.ConsultDAO;
import com.jrtc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ConsultDAO consultDAO;
    @Autowired
    private BraceMsgDAO braceMsgDao;
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
     * 分页查询用户
     */
    public IPage<UserBO> queryAll(PageUtil pageUtil,UserBO user) {
        Page<UserBO> page = new Page<UserBO>(pageUtil.getPageNo(), pageUtil.getPageSize());
        IPage<UserBO> iPage =userDao.queryAll(page,user);
        return iPage;
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


    public List<DoctorBO> queryDocId() {
        return  userDao.queryDocId();
    }

    public Map<String,Object> queryPatient(String state,Long doctorId,PageUtil pageUtil) {

        String date = DateUtil.simpDateStr("yyyy-MM-dd",new Date());

        Map<String,Object> result=new HashMap<String,Object>();
        int underway = userDao.queryCount("underway", doctorId);
        int accomplish = userDao.queryCount("accomplish", doctorId);
        UserBO userBO=new UserBO();
        userBO.setState(Constants.YES.getValue());
        userBO.setDoctorId(doctorId);
        userBO.setState(state);
        Page<PatientBO> page = new Page<PatientBO>(pageUtil.getPageNo(), pageUtil.getPageSize());
        IPage<PatientBO> patientBOIPage = userDao.queryPatient(page, userBO);
        List<PatientBO> records = patientBOIPage.getRecords();
        if(records!=null && records.size()>0){
            for(PatientBO patient:records){
                int consult = consultDAO.queryReply(patient.getId(), "user");
                patient.setConsult(consult);
                BraceMsgBO braceMsgBO = braceMsgDao.queryThis(date, patient.getId());
                if(braceMsgBO!=null){
                    patient.setStage(braceMsgBO.getStage()+braceMsgBO.getName());
                }

            }
        }
        result.put("underway",underway);
        result.put("accomplish",accomplish);
        result.put("patient",patientBOIPage);
        return result;
    }
}