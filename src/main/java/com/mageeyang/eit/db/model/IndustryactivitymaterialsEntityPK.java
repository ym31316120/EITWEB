package com.mageeyang.eit.db.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/5.
 */
public class IndustryactivitymaterialsEntityPK implements Serializable {
    private Integer typeId;
    private Integer activityId;
    private Integer materialTypeId;

    @Column(name = "typeID", nullable = false, insertable = true, updatable = true)
    @Id
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Column(name = "activityID", nullable = false, insertable = true, updatable = true)
    @Id
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Column(name = "materialTypeID", nullable = false, insertable = true, updatable = true)
    @Id
    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryactivitymaterialsEntityPK that = (IndustryactivitymaterialsEntityPK) o;

        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (materialTypeId != null ? !materialTypeId.equals(that.materialTypeId) : that.materialTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (materialTypeId != null ? materialTypeId.hashCode() : 0);
        return result;
    }
}
