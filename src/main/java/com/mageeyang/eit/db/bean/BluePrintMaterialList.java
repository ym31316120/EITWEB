package com.mageeyang.eit.db.bean;

import com.mageeyang.eit.db.model.IndustryactivitymaterialsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/1/5.
 */
public class BluePrintMaterialList {
    private IndustryactivitymaterialsEntity industryactivitymaterialsEntity;
    private BluePrintInfo bluePrintInfo;
    private BigDecimal sellPrice;
    private BigDecimal buyPrice;

    public BluePrintInfo getBluePrintInfo() {
        return bluePrintInfo;
    }

    public void setBluePrintInfo(BluePrintInfo bluePrintInfo) {
        this.bluePrintInfo = bluePrintInfo;
    }



    public IndustryactivitymaterialsEntity getIndustryactivitymaterialsEntity() {
        return industryactivitymaterialsEntity;
    }

    public void setIndustryactivitymaterialsEntity(IndustryactivitymaterialsEntity industryactivitymaterialsEntity) {
        this.industryactivitymaterialsEntity = industryactivitymaterialsEntity;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}
