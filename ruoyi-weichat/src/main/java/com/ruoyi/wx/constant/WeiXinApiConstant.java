package com.ruoyi.wx.constant;

/**
 * @author TwoKe
 * @desc 微信API调用常量类
 * @date 2020/6/30
 */
public class WeiXinApiConstant {

    public static final String ERR_CODE = "errcode";
    public static final String ERR_MSG = "errmsg";

    /**
     * 微信小程序的应用id占位符字段
     */
    public static final String $_APP_ID = "APPID";

    /**
     * 微信小程序的应用秘钥占位符字段
     */
    public static final String $_SECRET = "SECRET";

    /**
     * 登录验证用的code占位字段
     */
    public static final String $_JS_CODE = "JSCODE";

    /**
     * 接口调用凭据
     */
    public static final String $_ACCESS_TOKEN = "ACCESS_TOKEN";

    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
     */
    public static final String UNION_ID = "unionid";

    /**
     * 微信用户获取openid的API接口
     * https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
     * APPID 微信小程序的应用id
     * SECRET 微信小程序的应用秘钥
     * JSCODE 登录验证用的code
     */
    public static final String AUTH_CODE_TO_SESSION_API = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 微信用户唯一id
     */
    public static final String OPENID = "openid";

    /**
     * 会话秘钥
     */
    public static final String SESSION_KEY = "session_key";


    /**
     * 获取小程序全局唯一后台接口调用凭据（access_token）。调用绝大多数后台接口时都需使用 access_token，开发者需要进行妥善保存。
     * GET https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET
     * 请求
     */
    public static final String AUTH_GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";

    /**
     * 接口调用凭据
     */
    public static final String ACCESS_TOKEN = "access_token";

    /**
     * 过期时间
     */
    public static final String EXPIRES_IN = "expires_in";



    /**
     * 发送订阅消息API
     */
    public static final String SUBSCRIBE_MESSAGE_SEND_API = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=ACCESS_TOKEN";


    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
     */
    public static final String WXA_CODE_GET_UNLIMITED = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";


    /**
     * 获取小程序二维码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制
     */
    public static final String  WXA_CODE_CREATE_QR_CODE = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=ACCESS_TOKEN";


    /**
     * 获取小程序码，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制，
     */
    public static final String WXA_CODE_GET= "https://api.weixin.qq.com/wxa/getwxacode?access_token=ACCESS_TOKEN";












}
