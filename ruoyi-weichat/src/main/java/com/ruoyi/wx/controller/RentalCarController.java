package com.ruoyi.wx.controller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.CarRental;
import com.ruoyi.system.service.ICarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weixin")
public class RentalCarController extends BaseController {

    @Autowired
    private ICarRentalService carRentalService;

    /**
     * 查询可以租借车辆信息 列表
     */
   //PreAuthorize("@ss.hasPermi('system:rental:list')")
    @GetMapping("/centalCarList")
    public AjaxResult list( CarRental carRental)
    {
        //分页
        PageHelper.startPage(carRental.getPageNum(), carRental.getPageSize(), carRental.getOrderBy()).setReasonable(true);
        List<CarRental> list = carRentalService.selectCarRentalList(carRental);
        return  AjaxResult.success(getDataTable(list));
    }

    @RequestMapping("/getLunBoImage")
    public AjaxResult getLunBoImage()
    {
        //分页
        CarRental carRental = new CarRental();
        carRental.setHostImage("1");//1 是轮播图
        carRental.setIsDel("0"); //不删除
        List<CarRental> list = carRentalService.selectCarRentalList(carRental);
        return AjaxResult.success(list);
    }
}
