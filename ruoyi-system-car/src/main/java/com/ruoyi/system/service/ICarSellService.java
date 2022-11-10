package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CarSell;

/**
 * 可以卖的车辆信息 Service接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface ICarSellService 
{
    /**
     * 查询可以卖的车辆信息 
     * 
     * @param id 可以卖的车辆信息 主键
     * @return 可以卖的车辆信息 
     */
    public CarSell selectCarSellById(Long id);

    /**
     * 查询可以卖的车辆信息 列表
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 可以卖的车辆信息 集合
     */
    public List<CarSell> selectCarSellList(CarSell carSell);

    /**
     * 新增可以卖的车辆信息 
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 结果
     */
    public int insertCarSell(CarSell carSell);

    /**
     * 修改可以卖的车辆信息 
     * 
     * @param carSell 可以卖的车辆信息 
     * @return 结果
     */
    public int updateCarSell(CarSell carSell);

    /**
     * 批量删除可以卖的车辆信息 
     * 
     * @param ids 需要删除的可以卖的车辆信息 主键集合
     * @return 结果
     */
    public int deleteCarSellByIds(Long[] ids);

    /**
     * 删除可以卖的车辆信息 信息
     * 
     * @param id 可以卖的车辆信息 主键
     * @return 结果
     */
    public int deleteCarSellById(Long id);
}
