package com.jrtc.controllerapi.listener;

import com.jrtc.base.util.wechat.config.WXConfig;
import weixin.popular.support.TicketManager;
import weixin.popular.support.TokenManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//监听容器启动状态
//项目初始化以后，初始化token
@WebListener
public class TokenManagerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("-------------TokenManagerListener contextInitialized-------------");
        TokenManager.init(WXConfig.PUBLIC_JSAPI,WXConfig.appsecret);
    }

    @Override
    public  void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------------TokenManagerListener contextDestroyed-------------");
        TicketManager.destroyed();
    }

}
