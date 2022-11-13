package com.ruoyi.wx.exception;

/**
 * @author WDD
 * @desc TODO
 * @date 2020/7/1
 */
public class SubscribeMessageApiException extends RuntimeException{

    public SubscribeMessageApiException(String msg){
        super("订阅消息发送失败!:"+msg);
    }


}
