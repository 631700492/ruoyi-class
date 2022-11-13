package com.ruoyi.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.wx.constant.WeiXinApiConstant;
import com.ruoyi.wx.entity.SubscribeMessageSendEntity;
import com.ruoyi.wx.exception.SubscribeMessageApiException;
import org.springframework.stereotype.Component;

/**
 * @author TwoKe
 * @desc 订阅消息API
 * @date 2020/7/1
 */
@Component("wxSMsg")
public class WeiXinSubscribeMessageApi extends WeiXinApi {

    /**
     * 订阅消息的发送
     * @param accessToken 调用凭证
     * @param entity 实体信息
     * @return true 发送成功
     */
     public boolean send(String accessToken, SubscribeMessageSendEntity entity){
//      1.构建url
         String url = WeiXinApiConstant.SUBSCRIBE_MESSAGE_SEND_API
                 .replace(WeiXinApiConstant.$_ACCESS_TOKEN, accessToken);
//      2.封装数据
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("touser",entity.getToUser());
         jsonObject.put("template_id",entity.getTemplateId());
         jsonObject.put("page",entity.getPage());
         jsonObject.put("miniprogram_state",entity.getMiniProgramState().state);
         jsonObject.put("lang",entity.getLang().lang);
         jsonObject.put("data",entity.getData());
//      3.请求数据
         String responce = restTemplate.postForObject(url, jsonObject, String.class);
         if(JSONObject.parseObject(responce).getInteger(WeiXinApiConstant.ERR_CODE)!=0){
            throw new SubscribeMessageApiException(responce);
         }
         return true;
     }

}
