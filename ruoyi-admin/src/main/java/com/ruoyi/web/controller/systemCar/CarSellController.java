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
import com.ruoyi.system.domain.CarSell;
import com.ruoyi.system.service.ICarSellService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 可以卖的车辆信息 Controller
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@RestController
@RequestMapping("/system-car/sell")
public class CarSellController extends BaseController
{
    @Autowired
    private ICarSellService carSellService;

    /**
     * 查询可以卖的车辆信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system-car:sell:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarSell carSell)
    {
        startPage();
        List<CarSell> list = carSellService.selectCarSellList(carSell);
        return getDataTable(list);
    }

    /**
     * 导出可以卖的车辆信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system-car:sell:export')")
    @Log(title = "可以卖的车辆信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarSell carSell)
    {
        List<CarSell> list = carSellService.selectCarSellList(carSell);
        ExcelUtil<CarSell> util = new ExcelUtil<CarSell>(CarSell.class);
        util.exportExcel(response, list, "可以卖的车辆信息 数据");
    }

    /**
     * 获取可以卖的车辆信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('system-car:sell:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carSellService.selectCarSellById(id));
    }

    /**
     * 新增可以卖的车辆信息
     */
    @PreAuthorize("@ss.hasPermi('system-car:sell:add')")
    @Log(title = "可以卖的车辆信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarSell carSell)
    {
        return toAjax(carSellService.insertCarSell(carSell));
    }

    /**
     * 修改可以卖的车辆信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:edit')")
    @Log(title = "可以卖的车辆信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarSell carSell)
    {
        return toAjax(carSellService.updateCarSell(carSell));
    }

    /**
     * 删除可以卖的车辆信息
     */
    @PreAuthorize("@ss.hasPermi('system:sell:remove')")
    @Log(title = "可以卖的车辆信息 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carSellService.deleteCarSellByIds(ids));
    }
}
