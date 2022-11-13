package com.ruoyi.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.wx.constant.WeiXinApiConstant;
import com.ruoyi.wx.entity.CodeEntity;
import com.ruoyi.wx.entity.SubscribeMessageSendEntity;
import com.ruoyi.wx.service.WeiXinAuthApi;
import com.ruoyi.wx.service.WeiXinCodeApi;
import com.ruoyi.wx.service.WeiXinSubscribeMessageApi;
import com.ruoyi.wx.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WDD
 * @desc 临时的控制器
 * @date 2020/6/30
 */
@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @Autowired
    private WeiXinAuthApi authApi;


    @RequestMapping("/getOpenid")
    public Map getOpenid(@RequestBody JSONObject json){
        Map<String, Object> map = new HashMap<>();

        String openid = authApi.code2Session(json.getString("code")).getOpenid();

        if(openid == null){
            openid = "request:error";
        }

        map.put(WeiXinApiConstant.OPENID,openid);
        return map;
    }


    @RequestMapping("/getAccessToken")
    public Map getAccessToken(){
        Map<String, Object> map = new HashMap<>();

        String json = authApi.getAccessToken();

        map.put(WeiXinApiConstant.ACCESS_TOKEN,json);
        return map;
    }


    @Autowired
    private WeiXinSubscribeMessageApi smApi;

    @RequestMapping("/send")
    public Map send(){
        Map<String, Object> map = new HashMap<>();
        SubscribeMessageSendEntity entity = new SubscribeMessageSendEntity();
        entity.setToUser("oKlKg4oNhEQpf_z_Ket_kgA4Dg_M");
        entity.setPage("/pages/index/index");
        entity.setTemplateId("ozhRjBP21DnOAW1pGRjC2oNkSQq1xd4lQhBIwQSdUSo");
        Map<String, SubscribeMessageSendEntity.Value> data = new HashMap<>();
        data.put("time1",new SubscribeMessageSendEntity.Value(new SimpleDateFormat("yyyy年MM月dd年 HH:mm:ss").format(new Date())));
        data.put("thing2",new SubscribeMessageSendEntity.Value("报修信息已受理"));
        entity.setData(data);
        String accessToken = authApi.getAccessToken();
        boolean flag = smApi.send(accessToken, entity);
        return map ;
    }


    @Autowired
    private WeiXinCodeApi codeApi;


    @RequestMapping("/getUnlimited")
    public String getUnlimited() throws Exception {
        String accessToken = authApi.getAccessToken();

        CodeEntity entity = new CodeEntity();

        entity.setScene("a=5");

        InputStream in = codeApi.getUnlimited(accessToken, entity);

        ImageUtil.createImage(in,System.getProperty("user.dir")+"/src/main/resources/static/getUnlimited.jpg");
        return "获取小程序码，适用于需要的码数量极多的业务场景。" ;
    }

    @RequestMapping("/createQRCode")
    public String createQRCode() throws Exception {
        String accessToken = authApi.getAccessToken();

        CodeEntity entity = new CodeEntity();

        entity.setPath("pages/index/index");

        InputStream in = codeApi.createQRCode(accessToken, entity);

        ImageUtil.createImage(in,System.getProperty("user.dir")+"/src/main/resources/static/createQRCode.jpg");
        return "获取小程序二维码，适用于需要的码数量较少的业务场景。" ;
    }


    @RequestMapping("/get")
    public String get() throws Exception {
        String accessToken = authApi.getAccessToken();

        CodeEntity entity = new CodeEntity();

        entity.setPath("pages/index/index");

        InputStream in = codeApi.get(accessToken, entity);

        ImageUtil.createImage(in,System.getProperty("user.dir")+"/src/main/resources/static/get.jpg");
        return "获取小程序码，适用于需要的码数量较少的业务场景。" ;
    }



}
