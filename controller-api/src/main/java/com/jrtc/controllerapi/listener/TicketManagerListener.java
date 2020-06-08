package com.jrtc.controllerapi.listener;


import com.jrtc.base.util.wechat.config.WXConfig;
import weixin.popular.support.TicketManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//监听容器启动状态
//项目初始化以后，初始化ticket
@WebListener
public class TicketManagerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("-------------TicketManagerListener contextInitialized-------------");
        //TicketManager.init(WXConfig.PUBLIC_JSAPI,15,60*119);
    }

    @Override
    public  void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------------TicketManagerListener contextDestroyed-------------");
        //TicketManager.destroyed();
    }
}
