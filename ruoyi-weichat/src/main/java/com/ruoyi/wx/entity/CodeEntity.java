package com.ruoyi.wx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TwoKe
 * @desc 小程序码实体
 * @date 2020/7/1
 */
@Data
@AllArgsConstructor
public class CodeEntity {
    /**
     * 最大32个可见字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~，其它字符请自行编码为合法字符（因不支持%，中文无法使用 urlencode 处理，请使用其他编码方式）
     */
    private String scene;
    /**
     * 扫码进入的小程序页面路径，最大长度 128 字节，不能为空；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}
     */
    private String path;
    /**
     * 必须是已经发布的小程序存在的页面（否则报错），例如 pages/index/index, 根路径前不要填加 /,不能携带参数（参数请放在scene字段里），如果不填写这个字段，默认跳主页面
     */
    private String page;
    /**
     * 二维码的宽度，单位 px，最小 280px，最大 1280px
     */
    private Integer width;
    /**
     * 自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     */
    private Boolean autoColor;
    /**
     * auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示
     */
    private Map<String,String> lineColor;
    /**
     * 是否需要透明底色，为 true 时，生成透明底色的小程序
     */
    private Boolean isHyaLine;

    public CodeEntity(){
        this.page="pages/index/index";
        this.width = 430;
        this.autoColor = false;
        this.isHyaLine = false;
        this.lineColor = new HashMap<>();
        this.lineColor.put("r","0");
        this.lineColor.put("g","0");
        this.lineColor.put("b","0");
    }


}
