package com.ruoyi.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.wx.service.WeiXinAuthApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
public class WeiChatLoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private WeiXinAuthApi authApi;
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody JSONObject json)
    {
        //获取用户的openId--->去数据库查找是否有对应的用户信息
        String openid = authApi.code2Session(json.getString("code")).getOpenid();
        if(openid == null){
            return AjaxResult.error("获取用户信息失败！");
        }

        SysUser user= sysUserService.selectUserByOpenid(openid);
        if(user == null){
            return AjaxResult.error("该用户尚未注册过！").put("openid",openid);
        }

        //LoginBody loginBody = new LoginBody();
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(user.getUserName(), user.getPwd(), "nono",
                "");
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    @PostMapping("/register")
    public AjaxResult login(@RequestBody SysUser user)
    {
        if(user ==null ){
            return new AjaxResult().error("用户信息为空！");
        }
        if(user.getOpenid() ==null ){
            return new AjaxResult().error("用户信息不完整！");
        }
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        user.setPwd("123456");
        user.setStatus("0");
        user.setUserName(user.getPhonenumber());
        sysUserService.insertUser(user);
        return new AjaxResult().success();
    }
}
