package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 可以卖的车辆信息 对象 car_sell
 * 
 * @author ruoyi
 * @date 2022-11-10
 */
public class CarSell extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 图片信息 */
    @Excel(name = "图片信息")
    private String images;

    /** 车辆颜色 */
    @Excel(name = "车辆颜色")
    private String carColor;

    /** 车辆价格 */
    @Excel(name = "车辆价格")
    private BigDecimal carPrice;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 车辆型号 */
    @Excel(name = "车辆型号")
    private String carModel;

    /** 车辆介绍 */
    @Excel(name = "车辆介绍")
    private String carMemo;

    /** 车辆状态 */
    @Excel(name = "车辆状态")
    private String carStatus;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarNumber(String carNumber) 
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber() 
    {
        return carNumber;
    }
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }
    public void setCarColor(String carColor) 
    {
        this.carColor = carColor;
    }

    public String getCarColor() 
    {
        return carColor;
    }
    public void setCarPrice(BigDecimal carPrice) 
    {
        this.carPrice = carPrice;
    }

    public BigDecimal getCarPrice() 
    {
        return carPrice;
    }
    public void setCarName(String carName) 
    {
        this.carName = carName;
    }

    public String getCarName() 
    {
        return carName;
    }
    public void setCarModel(String carModel) 
    {
        this.carModel = carModel;
    }

    public String getCarModel() 
    {
        return carModel;
    }
    public void setCarMemo(String carMemo) 
    {
        this.carMemo = carMemo;
    }

    public String getCarMemo() 
    {
        return carMemo;
    }
    public void setCarStatus(String carStatus) 
    {
        this.carStatus = carStatus;
    }

    public String getCarStatus() 
    {
        return carStatus;
    }
    public void setIsDel(String isDel) 
    {
        this.isDel = isDel;
    }

    public String getIsDel() 
    {
        return isDel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carNumber", getCarNumber())
            .append("images", getImages())
            .append("carColor", getCarColor())
            .append("carPrice", getCarPrice())
            .append("carName", getCarName())
            .append("carModel", getCarModel())
            .append("carMemo", getCarMemo())
            .append("carStatus", getCarStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
