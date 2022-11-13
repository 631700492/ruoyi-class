package com.ruoyi.wx.exception;

/**
 * @author WDD
 * @desc 图片输入流为空
 * @date 2020/7/1
 */
public class ImageInputStreamIsNullException extends RuntimeException{

    public ImageInputStreamIsNullException(String msg){
        super("图片输入流为空:"+msg);
    }

    public ImageInputStreamIsNullException(){
        this("");
    }

}
