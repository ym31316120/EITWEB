package com.mageeyang.eit.db.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/5.
 */
public class IndustryactivityEntityPK implements Serializable {
    private int typeId;
    private int activityId;

    @Column(name = "typeID", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Column(name = "activityID", nullable = false, insertable = true, updatable = true)
    @Id
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryactivityEntityPK that = (IndustryactivityEntityPK) o;

        if (typeId != that.typeId) return false;
        if (activityId != that.activityId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + activityId;
        return result;
    }
}
