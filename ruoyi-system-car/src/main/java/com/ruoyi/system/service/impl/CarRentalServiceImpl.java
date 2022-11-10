package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CarRentalMapper;
import com.ruoyi.system.domain.CarRental;
import com.ruoyi.system.service.ICarRentalService;

/**
 * 可以租借车辆信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class CarRentalServiceImpl implements ICarRentalService 
{
    @Autowired
    private CarRentalMapper carRentalMapper;

    /**
     * 查询可以租借车辆信息 
     * 
     * @param id 可以租借车辆信息 主键
     * @return 可以租借车辆信息 
     */
    @Override
    public CarRental selectCarRentalById(Long id)
    {
        return carRentalMapper.selectCarRentalById(id);
    }

    /**
     * 查询可以租借车辆信息 列表
     * 
     * @param carRental 可以租借车辆信息 
     * @return 可以租借车辆信息 
     */
    @Override
    public List<CarRental> selectCarRentalList(CarRental carRental)
    {
        return carRentalMapper.selectCarRentalList(carRental);
    }

    /**
     * 新增可以租借车辆信息 
     * 
     * @param carRental 可以租借车辆信息 
     * @return 结果
     */
    @Override
    public int insertCarRental(CarRental carRental)
    {
        carRental.setCreateTime(DateUtils.getNowDate());
        return carRentalMapper.insertCarRental(carRental);
    }

    /**
     * 修改可以租借车辆信息 
     * 
     * @param carRental 可以租借车辆信息 
     * @return 结果
     */
    @Override
    public int updateCarRental(CarRental carRental)
    {
        carRental.setUpdateTime(DateUtils.getNowDate());
        return carRentalMapper.updateCarRental(carRental);
    }

    /**
     * 批量删除可以租借车辆信息 
     * 
     * @param ids 需要删除的可以租借车辆信息 主键
     * @return 结果
     */
    @Override
    public int deleteCarRentalByIds(Long[] ids)
    {
        return carRentalMapper.deleteCarRentalByIds(ids);
    }

    /**
     * 删除可以租借车辆信息 信息
     * 
     * @param id 可以租借车辆信息 主键
     * @return 结果
     */
    @Override
    public int deleteCarRentalById(Long id)
    {
        return carRentalMapper.deleteCarRentalById(id);
    }
}
