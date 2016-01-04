package com.mageeyang.eit.db.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/1/2.
 */
@Entity
@Table(name = "invmarketgroups", schema = "", catalog = "eve_original")
public class InvmarketgroupsEntity {
    private int marketGroupId;
    private Integer parentGroupId;
    private String marketGroupName;
    private String description;
    private Integer iconId;
    private Byte hasTypes;

    @Id
    @Column(name = "marketGroupID", nullable = false, insertable = true, updatable = true)
    public int getMarketGroupId() {
        return marketGroupId;
    }

    public void setMarketGroupId(int marketGroupId) {
        this.marketGroupId = marketGroupId;
    }

    @Basic
    @Column(name = "parentGroupID", nullable = true, insertable = true, updatable = true)
    public Integer getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(Integer parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    @Basic
    @Column(name = "marketGroupName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "iconID", nullable = true, insertable = true, updatable = true)
    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    @Basic
    @Column(name = "hasTypes", nullable = true, insertable = true, updatable = true)
    public Byte getHasTypes() {
        return hasTypes;
    }

    public void setHasTypes(Byte hasTypes) {
        this.hasTypes = hasTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvmarketgroupsEntity that = (InvmarketgroupsEntity) o;

        if (marketGroupId != that.marketGroupId) return false;
        if (parentGroupId != null ? !parentGroupId.equals(that.parentGroupId) : that.parentGroupId != null)
            return false;
        if (marketGroupName != null ? !marketGroupName.equals(that.marketGroupName) : that.marketGroupName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (iconId != null ? !iconId.equals(that.iconId) : that.iconId != null) return false;
        if (hasTypes != null ? !hasTypes.equals(that.hasTypes) : that.hasTypes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = marketGroupId;
        result = 31 * result + (parentGroupId != null ? parentGroupId.hashCode() : 0);
        result = 31 * result + (marketGroupName != null ? marketGroupName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (iconId != null ? iconId.hashCode() : 0);
        result = 31 * result + (hasTypes != null ? hasTypes.hashCode() : 0);
        return result;
    }
}
