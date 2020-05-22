package com.jrtc.service;

import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.ConsultBO;
import com.jrtc.base.entity.bo.ConsultImgBO;
import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.JsonUtils;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.ConsultDAO;
import com.jrtc.dao.ConsultImgDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * (Consult)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 14:03:33
 */
@Service("consultService")
public class ConsultService {
    @Autowired
    private ConsultDAO consultDao;
    @Autowired
    private ConsultImgDAO consultImgDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ConsultBO queryById(Long id) {
        return this.consultDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public IPage<ConsultBO> queryAllByLimit(PageUtil pageUtil, Long userId,String type) {
        Page<ConsultBO> page = new Page<ConsultBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<ConsultBO> iPage = consultDao.queryAllByLimit(page, userId);

        List<ConsultBO> consultBOS=iPage.getRecords();
        for (ConsultBO c :consultBOS) {
            List<ConsultBO> childIPage = consultDao.queryAllByPid(c.getId());
            if(childIPage==null){
                continue;
            }
            for (ConsultBO cc :childIPage) {
                if(type.equals("doctor")&&cc.getCation().equals("user")&&cc.getRead().equals("no")){
                    c.setConsultStatus("yes");
                }

                if(type.equals("user")&&cc.getCation().equals("doctor")&&cc.getRead().equals("no")){
                    c.setConsultStatus("yes");
                }

            }
        }
        return iPage;
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    public ConsultBO insert(ConsultBO consult, String imgJsonStr) {
        consult.setCreateTime(new Date());
        consult.setRead(Constants.NO.getValue());
        consult.setStatus(Constants.YES.getValue());
        this.consultDao.insert(consult);
        if (!StringUtils.isEmpty(imgJsonStr)) {
            String[] stringArray4Json = JsonUtils.getStringArray4Json(imgJsonStr);
            for (String img : stringArray4Json) {
                ConsultImgBO imgBO = new ConsultImgBO();
                imgBO.setCId(consult.getId());
                imgBO.setImg(img);
                consultImgDAO.insert(imgBO);
            }
        }

        return consult;
    }

    public List<ConsultBO> queryAll(ConsultBO consultBO){

        ConsultBO consultBO1=new ConsultBO();
        consultBO1.setPid(consultBO.getPid());
        consultBO1.setId(consultBO.getId());
        consultBO1.setRead("yes");
        if(consultBO.getCation().equals("user")){
            //把pid下医生回复的消息都变成以读
            consultBO1.setCation("doctor");
        }else {
            consultBO1.setCation("user");
        }

        consultDao.updateByPid(consultBO1);
        return consultDao.queryAll(consultBO.getPid());
    }
    /**
     * 修改数据
     *
     * @param consult 实例对象
     * @return 实例对象
     */
    public ConsultBO update(ConsultBO consult) {
        this.consultDao.update(consult);
        return this.queryById(consult.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.consultDao.deleteById(id) > 0;
    }

    public int queryReply(Long userId, String cation) {
        return consultDao.queryReply(userId, cation);
    }

    public int queryCount(Long userId) {
        return consultDao.queryCount(userId);
    }

}