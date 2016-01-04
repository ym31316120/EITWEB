package com.mageeyang.eit.db.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/1/4.
 */
@Entity
@Table(name = "industryactivitymaterials", schema = "", catalog = "eve_original")
public class IndustryactivitymaterialsEntity {
    private Integer typeId;
    private Integer activityId;
    private Integer materialTypeId;
    private Integer quantity;

    @Id
    @Column(name = "typeID", nullable = true, insertable = true, updatable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Id
    @Column(name = "activityID", nullable = true, insertable = true, updatable = true)
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Id
    @Column(name = "materialTypeID", nullable = true, insertable = true, updatable = true)
    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    @Basic
    @Column(name = "quantity", nullable = true, insertable = true, updatable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryactivitymaterialsEntity that = (IndustryactivitymaterialsEntity) o;

        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (materialTypeId != null ? !materialTypeId.equals(that.materialTypeId) : that.materialTypeId != null)
            return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (materialTypeId != null ? materialTypeId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
