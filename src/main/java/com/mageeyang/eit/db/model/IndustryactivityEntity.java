package com.mageeyang.eit.db.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/1/5.
 */
@Entity
@Table(name = "industryactivity", schema = "", catalog = "eve")
@IdClass(IndustryactivityEntityPK.class)
public class IndustryactivityEntity {
    private int typeId;
    private int activityId;
    private Integer time;

    @Id
    @Column(name = "typeID", nullable = false, insertable = true, updatable = true)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Id
    @Column(name = "activityID", nullable = false, insertable = true, updatable = true)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "time", nullable = true, insertable = true, updatable = true)
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryactivityEntity that = (IndustryactivityEntity) o;

        if (typeId != that.typeId) return false;
        if (activityId != that.activityId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + activityId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
