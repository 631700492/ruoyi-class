package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CarSellMapper;
import com.ruoyi.system.domain.CarSell;
import com.ruoyi.system.service.ICarSellService;

/**
 * 可以卖的车辆信息 Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class CarSellServiceImpl implements ICarSellService 
{
    @Autowired
    private CarSellMapper carSellMapper;

    /**
     * 查询可以卖的车辆信息 
     * 
     * @param id 可以卖的车辆信息 主键
     * @return 可以卖的车辆信息 
     */
    @Override
    public CarSell selectCarSellById(Long id)
    {
        return carSellMapper.selectCarSellById(id);
    }

    /**
     * 查询可以卖的车辆信息 列表
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 可以卖的车辆信息 
     */
    @Override
    public List<CarSell> selectCarSellList(CarSell carSell)
    {
        return carSellMapper.selectCarSellList(carSell);
    }

    /**
     * 新增可以卖的车辆信息 
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 结果
     */
    @Override
    public int insertCarSell(CarSell carSell)
    {
        carSell.setCreateTime(DateUtils.getNowDate());
        return carSellMapper.insertCarSell(carSell);
    }

    /**
     * 修改可以卖的车辆信息 
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 结果
     */
    @Override
    public int updateCarSell(CarSell carSell)
    {
        carSell.setUpdateTime(DateUtils.getNowDate());
        return carSellMapper.updateCarSell(carSell);
    }

    /**
     * 批量删除可以卖的车辆信息 
     * 
     * @param ids 需要删除的可以卖的车辆信息 主键
     * @return 结果
     */
    @Override
    public int deleteCarSellByIds(Long[] ids)
    {
        return carSellMapper.deleteCarSellByIds(ids);
    }

    /**
     * 删除可以卖的车辆信息 信息
     * 
     * @param id 可以卖的车辆信息 主键
     * @return 结果
     */
    @Override
    public int deleteCarSellById(Long id)
    {
        return carSellMapper.deleteCarSellById(id);
    }
}
