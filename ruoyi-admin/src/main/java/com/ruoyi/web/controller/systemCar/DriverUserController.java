package com.ruoyi.web.controller.systemCar;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.DriverUser;
import com.ruoyi.system.service.IDriverUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 司机用户 Controller
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system-car/user")
public class DriverUserController extends BaseController
{
    @Autowired
    private IDriverUserService driverUserService;

    /**
     * 查询司机用户 列表
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(DriverUser driverUser)
    {
        startPage();
        List<DriverUser> list = driverUserService.selectDriverUserList(driverUser);
        return getDataTable(list);
    }

    /**
     * 导出司机用户 列表
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:export')")
    @Log(title = "司机用户 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DriverUser driverUser)
    {
        List<DriverUser> list = driverUserService.selectDriverUserList(driverUser);
        ExcelUtil<DriverUser> util = new ExcelUtil<DriverUser>(DriverUser.class);
        util.exportExcel(response, list, "司机用户 数据");
    }

    /**
     * 获取司机用户 详细信息
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(driverUserService.selectDriverUserById(id));
    }

    /**
     * 新增司机用户
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:add')")
    @Log(title = "司机用户 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DriverUser driverUser)
    {
        return toAjax(driverUserService.insertDriverUser(driverUser));
    }

    /**
     * 修改司机用户
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:edit')")
    @Log(title = "司机用户 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DriverUser driverUser)
    {
        return toAjax(driverUserService.updateDriverUser(driverUser));
    }

    /**
     * 删除司机用户
     */
    @PreAuthorize("@ss.hasPermi('system-car:user:remove')")
    @Log(title = "司机用户 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(driverUserService.deleteDriverUserByIds(ids));
    }
}
