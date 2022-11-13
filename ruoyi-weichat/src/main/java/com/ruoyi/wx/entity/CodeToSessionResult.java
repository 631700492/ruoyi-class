package com.ruoyi.wx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TwoKe
 * @desc TODO
 * @date 2020/7/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeToSessionResult {

    /**
     * 	用户唯一标识
     */
    private String openid;
    /**
     * 会话密钥
     */
    private String sessionKey;
    /**
     * 用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
     */
    private String unionId;


}
