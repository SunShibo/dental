package com.jrtc.service;

import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.util.DateUtil;
import com.jrtc.dao.BraceMsgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (BraceMsg)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 18:55:16
 */
@Service("braceMsgService")
public class BraceMsgService  {
    @Autowired
    private BraceMsgDAO braceMsgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public BraceMsgBO queryById(Long id) {
        return this.braceMsgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<BraceMsgBO> queryAllByLimit(int offset, int limit) {
        return this.braceMsgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param braceMsg 实例对象
     * @return 实例对象
     */
    public BraceMsgBO insert(BraceMsgBO braceMsg) {
        this.braceMsgDao.insert(braceMsg);
        return braceMsg;
    }

    /**
     * 修改数据
     *
     * @param braceMsg 实例对象
     * @return 实例对象
     */
    public BraceMsgBO update(BraceMsgBO braceMsg) {
        this.braceMsgDao.update(braceMsg);
        return this.queryById(braceMsg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.braceMsgDao.deleteById(id) > 0;
    }

    /**
     * 倒计时&确认制作
     */
    public Map<String,BraceMsgBO> queryCountdown(Long userId){
        String date = DateUtil.simpDateStr("yyyy-MM-dd",new Date());
        BraceMsgBO nextBrace = braceMsgDao.queryNext(date,userId);
        BraceMsgBO thisBrace = braceMsgDao.queryThis(date,userId);

        Map<String,BraceMsgBO> result=new HashMap<>();
        result.put("nextBrace",nextBrace);
        result.put("thisBrace",thisBrace);

        return result;

    }


}