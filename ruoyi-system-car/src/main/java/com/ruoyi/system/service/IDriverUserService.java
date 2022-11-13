package com.ruoyi.system.service;

import com.ruoyi.system.domain.DriverUser;

import java.util.List;

/**
 * 司机用户 Service接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface IDriverUserService 
{
    /**
     * 查询司机用户 
     * 
     * @param id 司机用户 主键
     * @return 司机用户 
     */
    public DriverUser selectDriverUserById(Long id);

    /**
     * 根据openid  获取用户
     * @param openid
     * @return
     */
    public DriverUser selectDriverUserByOpenid(String openid);

    /**
     * 查询司机用户 列表
     * 
     * @param driverUser 司机用户 
     * @return 司机用户 集合
     */
    public List<DriverUser> selectDriverUserList(DriverUser driverUser);

    /**
     * 新增司机用户 
     * 
     * @param driverUser 司机用户 
     * @return 结果
     */
    public int insertDriverUser(DriverUser driverUser);

    /**
     * 修改司机用户 
     * 
     * @param driverUser 司机用户 
     * @return 结果
     */
    public int updateDriverUser(DriverUser driverUser);

    /**
     * 批量删除司机用户 
     * 
     * @param ids 需要删除的司机用户 主键集合
     * @return 结果
     */
    public int deleteDriverUserByIds(Long[] ids);

    /**
     * 删除司机用户 信息
     * 
     * @param id 司机用户 主键
     * @return 结果
     */
    public int deleteDriverUserById(Long id);
}
