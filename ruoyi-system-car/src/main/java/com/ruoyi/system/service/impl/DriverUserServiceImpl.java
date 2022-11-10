package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DriverUserMapper;
import com.ruoyi.system.domain.DriverUser;
import com.ruoyi.system.service.IDriverUserService;

/**
 * 司机用户 Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
@Service
public class DriverUserServiceImpl implements IDriverUserService 
{
    @Autowired
    private DriverUserMapper driverUserMapper;

    /**
     * 查询司机用户 
     * 
     * @param id 司机用户 主键
     * @return 司机用户 
     */
    @Override
    public DriverUser selectDriverUserById(Long id)
    {
        return driverUserMapper.selectDriverUserById(id);
    }

    /**
     * 查询司机用户 列表
     * 
     * @param driverUser 司机用户 
     * @return 司机用户 
     */
    @Override
    public List<DriverUser> selectDriverUserList(DriverUser driverUser)
    {
        return driverUserMapper.selectDriverUserList(driverUser);
    }

    /**
     * 新增司机用户 
     * 
     * @param driverUser 司机用户 
     * @return 结果
     */
    @Override
    public int insertDriverUser(DriverUser driverUser)
    {
        driverUser.setCreateTime(DateUtils.getNowDate());
        return driverUserMapper.insertDriverUser(driverUser);
    }

    /**
     * 修改司机用户 
     * 
     * @param driverUser 司机用户 
     * @return 结果
     */
    @Override
    public int updateDriverUser(DriverUser driverUser)
    {
        driverUser.setUpdateTime(DateUtils.getNowDate());
        return driverUserMapper.updateDriverUser(driverUser);
    }

    /**
     * 批量删除司机用户 
     * 
     * @param ids 需要删除的司机用户 主键
     * @return 结果
     */
    @Override
    public int deleteDriverUserByIds(Long[] ids)
    {
        return driverUserMapper.deleteDriverUserByIds(ids);
    }

    /**
     * 删除司机用户 信息
     * 
     * @param id 司机用户 主键
     * @return 结果
     */
    @Override
    public int deleteDriverUserById(Long id)
    {
        return driverUserMapper.deleteDriverUserById(id);
    }
}
