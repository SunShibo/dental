package com.jrtc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.*;
import com.jrtc.base.util.DateUtil;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.BraceMsgDAO;
import com.jrtc.dao.ClinicalOperationDao;
import com.jrtc.dao.ConsultDAO;
import com.jrtc.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDAO userDao;
    @Autowired
    private ConsultDAO consultDAO;
    @Autowired
    private BraceMsgDAO braceMsgDao;
    @Autowired
    private ClinicalOperationDao clinicalOperationDao;
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
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public Integer updatePassword(UserBO user) {
        return userDao.updatePassword(user);
    }




    /**
     * 修改方案确认状态
     *
     * @param user 实例对象
     * @return 实例对象
     */
    public void updateBrace(UserBO user) {
        userDao.update(user);
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

    public Map<String,Object> queryPatient(String state,Long doctorId,String name,PageUtil pageUtil) {
        log.info("计算时间");
        String date = DateUtil.simpDateStr("yyyy-MM-dd",new Date());
        log.info("state："+state);
        log.info("doctorId："+doctorId);
        Map<String,Object> result=new HashMap<String,Object>();
        int underway = userDao.queryCount("underway", doctorId,name);
        log.info("underway："+underway);
        int accomplish = userDao.queryCount("accomplish", doctorId,name);
        log.info("accomplish："+accomplish);

        UserBO userBO=new UserBO();
        userBO.setStatus(Constants.YES.getValue());
        userBO.setDoctorId(doctorId);
        userBO.setState(state);
        userBO.setName(name);
        log.info("查询："+accomplish);
        Page<PatientBO> page = new Page<PatientBO>(pageUtil.getPageNo(), pageUtil.getPageSize());
        log.info("查询中");
        IPage<PatientBO> patientBOIPage = userDao.queryPatient(page, userBO);
        log.info("查询结果："+patientBOIPage);
        List<PatientBO> records = patientBOIPage.getRecords();
        log.info("对象集size："+records.size());
        if(records!=null && records.size()>0){
            for(PatientBO patient:records){
                log.info("进入循环："+patient);
                int consult = consultDAO.queryReply(patient.getId(), "user");
                log.info("consult："+consult);
                patient.setConsult(consult);
                BraceMsgBO braceMsgBO = braceMsgDao.queryThis(date, patient.getId());
                log.info("braceMsgBO："+braceMsgBO);
                if(braceMsgBO!=null){
                    log.info("braceMsgBO：!=null)");
                    patient.setStage(braceMsgBO.getName());
                    log.info("braceMsgBO.getStage()+braceMsgBO.getName()"+braceMsgBO.getStage()+braceMsgBO.getName());
                }

                ClinicalOperation clinicalOperation=new ClinicalOperation();
                clinicalOperation.setUserId(patient.getId().intValue());
                List<ClinicalOperation> clinicalOperationList =clinicalOperationDao.queryAll(clinicalOperation);
                patient.setClinicalOperations(clinicalOperationList);
            }
        }
        result.put("underway",underway);
        result.put("accomplish",accomplish);
        result.put("patient",patientBOIPage);
        log.info("service结束"+result);
        return result;
    }

    public int queryUserByPhone(String phone) {
        return userDao.queryUserByPhone(phone);
    }


}