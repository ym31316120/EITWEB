package com.mageeyang.eit.db.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/1/5.
 */
@Entity
@Table(name = "industryactivityprobabilities", schema = "", catalog = "eve")
@IdClass(IndustryactivityprobabilitiesEntityPK.class)
public class IndustryactivityprobabilitiesEntity {
    private Integer typeId;
    private Integer activityId;
    private Integer productTypeId;
    private BigDecimal probability;

    @Id
    @Column(name = "typeID", nullable = false, insertable = true, updatable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Id
    @Column(name = "activityID", nullable = false, insertable = true, updatable = true)
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Id
    @Column(name = "productTypeID", nullable = false, insertable = true, updatable = true)
    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "probability", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getProbability() {
        return probability;
    }

    public void setProbability(BigDecimal probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndustryactivityprobabilitiesEntity that = (IndustryactivityprobabilitiesEntity) o;

        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;
        if (probability != null ? !probability.equals(that.probability) : that.probability != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (activityId != null ? activityId.hashCode() : 0);
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (probability != null ? probability.hashCode() : 0);
        return result;
    }
}
