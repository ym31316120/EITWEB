package com.mageeyang.eit.db.bean;

import com.mageeyang.eit.db.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public class BluePrintInfo {
    private InvtypesEntity blueprint;  //蓝图信息
    private List<BluePrintMaterialList> productMaterials; //蓝图原材料
    private List<IndustryactivitymaterialsEntity> inventMaterial; //发明该蓝图的原材料
    private InvtypesEntity productinfo; //蓝图产物基本信息

    private Integer industryTime;  //蓝图制造的时间

    private BigDecimal inventProbablity; //发明该蓝图的成功率

    private int line_num; //发明出该蓝图的流程数

    private int product_num;//生产该蓝图的产物数量

    private double Mt;  //蓝图的材料研究效率

    public InvtypesEntity getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(InvtypesEntity blueprint) {
        this.blueprint = blueprint;
    }

    public List<BluePrintMaterialList> getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(List<BluePrintMaterialList> productMaterials) {
        this.productMaterials = productMaterials;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public List<IndustryactivitymaterialsEntity> getInventMaterial() {
        return inventMaterial;
    }

    public void setInventMaterial(List<IndustryactivitymaterialsEntity> inventMaterial) {
        this.inventMaterial = inventMaterial;
    }

    public BigDecimal getInventProbablity() {
        return inventProbablity;
    }

    public void setInventProbablity(BigDecimal inventProbablity) {
        this.inventProbablity = inventProbablity;
    }

    public Integer getIndustryTime() {
        return industryTime;
    }

    public void setIndustryTime(Integer industryTime) {
        this.industryTime = industryTime;
    }

    public InvtypesEntity getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(InvtypesEntity productinfo) {
        this.productinfo = productinfo;
    }

    public double getMt() {
        return Mt;
    }

    public void setMt(double mt) {
        Mt = mt;
    }

    public int getLine_num() {
        return line_num;
    }

    public void setLine_num(int line_num) {
        this.line_num = line_num;
    }
}
