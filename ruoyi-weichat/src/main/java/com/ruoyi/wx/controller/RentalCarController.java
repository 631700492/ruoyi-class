package com.ruoyi.wx.controller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.CarRental;
import com.ruoyi.system.service.ICarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weixin/")
public class RentalCarController extends BaseController {

    @Autowired
    private ICarRentalService carRentalService;

    /**
     * 查询可以租借车辆信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system:rental:list')")
    @GetMapping("/centalCarList")
    public TableDataInfo list(CarRental carRental)
    {
        //分页
        PageHelper.startPage(carRental.getPageNum(), carRental.getPageSize(), carRental.getOrderBy()).setReasonable(true);
        List<CarRental> list = carRentalService.selectCarRentalList(carRental);
        return getDataTable(list);
    }
}
