package com.ruoyi.wx.entity;

import com.ruoyi.wx.enums.LangEnum;
import com.ruoyi.wx.enums.MiniProgramStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @author TwoKe
 * @desc 订阅消息发送实体
 * @date 2020/7/1
 */
@Data
@AllArgsConstructor
public class SubscribeMessageSendEntity {

    /**
     * 接收者(用户)的openid
     */
    private String toUser;
    /**
     * 所需下发的订阅模板id
     */
    private String templateId;
    /**
     * 点击模板卡片后跳转的页面支持带参数，该字段不填，则模板无法跳转
     */
    private String page;
    /**
     * 模板内容
     */
    private Map<String,Value> data;
    /**
     * 跳转小程序类型:
     * developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    private MiniProgramStateEnum miniProgramState;

    /**
     * 语言类型
     */
    private LangEnum lang;

    public SubscribeMessageSendEntity(){
        miniProgramState = MiniProgramStateEnum.FORMAL;
        lang = LangEnum.ZH_CN;
    }

    @Data
    @AllArgsConstructor
    public static class Value{
        private Object value;
    }

}
