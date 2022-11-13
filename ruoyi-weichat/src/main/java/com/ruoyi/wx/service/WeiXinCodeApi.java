package com.ruoyi.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.wx.constant.WeiXinApiConstant;
import com.ruoyi.wx.entity.CodeEntity;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TwoKe
 * @desc 小程序码API
 * @date 2020/7/1
 */
@Component("wxaCode")
public class WeiXinCodeApi extends WeiXinApi {


    public InputStream createQRCode(String accessToken, CodeEntity entity){
        //1.构建url
        String url = WeiXinApiConstant.WXA_CODE_CREATE_QR_CODE
                .replace(WeiXinApiConstant.$_ACCESS_TOKEN, accessToken);
        //2.封装参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path",entity.getPath());
        jsonObject.put("width",entity.getWidth());
        //3.获取小程序码的二进制结果
        byte[] bytes  = restTemplate.postForObject(url, jsonObject, byte[].class);
        //4.返回结果
        return new ByteArrayInputStream(bytes);
    }

    public InputStream get(String accessToken, CodeEntity entity){
        //1.构建url
        String url = WeiXinApiConstant.WXA_CODE_GET
                .replace(WeiXinApiConstant.$_ACCESS_TOKEN, accessToken);
        //2.封装参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path",entity.getPath());
        jsonObject.put("width",entity.getWidth());
        jsonObject.put("auto_color",entity.getAutoColor());
        jsonObject.put("line_color",entity.getLineColor());
        jsonObject.put("is_hyaline",entity.getIsHyaLine());
        //3.获取小程序码的二进制结果
        byte[] bytes  = restTemplate.postForObject(url, jsonObject, byte[].class);
        //4.返回结果
        return new ByteArrayInputStream(bytes);
    }



    /**
     * 获取小程序码，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制。
     * @param accessToken 调用凭证
     * @param entity 实体信息
     * @return  小程序码的流信息
     * @throws IOException
     */
    public InputStream getUnlimited(String accessToken, CodeEntity entity) {
        //1.构建url
        String url = WeiXinApiConstant.WXA_CODE_GET_UNLIMITED
                .replace(WeiXinApiConstant.$_ACCESS_TOKEN, accessToken);
        //2.封装参数
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("scene",entity.getScene());
        jsonObject.put("page",entity.getPage());
        jsonObject.put("width",entity.getWidth());
        jsonObject.put("auto_color",entity.getAutoColor());
        jsonObject.put("line_color",entity.getLineColor());
        jsonObject.put("is_hyaline",entity.getIsHyaLine());
        //3.获取小程序码的二进制结果
        byte[] bytes  = restTemplate.postForObject(url, jsonObject, byte[].class);
        //4.返回结果
        return new ByteArrayInputStream(bytes);
    }

}
