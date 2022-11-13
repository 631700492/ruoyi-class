package com.ruoyi.wx.enums;

/**
 * @author TwoKe
 * @desc 语言类型
 * @date 2020/7/1
 */
public enum LangEnum {
    /**
     * 简体中文
     */
    ZH_CN("zh_CN"),
    /**
     * 英文
     */
    EN_US("en_US"),
    /**
     * 繁体中文
     */
    ZH_HK("zh_HK"),
    /**
     * 繁体中文
     */
    ZH_TW("zh_TW");

    public String lang;

    LangEnum(String lang){
        this.lang = lang;
    }




}
