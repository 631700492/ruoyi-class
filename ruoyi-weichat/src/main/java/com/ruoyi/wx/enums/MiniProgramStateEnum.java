package com.ruoyi.wx.enums;

/**
 * 跳转小程序类型
 * @author Twoke
 */
public enum MiniProgramStateEnum {
    /**
     * 开发板
     */
    DEVELOPER("developer"),
    /**
     * 体验版
     */
    TRIAL("trial"),
    /**
     * 正式版
     */
    FORMAL("formal");

    public String state;

    MiniProgramStateEnum(String state){
        this.state = state;
    }

}
