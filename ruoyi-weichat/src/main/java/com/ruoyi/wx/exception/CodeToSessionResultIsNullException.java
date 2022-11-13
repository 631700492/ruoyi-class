package com.ruoyi.wx.exception;

/**
 * @author TwoKe
 * @desc 登录凭证异常
 * @date 2020/7/1
 */
public class CodeToSessionResultIsNullException extends RuntimeException{

    public CodeToSessionResultIsNullException(String msg){
        super("登录凭证校验,返回的结果异常:"+msg);
    }

}
