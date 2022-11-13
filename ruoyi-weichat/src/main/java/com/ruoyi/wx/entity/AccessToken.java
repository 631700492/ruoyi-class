package com.ruoyi.wx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TwoKe
 * @desc 接口调用凭证
 * @date 2020/6/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {

    /**
     * 接口调用凭证
     */
    private String accessToken;
    /**
     * 保存过期时间
     */
    private long expiresTime;
}
