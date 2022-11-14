package com.ruoyi.web.controller.systemCar;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CarRental;
import com.ruoyi.system.service.ICarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 可以租借车辆信息 Controller
 * 
 * @author ruoyi
 * @date 2022-11-14
 */
@RestController
@RequestMapping("/system-car/rental")
public class CarRentalController extends BaseController
{
    @Autowired
    private ICarRentalService carRentalService;

    /**
     * 查询可以租借车辆信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system:rental:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarRental carRental)
    {
        startPage();
        List<CarRental> list = carRentalService.selectCarRentalList(carRental);
        return getDataTable(list);
    }

    /**
     * 导出可以租借车辆信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system:rental:export')")
    @Log(title = "可以租借车辆信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CarRental carRental)
    {
        List<CarRental> list = carRentalService.selectCarRentalList(carRental);
        ExcelUtil<CarRental> util = new ExcelUtil<CarRental>(CarRental.class);
        util.exportExcel(response, list, "可以租借车辆信息 数据");
    }

    /**
     * 获取可以租借车辆信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:rental:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(carRentalService.selectCarRentalById(id));
    }

    /**
     * 新增可以租借车辆信息 
     */
    @PreAuthorize("@ss.hasPermi('system:rental:add')")
    @Log(title = "可以租借车辆信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarRental carRental)
    {
        return toAjax(carRentalService.insertCarRental(carRental));
    }

    /**
     * 修改可以租借车辆信息 
     */
    @PreAuthorize("@ss.hasPermi('system:rental:edit')")
    @Log(title = "可以租借车辆信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarRental carRental)
    {
        return toAjax(carRentalService.updateCarRental(carRental));
    }

    /**
     * 删除可以租借车辆信息 
     */
    @PreAuthorize("@ss.hasPermi('system:rental:remove')")
    @Log(title = "可以租借车辆信息 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carRentalService.deleteCarRentalByIds(ids));
    }
}
