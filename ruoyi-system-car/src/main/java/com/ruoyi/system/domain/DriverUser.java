package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 司机用户 对象 driver_user
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Data
public class DriverUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String address;

    /** 驾龄 */
    @Excel(name = "驾龄")
    private BigDecimal carAge;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDel;

    /** 用户微信openid */
    @Excel(name = "用户微信openid")
    private String openid;


}
