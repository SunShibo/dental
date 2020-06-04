package com.jrtc.controllerapi;

import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.wechat.config.WXConfig;
import com.jrtc.controllerapi.base.BaseController;
import com.jrtc.service.UserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.MenuAPI;
import weixin.popular.api.MessageAPI;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessageItem;
import weixin.popular.bean.message.templatemessage.TemplateMessageResult;
import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.token.Token;
import weixin.popular.bean.user.User;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.TokenManager;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxController extends BaseController {

    //过滤重复通知
    private static ExpireKey expireKey = new DefaultExpireKey();

    Logger logger = LoggerFactory.getLogger(WxController.class);

    @RequestMapping("/sign")
    public void test(@RequestParam Map<String, String> param, HttpServletResponse response, HttpServletRequest request) throws Exception {
        logger.info("sign start");
        //logger.info("token:"+TokenManager.getDefaultToken());

        ServletInputStream servletInputStream = request.getInputStream();
        ServletOutputStream servletOutputStream = response.getOutputStream();

        //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
        String signature = param.get("signature");
        //时间戳
        String timestamp = param.get("timestamp");
        //随机数
        String nonce = param.get("nonce");
        //随机字符串
        String echostr = param.get("echostr");

        if (signature == null || timestamp == null) {
            logger.info("sign error is null");
            return;
        }
        //和本地token验证
        if (echostr != null & signature.equals(SignatureUtil.generateEventMessageSignature(WXConfig.token, timestamp, nonce))) {
            servletOutputStream.write(echostr.getBytes("utf-8"));
            logger.info("sign success");
        }

        if (servletInputStream != null) {
            EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class, servletInputStream);
            if(eventMessage==null){
                return;
            }
            logger.info("eventMessage:" + ToStringBuilder.reflectionToString(eventMessage));
            //自己组合一个唯一key
            String key = eventMessage.getFromUserName() + "_" + eventMessage.getToUserName() + "_" + eventMessage.getMsgId() + "_" + eventMessage.getCreateTime();

            if (expireKey.exists(key)) {
                //重复消息不做处理（幂等）
                return;
            } else {
                expireKey.add(key);
            }

            XMLMessage xmlMessage = new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), "消息发送成功！！！");
            //回复
            //xmlMessage.outputStreamWrite(servletOutputStream);
        }
    }

    //测试获取token
    public static void main(String[]args){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("https://api.weixin.qq.com" + "/cgi-bin/token")
                .addParameter("grant_type","client_credential")
                .addParameter("appid", WXConfig.APPID_JSAPI)
                .addParameter("secret", "43f647af33f13e824f16e5dc8283d72a")
                .build();
        Token token= LocalHttpClient.executeJsonResult(httpUriRequest,Token .class);
        System.out.println("token:"+token);
        System.out.println("token.getAccess_token():"+token.getAccess_token());


        SnsToken snsToken = SnsAPI.oauth2AccessToken(WXConfig.PUBLIC_JSAPI, WXConfig.appsecret, "011ECbQA1L2aab0mMhPA1Aa0QA1ECbQH");

        User user = SnsAPI.userinfo(snsToken.getAccess_token(), WXConfig.PUBLIC_JSAPI, "zh_CN");

        System.out.println(snsToken.getAccess_token());
    }

    //测试发送模板消息
    @RequestMapping("/SendUserMess")
    public void SendUserMess(){
        //access_token
        String access_token = TokenManager.getDefaultToken();

        TemplateMessage message=new TemplateMessage();
        message.setUrl("https://at.sia-edu.com/wx/Test");
        message.setTemplate_id("ZJG8lf2qj8QqRITYjndqk8mfenfECzyOnuS563RB164");
        UserBO userBO=userService.queryById(70L);
        message.setTouser("userBO.getOpenId()");
        LinkedHashMap<String, TemplateMessageItem> data=new LinkedHashMap<>();
        data.put("first",new TemplateMessageItem("等待发起拼课\n" +
                "你的课程还未创建，快去创建吧！创建用户可获得课程礼包一份！\n","bule"));
        data.put("keyword1",new TemplateMessageItem("","bule"));
        data.put("remark",new TemplateMessageItem("详细地址：","bule"));
        message.setData(data);

        TemplateMessageResult templateMessage= MessageAPI.messageTemplateSend(access_token,message);

    }

    //创建菜单
    @RequestMapping("/createMenu")
    public BaseResult createMenu() {
        String menuJson = " {\n" +
                "     \"button\":[\n" +
                "     {\t\n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"今日歌曲\",\n" +
                "          \"key\":\"V1001_TODAY_MUSIC\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"菜单\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"搜索\",\n" +
                "               \"url\":\"http://www.soso.com/\"\n" +
                "            },\n" +
                "           \n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"赞一下我们\",\n" +
                "               \"key\":\"V1001_GOOD\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";
        BaseResult baseResult = MenuAPI.menuCreate(TokenManager.getDefaultToken(), menuJson);
        return baseResult;
    }

    /*
     * 引导用户进入授权页面同意授权，获取code
     * 回调到redirect_uri地址，返回code，获取openId、用户信息
     * @return
     * http://9amahd.natappfree.cc/wx/authorize
     * 注意需要修改	网页授权获取用户基本信息 域名地址
     */
    @RequestMapping("/authorize")
    public void authorize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserBO userBO=super.getLoginUser(request);

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WXConfig.PUBLIC_JSAPI
                + "&redirect_uri="+WXConfig.redirect_uri+"/wx/getOpenId?userId="+userBO.getId()
                + "&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        System.out.println(url);

        response.sendRedirect(url);
    }

    @Autowired
    UserService userService;

    /**
     * 同意授权、回调到这里
     * 获取用户的openId
     */
    @RequestMapping("/getOpenId")
    @ResponseBody
    public ResultDTO getOpenId(@RequestParam Map<String, String> map) {
        logger.info("getOpenId start");

        String code = map.get("code");

        logger.info("code:"+code);

        SnsToken snsToken = SnsAPI.oauth2AccessToken(WXConfig.PUBLIC_JSAPI, WXConfig.appsecret, code);

        logger.info("token:========"+snsToken.getAccess_token());
        User user = SnsAPI.userinfo(snsToken.getAccess_token(), WXConfig.PUBLIC_JSAPI, "zh_CN");

        logger.info("user:" + ToStringBuilder.reflectionToString(user));
        logger.info("openId:" + user.getOpenid());

        Long userId=new Long(map.get("userId"));
        UserBO userBO=new UserBO();
        userBO.setId(userId);
        userBO.setOpenId(user.getOpenid());
        userService.update(userBO);
        return ResultDTOBuilder.success();
    }


    @RequestMapping("/send")
    public TemplateMessageResult send() {
        //access_token
        String access_token = TokenManager.getDefaultToken();

        TemplateMessage message=new TemplateMessage();
        message.setUrl("http://s6dh2b.natappfree.cc/wx/Test");
        message.setTemplate_id("SSJfcb0vUo7dCzcGUM1f2vJjuQPnRjmXHGThczIaNX8");
        message.setTouser("oAdmct2ZZedyNScPKMmqOBE0vzwE");
        LinkedHashMap<String, TemplateMessageItem> data=new LinkedHashMap<>();
        data.put("first",new TemplateMessageItem("体适能啦啦操","bule"));
        data.put("keyword1",new TemplateMessageItem("2020-2-2 体适能啦啦操课程","bule"));
        data.put("keyword2",new TemplateMessageItem("拼单失败，以延顺","bule"));
        data.put("keyword3",new TemplateMessageItem("拼单失败","bule"));
        data.put("remark",new TemplateMessageItem("详情（跳转到小程序）","bule"));
        message.setData(data);

        TemplateMessageResult templateMessage=MessageAPI.messageTemplateSend(access_token,message);
        return templateMessage;
    }



    @RequestMapping("Test")
    public void Test(){
        SnsToken snsToken = SnsAPI.oauth2AccessToken(WXConfig.PUBLIC_JSAPI, WXConfig.appsecret, "011ECbQA1L2aab0mMhPA1Aa0QA1ECbQH");

        User user = SnsAPI.userinfo(snsToken.getAccess_token(), WXConfig.PUBLIC_JSAPI, "zh_CN");

    }


}
