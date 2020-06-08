package com.jrtc.controllerapi;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.utils.StringUtils;
import com.jrtc.base.config.constants.Constants;
import com.jrtc.base.entity.bo.UserBO;
import com.jrtc.base.entity.dto.ResultDTO;
import com.jrtc.base.entity.dto.ResultDTOBuilder;
import com.jrtc.base.util.AccountValidatorUtil;
import com.jrtc.base.util.RedisUtil;
import com.jrtc.base.util.SendMessageUtil;
import com.jrtc.controllerapi.base.BaseController;

import com.jrtc.service.KeyValueService;
import com.jrtc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private KeyValueService keyValueService;


    //修改密码
    /**
     * 发送验证码
     * 登陆注册
     * 修改绑定
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/updatePassword" ,method = RequestMethod.POST)
    public ResultDTO updatePassword(String phone,String vCode,String newPass, HttpServletRequest request, HttpServletResponse response) {
        log.info("start...........updatePassword.................");
        if (!verifyParam(phone)) {
            return ResultDTOBuilder.failure("00001");
        }
        //手机号非空+格式判断
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }

        //获取Redis中的用户验证码
//        Object o = redisUtil.get(phone + Constants.CAPTCHA.getValue());
//        if (o == null) {
//            return ResultDTOBuilder.failure("02002");
//        }
//        String mobileAuthCode = String.valueOf(o);
//        System.out.println("mobileAuthCode"+mobileAuthCode);
//        //如果和用户收到的验证码相同
//        if (!vCode.equals(mobileAuthCode)) {
//            return ResultDTOBuilder.failure("02002");
//        }

        UserBO userBO=new UserBO();
        userBO.setPassword(SecureUtil.md5(newPass));
        userBO.setPhone(phone);
        Integer result=userService.updatePassword(userBO);
        System.out.println("result"+result);
        return ResultDTOBuilder.success();
    }

    /**
     * 发送验证码
     * 登陆注册
     * 修改绑定
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/send" ,method = RequestMethod.POST)
    public ResultDTO send(String phone, String templateCode, HttpServletRequest request, HttpServletResponse response) {
        log.info("start...........send.................");
        if (!verifyParam(phone)) {
            return ResultDTOBuilder.failure("00001");
        }
        //手机号非空+格式判断
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }
        String captcha = String.valueOf(RandomUtil.randomInt(100000, 999999));
        CommonResponse commonResponse = SendMessageUtil.sendSignInCodeMessage(phone, captcha, null);
        redisUtil.set(phone + Constants.CAPTCHA.getValue(), captcha, 60 * 5);  //有效期
        return ResultDTOBuilder.success(commonResponse);
    }


    /**
     * 登录
     *
     * @param phone  手机号
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResultDTO login(String phone, String  password, HttpServletResponse response, HttpServletRequest request) {

      log.info("start.....................register.....................................");
        //用户传参非空判断
        if (!verifyParam(phone ,password )) {
            return ResultDTOBuilder.failure("00001");
        }
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }
        UserBO userBO = userService.queryByPhone(phone);
        if(userBO==null){
            //用户不存在
            return ResultDTOBuilder.failure("02005");
        }
        //账号状态异常
        if(!userBO.getStatus().equals( Constants.YES.getValue())){
            return ResultDTOBuilder.failure("02003");
        }
        if(!SecureUtil.md5(password).equals(userBO.getPassword())){
            return ResultDTOBuilder.failure("02006");
        }
        super.putLoginUser(userBO, response);
        return ResultDTOBuilder.success(userBO);
    }

    public static void main(String[] args) {
        String s = SecureUtil.md5("15214440324.");
        System.out.println(s);
    }

    /**
     * 注册
     *
     * @param phone  手机号
     * @param verify 用户验证码
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ResultDTO register(String phone, String verify,String password , HttpServletResponse response, HttpServletRequest request) {
        log.info("start.....................register.....................................");
        //用户传参非空判断
        if (!verifyParam(verify, phone,password)) {
            return ResultDTOBuilder.failure("00001");
        }
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }
        UserBO userBO = userService.queryByPhone(phone);
        if(userBO!=null){
            //用户已存在
            return ResultDTOBuilder.failure("02008");
        }

        //获取Redis中的用户验证码
        Object o = redisUtil.get(phone + Constants.CAPTCHA.getValue());
        if (o == null) {
            return ResultDTOBuilder.failure("02001");
        }
        String mobileAuthCode = String.valueOf(o);
        //如果和用户收到的验证码相同
        if (!verify.equals(mobileAuthCode)) {
            return ResultDTOBuilder.failure("02002");
        }

        UserBO newUser = new UserBO();
        //设置默认昵称
        String str1=phone.substring(0,3);
        String str2=phone.substring(7,11);
        newUser.setName("用户_" + str1+"****"+str2);
        newUser.setPhone(phone);
        newUser.setPassword(SecureUtil.md5(password));
        newUser.setCreateTime(new Date());
        newUser.setStatus(Constants.YES.getValue());
        newUser.setDoctor("no");
        newUser.setState("underway");
         String values = keyValueService.getValueByKey(Constants.HEAD.getValue()).getValues();
        newUser.setHead(values); //获取默认头像
        userService.insert(newUser);
        return ResultDTOBuilder.success();
    }


    /**
     * 重置密码
     */
    @RequestMapping(value = "/reset" ,method = RequestMethod.POST )
    public ResultDTO reset(String phone, String verify,String password , HttpServletResponse response, HttpServletRequest request) {
        //用户传参非空判断
        if (!verifyParam(verify, phone,password)) {
            return ResultDTOBuilder.failure("00001");
        }
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }
        UserBO userBO = userService.queryByPhone(phone);
        if(userBO==null){
            //用户已存在
            return ResultDTOBuilder.failure("02005");
        }
        //获取Redis中的用户验证码
        Object o = redisUtil.get(phone + Constants.CAPTCHA.getValue());
        if (o == null) {
            return ResultDTOBuilder.failure("02001");
        }
        String mobileAuthCode = String.valueOf(o);
        if (!verify.equals(mobileAuthCode)) {
            return ResultDTOBuilder.failure("02002");
        }
        userBO.setPassword(SecureUtil.md5(password));
        userService.update(userBO);
        return ResultDTOBuilder.success();
    }



    /**
     * 修改用户信息
     *  @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    public ResultDTO updateUser(HttpServletResponse response, HttpServletRequest request, UserBO userParam) {
        UserBO loginUser = super.getLoginUser(request);
        userParam.setId(loginUser.getId());
        if(!StringUtils.isEmpty(userParam.getPassword())){
            userParam.setPassword(SecureUtil.md5(userParam.getPassword()));
        }
        userService.update(userParam);
        return ResultDTOBuilder.success(userParam);
    }

    /**
     * 查询用户信息
     *
     * @param response
     * @param request
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/queryUserByPhone" ,method = RequestMethod.POST)
    public ResultDTO queryUserByPhone(HttpServletResponse response, HttpServletRequest request,String phone,String verify) throws Exception {
        if (!verifyParam(verify, phone)) {
            return ResultDTOBuilder.failure("00001");
        }

        //获取Redis中的用户验证码
        Object o = redisUtil.get(phone + Constants.CAPTCHA.getValue());
        if (o == null) {
            return ResultDTOBuilder.failure("02001");
        }

        String mobileAuthCode = String.valueOf(o);
        if (!verify.equals(mobileAuthCode)) {
            return ResultDTOBuilder.failure("02002");
        }

        return ResultDTOBuilder.success();
    }



    /**
     * 查询用户信息
     *
     * @param response
     * @param request
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/selectUser" ,method = RequestMethod.POST)
    public ResultDTO selectUser(HttpServletResponse response, HttpServletRequest request) throws Exception {
        UserBO user = this.getLoginUser(request);
        UserBO userBO = userService.queryById(user.getId());
        return ResultDTOBuilder.success(userBO);
    }

    /**
     * 退出登录
     *
     * @param response
     * @param request
     * @throws Exception
     * @return
     */
    @RequestMapping(value = "/outLogin" ,method = RequestMethod.POST)
    public ResultDTO outLogin(HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {
            super.delLoginUser(request,response);
        }catch (Exception e){
        }
        return ResultDTOBuilder.success();
    }




    /**
     * QQ and 微信登陆
     * param openid为微信账号 或者qq号
     * status代表微信或者qq
     *
     * @return
     */
   /* @RequestMapping("/openidLogin")
    public ResultDTO openidLogin(HttpServletRequest request, HttpServletResponse response, String openid, String status) {
        log.info("start...............openidLogin..........................................");
        //参数验证
        if (!verifyParam(openid, status)) {
            return ResultDTOBuilder.failure("00001");
        }
        log.info("获取到和openid绑定的手机号");
        //获取到和openid绑定的手机号
        String mobile = userService.queryByOpenid(openid, status);
        log.info("com.wisewin.api.service.UserService.checkBind返回{}", mobile);
        if (mobile == null) {
            return ResultDTOBuilder.failure("02004");
        }
        //返回给前端的数据
        Map<String, Object> resultMap = new HashMap<String, Object>();
        UserBO userBO = userService.queryByPhone(mobile);
        if (!Constants.YES.getValue().equals(userBO.getStatus())) {
            return ResultDTOBuilder.failure("02003");
        }

        userService.update(userBO);
        super.putLoginUser(userBO, response);
        resultMap.put("isLogin", Constants.YES.getValue());
        resultMap.put("user", userBO);
        return ResultDTOBuilder.success(userBO);
    }*/


    /**
     * 绑定openid 用户注册 登陆
     *
     * @return
     */
  /*  @RequestMapping("/bindOpenidLogin")
    public ResultDTO bindOpenidLogin(String phone, String verify, String status, String openid, HttpServletRequest request, HttpServletResponse response) {
        log.info("start***********************bindOpenidLogin***********************");
        //用户传参非空判断
        if (verifyParam(phone, verify, status, openid)) {
            return ResultDTOBuilder.failure("00001");
        }
        if (!AccountValidatorUtil.isMobile(phone)) {
            return ResultDTOBuilder.failure("02000");
        }
        Object o = redisUtil.get(phone + Constants.CAPTCHA.getValue());
        if (o == null) {
            return ResultDTOBuilder.failure("02001");
        }
        String mobileAuthCode = String.valueOf(o);

        if (!verify.equals(mobileAuthCode)) {
            return ResultDTOBuilder.failure("02002");
        }

        UserBO userBO = userService.queryByPhone(phone);
        Map<String, Object> resultMap = new HashMap<String, Object>();
      *//*  if (userBO != null) {
            if (Constants.USABLE.getValue().equals(userBO.getStatus())) {
                userBO.setLastLoginTime(new Date());
                userBO.setLastLoginIp(RequestIP.getIPAddress(request));
                if (status.equals(Constants.QQ.getValue())) {
                    userBO.setQqOpenid(openid);
                } else if (status.equals(Constants.WEIXIN.getValue())) {
                    userBO.setWeixinOpenid(openid);
                }
                userBO.setLastLoginIp(RequestIP.getIPAddress(request));
                userService.update(userBO);
                super.putLoginUser(userBO, response);
            }
            resultMap.put("isLogin", Constants.YES.getValue());
            resultMap.put("user", userBO);
            return ResultDTOBuilder.failure("02003");
        } else {
            //注册
            UserBO newUser = new UserBO();
            //设置默认昵称
            newUser.setNickname("用户_" + phone);
            newUser.setMobile(phone);
            newUser.setLastLoginTime(new Date());
            newUser.setLastLoginIp(RequestIP.getIPAddress(request));
            newUser.setAddTime(new Date());
            newUser.setStatus(Constants.USABLE.getValue());
            if (status.equals(Constants.QQ.getValue())) {
                newUser.setQqOpenid(openid);
            } else if (status.equals(Constants.WEIXIN.getValue())) {
                newUser.setWeixinOpenid(openid);
            }
            userService.insert(newUser);
            super.putLoginUser(newUser, response);
            resultMap.put("isLogin", Constants.NO.getValue());
            resultMap.put("user", newUser);
        }*//*
        return ResultDTOBuilder.success(resultMap);
    }*/


    /**
     * 解除绑定
     * @return
     */
   /* @RequestMapping("/removeOpenid")
    public ResultDTO removeOpenid(String status, HttpServletRequest request, HttpServletResponse response) {
        //从cookie中获取他的user对象的id
        UserBO loginUser = super.getLoginUser(request);
        //判断参数
        if (StringUtils.isEmpty(status)) {
            return ResultDTOBuilder.failure("00001");
        }
        userService.removeOpenId(loginUser.getId(),status);
        return ResultDTOBuilder.success();
    }*/



}