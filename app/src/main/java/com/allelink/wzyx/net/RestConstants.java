package com.allelink.wzyx.net;

/**
 * @author yangc
 * @version 1.0
 * @filename RestConstants
 * @date 2017/11/2
 * @description 保存网络框架所用到的常量
 * @email 1048027353@qq.com
 */

public class RestConstants {
    /**
    * 服务器主机的地址
    */
    public static final String BASE_URL = "http://192.168.1.103:8089/";
    /**
     * 注册的地址
     */
    public static final String REGISTER_URL = BASE_URL + "alllink/user/registered";
    /**
     * 登录的地址
     */
    public static final String SIGN_IN_URL = BASE_URL + "alllink/user/login";
    /**
     * 发送验证码的地址
     */
    public static final String SMS_URL = BASE_URL + "alllink/user/sms";
}
