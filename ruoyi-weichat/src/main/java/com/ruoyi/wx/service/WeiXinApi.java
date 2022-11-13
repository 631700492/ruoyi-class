package com.ruoyi.wx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * @author TwoKe
 * @desc 微信开放api封装类
 * @date 2020/6/30
 */
public abstract class WeiXinApi {

    @Autowired
    protected RestTemplate restTemplate;

    /**
     * 微信小程序的id
     */
    @Value("${weixin.appId}")
    public String appid;
    /**
     * 微信小程序的秘钥
     */
    @Value("${weixin.appSecret}")
    public String secret;

}
