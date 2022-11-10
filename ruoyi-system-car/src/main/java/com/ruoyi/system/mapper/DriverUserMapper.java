package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DriverUser;

/**
 * 司机用户 Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public interface DriverUserMapper 
{
    /**
     * 查询司机用户 
     * 
     * @param id 司机用户 主键
     * @return 司机用户 
     */
    public DriverUser selectDriverUserById(Long id);

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
     * 删除司机用户 
     * 
     * @param id 司机用户 主键
     * @return 结果
     */
    public int deleteDriverUserById(Long id);

    /**
     * 批量删除司机用户 
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDriverUserByIds(Long[] ids);
}
