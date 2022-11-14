package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 可以租借车辆信息 对象 car_rental
 * 
 * @author ruoyi
 * @date 2022-11-14
 */
public class CarRental extends BaseEntity
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

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String luoImages;

    /** 燃油标号 92-95 */
    @Excel(name = "燃油标号 92-95")
    private String fuelOilLabel;

    /** 能源类型 1汽油2耗电 */
    @Excel(name = "能源类型 1汽油2耗电")
    private String sourceType;

    /** 结构/座位 */
    @Excel(name = "结构/座位")
    private String seat;

    /** 车辆类型 1经济型2商务型3suv4豪华型 */
    @Excel(name = "车辆类型 1经济型2商务型3suv4豪华型")
    private String carType;

    /** 车辆颜色 */
    @Excel(name = "车辆颜色")
    private String carColor;

    /** 车辆价格 日均 */
    @Excel(name = "车辆价格 日均")
    private BigDecimal carPrice;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 车辆型号 */
    @Excel(name = "车辆型号")
    private String carModel;

    /** 行驶公里 */
    @Excel(name = "行驶公里")
    private BigDecimal run;

    /** 车辆介绍 */
    @Excel(name = "车辆介绍")
    private String carMemo;

    /** 车辆状态 */
    @Excel(name = "车辆状态")
    private String carStatus;

    /** 租车人id */
    @Excel(name = "租车人id")
    private Long driverUserId;

    /** 租车人名字 */
    @Excel(name = "租车人名字")
    private String driverUserName;

    /** 配置信息 */
    @Excel(name = "配置信息")
    private String configurationMemo;

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
    public void setLuoImages(String luoImages) 
    {
        this.luoImages = luoImages;
    }

    public String getLuoImages() 
    {
        return luoImages;
    }
    public void setFuelOilLabel(String fuelOilLabel) 
    {
        this.fuelOilLabel = fuelOilLabel;
    }

    public String getFuelOilLabel() 
    {
        return fuelOilLabel;
    }
    public void setSourceType(String sourceType) 
    {
        this.sourceType = sourceType;
    }

    public String getSourceType() 
    {
        return sourceType;
    }
    public void setSeat(String seat) 
    {
        this.seat = seat;
    }

    public String getSeat() 
    {
        return seat;
    }
    public void setCarType(String carType) 
    {
        this.carType = carType;
    }

    public String getCarType() 
    {
        return carType;
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
    public void setRun(BigDecimal run) 
    {
        this.run = run;
    }

    public BigDecimal getRun() 
    {
        return run;
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
    public void setDriverUserId(Long driverUserId) 
    {
        this.driverUserId = driverUserId;
    }

    public Long getDriverUserId() 
    {
        return driverUserId;
    }
    public void setDriverUserName(String driverUserName) 
    {
        this.driverUserName = driverUserName;
    }

    public String getDriverUserName() 
    {
        return driverUserName;
    }
    public void setConfigurationMemo(String configurationMemo) 
    {
        this.configurationMemo = configurationMemo;
    }

    public String getConfigurationMemo() 
    {
        return configurationMemo;
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
            .append("luoImages", getLuoImages())
            .append("fuelOilLabel", getFuelOilLabel())
            .append("sourceType", getSourceType())
            .append("seat", getSeat())
            .append("carType", getCarType())
            .append("carColor", getCarColor())
            .append("carPrice", getCarPrice())
            .append("carName", getCarName())
            .append("carModel", getCarModel())
            .append("run", getRun())
            .append("carMemo", getCarMemo())
            .append("carStatus", getCarStatus())
            .append("driverUserId", getDriverUserId())
            .append("driverUserName", getDriverUserName())
            .append("configurationMemo", getConfigurationMemo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
