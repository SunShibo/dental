package com.jrtc.base.config.constants;

public enum Constants {

    /*正常状态*/YES("yes"),
    /*删除|异常状态*/NO("no"),
    /*QQ*/QQ("qq"),
    /*微信*/WEIXIN("weixin"),
    /*验证码后缀*/CAPTCHA("captcha"),
    /*男默认头像*/HEAD("head");

    Constants(String value) {
        this.value = value;
    }
    private String value;

    public String getValue() {
        return value;
    }

}
