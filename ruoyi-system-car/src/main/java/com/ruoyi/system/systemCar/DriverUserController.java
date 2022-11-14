package com.ruoyi.system.systemCar;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 司机用户 Controller  跟系统用户公用一张表sys_user
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system-car/user")
public class DriverUserController extends BaseController
{
    @Autowired
    private ISysUserService userService;

    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user)
    {
        user.setType("3");//获取 司机用户信息
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "导出用户信息", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUser user)
    {
        user.setType("3");
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.exportExcel(response, list, "用户数据");
    }



    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user)
    {
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }






   /* @Autowired
    private IDriverUserService driverUserService;

    *//**
     * 查询司机用户 列表
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(DriverUser driverUser)
    {
        startPage();
        List<DriverUser> list = driverUserService.selectDriverUserList(driverUser);
        return getDataTable(list);
    }

    *//**
     * 导出司机用户 列表
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:export')")
    @Log(title = "司机用户 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DriverUser driverUser)
    {
        List<DriverUser> list = driverUserService.selectDriverUserList(driverUser);
        ExcelUtil<DriverUser> util = new ExcelUtil<DriverUser>(DriverUser.class);
        util.exportExcel(response, list, "司机用户 数据");
    }

    *//**
     * 获取司机用户 详细信息
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(driverUserService.selectDriverUserById(id));
    }

    *//**
     * 新增司机用户
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:add')")
    @Log(title = "司机用户 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DriverUser driverUser)
    {
        return toAjax(driverUserService.insertDriverUser(driverUser));
    }

    *//**
     * 修改司机用户
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:edit')")
    @Log(title = "司机用户 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DriverUser driverUser)
    {
        return toAjax(driverUserService.updateDriverUser(driverUser));
    }

    *//**
     * 删除司机用户
     *//*
    @PreAuthorize("@ss.hasPermi('system-car:user:remove')")
    @Log(title = "司机用户 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(driverUserService.deleteDriverUserByIds(ids));
    }*/
}
