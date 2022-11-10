package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CarRental;

/**
 * 可以租借车辆信息 Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface CarRentalMapper 
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
     * 删除可以租借车辆信息 
     * 
     * @param id 可以租借车辆信息 主键
     * @return 结果
     */
    public int deleteCarRentalById(Long id);

    /**
     * 批量删除可以租借车辆信息 
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCarRentalByIds(Long[] ids);
}
