package com.jrtc.service;

import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.BraceMsgBO;
import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.DateUtil;
import com.jrtc.dao.BraceMsgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.*;


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
    @Autowired
    private InformService informService;
    @Autowired
    private UserService userService;
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
     * @param limit 查询条queryScheme数
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
     *
     *      如果用户第一次制作，上来就需要显示制作下一阶段
     *      佩戴第九副中，显示制作下一阶段，如果带完这10副没有未制作的，就不应显示 (客户要求)
     *
     */
    public Map<String,Object> queryCountdown(Long userId){
        String date = DateUtil.simpDateStr("yyyy-MM-dd HH:mm:ss",new Date());
        BraceMsgBO nextBrace = braceMsgDao.queryNext(date,userId);
        BraceMsgBO thisBrace = braceMsgDao.queryThis(date,userId);
        Integer thisBraceNumber=braceMsgDao.queryThisNumber(date,userId);

        Map<String,Object> result=new HashMap<>();
        result.put("nextBrace",nextBrace);
        result.put("thisBrace",thisBrace);
        result.put("thisBraceNumber",thisBraceNumber);
        result.put("first", Constants.NO.getValue());
        int first = braceMsgDao.first(userId);
        int showNext = braceMsgDao.showNext(date,userId,"yes");
        int gtNow = braceMsgDao.showNext(date,userId,"no");

         if(first==0 || (showNext<=1 && gtNow>0 )){ //
            result.put("showNext", Constants.YES.getValue());
            result.put("first", Constants.YES.getValue());
        }else {
             result.put("showNext", Constants.NO.getValue());
             result.put("first", Constants.NO.getValue());
        }

        return result;
    }


    /**
     * 修改数据
     *
     * @param brace 实例对象
     * @return 实例对象
     */
    public BraceMsgBO update(BraceMsgBO brace,Long userId) {
        List<BraceMsgBO> braceMsgBOS = queryBrace(userId, brace.getId());
        Date startTime=brace.getStartTime();

        brace.setStartTime(startTime);
        brace.setEndTime(DateUtil.getEndTime(startTime,brace.getNum()-1));
        brace.setNum(brace.getNum());
        brace.setUpdateTime(new Date());
        this.braceMsgDao.update(brace);
        if(braceMsgBOS!=null && braceMsgBOS.size()>1) {
            startTime = DateUtil.getEndTime(startTime, brace.getNum());
            for (int i = 0; i < braceMsgBOS.size(); i++) {
                if (i != 0)
                    startTime = DateUtil.getEndTime(startTime, braceMsgBOS.get(i - 1).getNum());

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startTime);
                // 时
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                // 分
                calendar.set(Calendar.MINUTE, 0);
                // 秒
                calendar.set(Calendar.SECOND, 0);
                // 毫秒
                calendar.set(Calendar.MILLISECOND, 0);
                startTime=calendar.getTime();

                braceMsgBOS.get(i).setStartTime(startTime);
                braceMsgBOS.get(i).setEndTime(DateUtil.getEndTime(startTime, braceMsgBOS.get(i).getNum() - 1));
                braceMsgBOS.get(i).setNum(braceMsgBOS.get(i).getNum());
                braceMsgBOS.get(i).setUpdateTime(new Date());
                this.braceMsgDao.update(braceMsgBOS.get(i));
            }
        }
        return this.braceMsgDao.queryById(brace.getId());
    }


    List<BraceMsgBO> queryBrace(Long userId,Long id){
        return     braceMsgDao.queryBrace(userId,id);
    }




    public List<BraceMsgBO> queryAll(Long userId) {
        return braceMsgDao.queryAll(userId);
    }

    //确认制作
    public void updaMake(Long userId) {
        List<Long> ids = braceMsgDao.queryMake(userId);
        UserBO userBO = userService.queryById(userId);
        //通知医生和后台
        InformBO informBO=new InformBO();
        informBO.setStatus(Constants.NO.getValue());
        informBO.setUserId(-1l);
        informBO.setCreateTime(new Date());
        informBO.setContent("用户："+userBO.getName()+",手机号："+userBO.getPhone()+",已确认制作");
        informService.insert(informBO);
        if(userBO.getDoctorId()!=null){
            informBO.setUserId(userBO.getDoctorId());
            informService.insert(informBO);
        }
        braceMsgDao.updaMake(ids);
    }


    //确认制作
    public void updaUnderMake(Long userId) {
        List<Long> ids = braceMsgDao.queryUnderMake(userId);
        braceMsgDao.updaMake(ids);
    }




    /**
     * 新增数据
     *
     * @param num 总期数
     * @return 实例对象
     */
    public void insert(Long userId,Integer num,Date startTime) {
        for(int i=1;i<=num;i++){
            BraceMsgBO  brace = new BraceMsgBO();
            brace.setStatus(Constants.NO.getValue());
            brace.setUserId(userId);
            brace.setName("第"+i+"副");
            if(i!=1)
                startTime=DateUtil.getEndTime(startTime,14);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startTime);
            // 时
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            // 分
            calendar.set(Calendar.MINUTE, 0);
            // 秒
            calendar.set(Calendar.SECOND, 0);
            // 毫秒
            calendar.set(Calendar.MILLISECOND, 0);
            startTime=calendar.getTime();

            brace.setStartTime(startTime);
            brace.setEndTime(DateUtil.getEndTime(startTime,14));
            brace.setCreateTime(new Date());
            brace.setNum(14);
            braceMsgDao.insert(brace);
        }
    }

    public int queryCont(Long userId,Date startTime){
        return braceMsgDao.queryCont(userId,startTime);
    }

    /**
     * 修改数据
     * @param brace 实例对象
     * @return 实例对象
     */
    public void updateBrace(BraceMsgBO brace) {
        brace.setUpdateTime(new Date());
        braceMsgDao.update(brace);
    }


}