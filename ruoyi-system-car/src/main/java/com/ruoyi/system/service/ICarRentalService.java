package com.ruoyi.system.service;

import com.ruoyi.system.domain.CarRental;

import java.util.List;

/**
 * 可以租借车辆信息 Service接口
 * 
 * @author ruoyi
 * @date 2022-11-14
 */
public interface ICarRentalService 
{
    /**
     * 查询可以租借车辆信息 
     * 
     * @param id 可以租借车辆信息 主键
     * @return 可以租借车辆信息 
     */
    public CarRental selectCarRentalById(Long id);

    /**
     * 查询可以租借车辆信息 列表
     * 
     * @param carRental 可以租借车辆信息 
     * @return 可以租借车辆信息 集合
     */
    public List<CarRental> selectCarRentalList(CarRental carRental);

    /**
     * 新增可以租借车辆信息 
     * 
     * @param carRental 可以租借车辆信息 
     * @return 结果
     */
    public int insertCarRental(CarRental carRental);

    /**
     * 修改可以租借车辆信息 
     * 
     * @param carRental 可以租借车辆信息 
     * @return 结果
     */
    public int updateCarRental(CarRental carRental);

    /**
     * 批量删除可以租借车辆信息 
     * 
     * @param ids 需要删除的可以租借车辆信息 主键集合
     * @return 结果
     */
    public int deleteCarRentalByIds(Long[] ids);

    /**
     * 删除可以租借车辆信息 信息
     * 
     * @param id 可以租借车辆信息 主键
     * @return 结果
     */
    public int deleteCarRentalById(Long id);
}
