package com.ruoyi.wx.util;

import com.ruoyi.wx.exception.ImageInputStreamIsNullException;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author TwoKe
 * @desc 图片工具类
 * @date 2020/7/1
 */
public class ImageUtil {

    public static void createImage(InputStream in,String imgFile) throws Exception {
        if(in==null){
            throw new ImageInputStreamIsNullException();
        }
        FileOutputStream out = new FileOutputStream(imgFile);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            out.write(buf, 0, len);
        }
        out.flush();
    }








}
