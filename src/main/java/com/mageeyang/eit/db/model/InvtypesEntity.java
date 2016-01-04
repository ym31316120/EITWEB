package com.mageeyang.eit.db.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/1/4.
 */
@Entity
@Table(name = "invtypes", schema = "", catalog = "eve")
public class InvtypesEntity {
    private int typeId;
    private Integer groupId;
    private String typeName;
    private String description;
    private Double mass;
    private Double volume;
    private Double capacity;
    private Integer portionSize;
    private Short raceId;
    private BigDecimal basePrice;
    private Byte published;
    private Integer marketGroupId;
    private Integer iconId;
    private Long soundId;

    @Id
    @Column(name = "typeID", nullable = false, insertable = true, updatable = true)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "groupID", nullable = true, insertable = true, updatable = true)
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "typeName", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "mass", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "volume", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "capacity", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "portionSize", nullable = true, insertable = true, updatable = true)
    public Integer getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(Integer portionSize) {
        this.portionSize = portionSize;
    }

    @Basic
    @Column(name = "raceID", nullable = true, insertable = true, updatable = true)
    public Short getRaceId() {
        return raceId;
    }

    public void setRaceId(Short raceId) {
        this.raceId = raceId;
    }

    @Basic
    @Column(name = "basePrice", nullable = true, insertable = true, updatable = true, precision = 4)
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    @Basic
    @Column(name = "published", nullable = true, insertable = true, updatable = true)
    public Byte getPublished() {
        return published;
    }

    public void setPublished(Byte published) {
        this.published = published;
    }

    @Basic
    @Column(name = "marketGroupID", nullable = true, insertable = true, updatable = true)
    public Integer getMarketGroupId() {
        return marketGroupId;
    }

    public void setMarketGroupId(Integer marketGroupId) {
        this.marketGroupId = marketGroupId;
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
    @Column(name = "soundID", nullable = true, insertable = true, updatable = true)
    public Long getSoundId() {
        return soundId;
    }

    public void setSoundId(Long soundId) {
        this.soundId = soundId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvtypesEntity that = (InvtypesEntity) o;

        if (typeId != that.typeId) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (mass != null ? !mass.equals(that.mass) : that.mass != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (portionSize != null ? !portionSize.equals(that.portionSize) : that.portionSize != null) return false;
        if (raceId != null ? !raceId.equals(that.raceId) : that.raceId != null) return false;
        if (basePrice != null ? !basePrice.equals(that.basePrice) : that.basePrice != null) return false;
        if (published != null ? !published.equals(that.published) : that.published != null) return false;
        if (marketGroupId != null ? !marketGroupId.equals(that.marketGroupId) : that.marketGroupId != null)
            return false;
        if (iconId != null ? !iconId.equals(that.iconId) : that.iconId != null) return false;
        if (soundId != null ? !soundId.equals(that.soundId) : that.soundId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (portionSize != null ? portionSize.hashCode() : 0);
        result = 31 * result + (raceId != null ? raceId.hashCode() : 0);
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        result = 31 * result + (published != null ? published.hashCode() : 0);
        result = 31 * result + (marketGroupId != null ? marketGroupId.hashCode() : 0);
        result = 31 * result + (iconId != null ? iconId.hashCode() : 0);
        result = 31 * result + (soundId != null ? soundId.hashCode() : 0);
        return result;
    }
}
