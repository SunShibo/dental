package com.jrtc.controllerapi.listener;


import com.jrtc.base.entity.bo.InformBO;
import com.jrtc.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.message.templatemessage.TemplateMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessageItem;
import weixin.popular.support.TokenManager;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class Scheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    InformService informService;

    //每分钟执行一次
    @Scheduled(fixedRate = 1000 * 40)
    public void sendUserMess() {
//        //查询需要推送的消息
//        List<InformBO> informBOS = informService.queryDoctorNewInform();
//
//        //access_token
//        String access_token = TokenManager.getDefaultToken();
//
//        for (InformBO info : informBOS) {
//            TemplateMessage message = new TemplateMessage();
//            message.setUrl("http://s6dh2b.natappfree.cc/wx/Test");
//            message.setTemplate_id("gBVgMn89kZUl11aZkH7wmZ3LIVPU40AJYtF_u5QqZDw");
//            message.setTouser(info.getOpenId());
//            LinkedHashMap<String, TemplateMessageItem> data = new LinkedHashMap<>();
//            data.put("first", new TemplateMessageItem(info.getContent(), "bule"));
//            data.put("keyword3", new TemplateMessageItem("自动延顺一周", "bule"));
//            data.put("remark", new TemplateMessageItem("如有问题，请联系微信", "bule"));
//            message.setData(data);
//
//            MessageAPI.messageTemplateSend(access_token, message);
//
//            info.setStatus("yes");
//            informService.update(info);
//        }


    }


}
