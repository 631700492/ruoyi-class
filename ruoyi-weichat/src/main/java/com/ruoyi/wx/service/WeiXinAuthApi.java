package com.ruoyi.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.wx.constant.WeiXinApiConstant;
import com.ruoyi.wx.entity.AccessToken;
import com.ruoyi.wx.entity.CodeToSessionResult;
import com.ruoyi.wx.exception.CodeToSessionResultIsNullException;
import org.springframework.stereotype.Component;

/**
 * @author TwoKe
 * @desc 微信授权API
 * @date 2020/6/30
 */
@Component("wxAuth")
public class WeiXinAuthApi extends WeiXinApi{

    private static AccessToken accessToken;

    /**
     * 登录凭证校验,获取微信用户的唯一标识
     */
    public CodeToSessionResult code2Session(String code){
        //1.构造url
        String url = WeiXinApiConstant.AUTH_CODE_TO_SESSION_API
                .replace(WeiXinApiConstant.$_APP_ID,appid)
                .replace(WeiXinApiConstant.$_SECRET,secret)
                .replace(WeiXinApiConstant.$_JS_CODE,code)
                ;
        //2.获取响应结果
        String json = restTemplate.getForObject(url, String.class);
        //3.转化结果
        JSONObject jsonObject = JSONObject.parseObject(json);
        //4.返回结果
        if(jsonObject.get(WeiXinApiConstant.OPENID)!=null){
            CodeToSessionResult result = new CodeToSessionResult();
            result.setOpenid(jsonObject.getString(WeiXinApiConstant.OPENID));
            result.setSessionKey(jsonObject.getString(WeiXinApiConstant.SESSION_KEY));
            if(jsonObject.get(WeiXinApiConstant.UNION_ID)!=null){
                result.setUnionId(jsonObject.getString(WeiXinApiConstant.UNION_ID));
            }
            return result;
        }
        throw new CodeToSessionResultIsNullException(json);
    }

    /**
     * 获取调用凭证
     * @return
     */
    public String getAccessToken(){
        if(accessToken==null||accessToken.getExpiresTime()>=System.currentTimeMillis()){
            //1.构造url
            String url = WeiXinApiConstant.AUTH_GET_ACCESS_TOKEN
                    .replace(WeiXinApiConstant.$_APP_ID, appid)
                    .replace(WeiXinApiConstant.$_SECRET, secret);

            //2.获取响应结果
            String jsonStr = restTemplate.getForObject(url, String.class);
            //3.转化结果
            JSONObject josnObject = JSONObject.parseObject(jsonStr);
            //4.获取调用凭证
            String accessTokenStr = josnObject.getString(WeiXinApiConstant.ACCESS_TOKEN);
            Integer expiresIn = josnObject.getInteger(WeiXinApiConstant.EXPIRES_IN);
            //5.封装调用凭证
            if(accessToken==null){
                accessToken = new AccessToken(accessTokenStr,System.currentTimeMillis()+expiresIn*1000);
            }else{
                accessToken.setAccessToken(accessTokenStr);
                accessToken.setExpiresTime(System.currentTimeMillis()+expiresIn*1000);
            }
        }
        return accessToken.getAccessToken();
    }



}
