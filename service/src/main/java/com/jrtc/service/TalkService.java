package com.jrtc.service;

import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.TalkBO;
import com.jrtc.base.entity.bo.TalkImgBO;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.util.JsonUtils;
import com.jrtc.base.util.PageUtil;
import com.jrtc.dao.TalkDAO;
import com.jrtc.dao.TalkImgDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



/**
 * (Talk)表服务实现类
 *
 * @author makejava
 * @since 2020-03-29 18:38:40
 */
@Service("talkService")
public class TalkService {

    @Autowired
    private TalkDAO talkDao;

    @Autowired
    private TalkImgDAO talkImgDao;

    @Autowired
    private TalkLikeService talkLikeService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TalkBO queryById(Long id) {
        return this.talkDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    public IPage<TalkBO> queryAllByLimit( Long userId, PageUtil pageUtil) {
        Page<TalkBO> page = new Page<TalkBO>(pageUtil.getPageNo(), pageUtil.getPageSize());  // 查询第1页，每页返回5条
        IPage<TalkBO> iPage = talkDao.queryAllByLimit(page);
        List<TalkBO> records = iPage.getRecords();
        if(userId!=null) {
            if (records != null && records.size() > 0) {
                for (TalkBO talkBO : records) {
                    if (talkLikeService.queryIsLike(talkBO.getId(), userId)) {
                        talkBO.setLike(Constants.YES.getValue());
                    }
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
    public TalkBO insert(UserBO userBO,String content,String imgJsonStr) {
        TalkBO talk=new TalkBO();
        talk.setContent(content);
        talk.setUserId(userBO.getId());
        talk.setUserName(userBO.getName());
        talk.setUserHead(userBO.getHead());
        talk.setCreateTime(new Date());
        talk.setStatus(Constants.YES.getValue());
        talkDao.insert(talk);
        if(!StringUtils.isEmpty(imgJsonStr)){
            String[] stringArray4Json = JsonUtils.getStringArray4Json(imgJsonStr);
            for(String str:stringArray4Json){
                TalkImgBO talkBO = new TalkImgBO();
                talkBO.setImg(str);
                talkBO.setTId(talk.getId());
                talkImgDao.insert(talkBO);
            }
        }
        return talk;
    }

    /**
     * 修改数据
     *
     * @param talk 实例对象
     * @return 实例对象
     */
    public TalkBO update(TalkBO talk) {
        this.talkDao.update(talk);
        return this.queryById(talk.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.talkDao.deleteById(id) > 0;
    }
}