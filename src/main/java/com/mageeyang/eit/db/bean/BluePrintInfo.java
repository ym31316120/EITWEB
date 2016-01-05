package com.mageeyang.eit.db.bean;

import com.mageeyang.eit.db.model.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/5.
 */
public class BluePrintInfo {
    private InvtypesEntity blueprint;
    private ArrayList<BluePrintMaterialList> productMaterials;
    private IndustryactivityproductsEntity productEntity;
    private IndustryactivityproductsEntity inventEntity;
    private ArrayList<IndustryactivitymaterialsEntity> inventMaterial;
    private IndustryactivityprobabilitiesEntity inventProbablity;
    private IndustryactivityEntity industryactivityEntity;
    private InvtypesEntity productinfo;

    private double Mt;

    public InvtypesEntity getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(InvtypesEntity blueprint) {
        this.blueprint = blueprint;
    }

    public ArrayList<BluePrintMaterialList> getProductMaterials() {
        return productMaterials;
    }

    public void setProductMaterials(ArrayList<BluePrintMaterialList> productMaterials) {
        this.productMaterials = productMaterials;
    }

    public IndustryactivityproductsEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(IndustryactivityproductsEntity productEntity) {
        this.productEntity = productEntity;
    }

    public IndustryactivityproductsEntity getInventEntity() {
        return inventEntity;
    }

    public void setInventEntity(IndustryactivityproductsEntity inventEntity) {
        this.inventEntity = inventEntity;
    }

    public ArrayList<IndustryactivitymaterialsEntity> getInventMaterial() {
        return inventMaterial;
    }

    public void setInventMaterial(ArrayList<IndustryactivitymaterialsEntity> inventMaterial) {
        this.inventMaterial = inventMaterial;
    }

    public IndustryactivityprobabilitiesEntity getInventProbablity() {
        return inventProbablity;
    }

    public void setInventProbablity(IndustryactivityprobabilitiesEntity inventProbablity) {
        this.inventProbablity = inventProbablity;
    }

    public IndustryactivityEntity getIndustryactivityEntity() {
        return industryactivityEntity;
    }

    public void setIndustryactivityEntity(IndustryactivityEntity industryactivityEntity) {
        this.industryactivityEntity = industryactivityEntity;
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
}
