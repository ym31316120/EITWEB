package com.mageeyang.eit.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/1/4.
 */
@Entity
@Table(name = "pricehistory", schema = "", catalog = "eve")
public class PricehistoryEntity {
    private int id;
    private int typeid;
    private String systems;
    private Timestamp pricedate;
    private BigDecimal sellmin;
    private BigDecimal sellmax;
    private BigDecimal sellfive;
    private BigDecimal sellavg;
    private Double sellvolume;
    private BigDecimal buymin;
    private BigDecimal buymax;
    private BigDecimal buyfive;
    private BigDecimal buyavg;
    private Double buyvolume;
    private BigDecimal allavg;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "typeid", nullable = false, insertable = true, updatable = true)
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "systems", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSystems() {
        return systems;
    }

    public void setSystems(String systems) {
        this.systems = systems;
    }

    @Basic
    @Column(name = "pricedate", nullable = false, insertable = true, updatable = true)
    public Timestamp getPricedate() {
        return pricedate;
    }

    public void setPricedate(Timestamp pricedate) {
        this.pricedate = pricedate;
    }

    @Basic
    @Column(name = "sellmin", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellmin() {
        return sellmin;
    }

    public void setSellmin(BigDecimal sellmin) {
        this.sellmin = sellmin;
    }

    @Basic
    @Column(name = "sellmax", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellmax() {
        return sellmax;
    }

    public void setSellmax(BigDecimal sellmax) {
        this.sellmax = sellmax;
    }

    @Basic
    @Column(name = "sellfive", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellfive() {
        return sellfive;
    }

    public void setSellfive(BigDecimal sellfive) {
        this.sellfive = sellfive;
    }

    @Basic
    @Column(name = "sellavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellavg() {
        return sellavg;
    }

    public void setSellavg(BigDecimal sellavg) {
        this.sellavg = sellavg;
    }

    @Basic
    @Column(name = "sellvolume", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getSellvolume() {
        return sellvolume;
    }

    public void setSellvolume(Double sellvolume) {
        this.sellvolume = sellvolume;
    }

    @Basic
    @Column(name = "buymin", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuymin() {
        return buymin;
    }

    public void setBuymin(BigDecimal buymin) {
        this.buymin = buymin;
    }

    @Basic
    @Column(name = "buymax", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuymax() {
        return buymax;
    }

    public void setBuymax(BigDecimal buymax) {
        this.buymax = buymax;
    }

    @Basic
    @Column(name = "buyfive", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuyfive() {
        return buyfive;
    }

    public void setBuyfive(BigDecimal buyfive) {
        this.buyfive = buyfive;
    }

    @Basic
    @Column(name = "buyavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuyavg() {
        return buyavg;
    }

    public void setBuyavg(BigDecimal buyavg) {
        this.buyavg = buyavg;
    }

    @Basic
    @Column(name = "buyvolume", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getBuyvolume() {
        return buyvolume;
    }

    public void setBuyvolume(Double buyvolume) {
        this.buyvolume = buyvolume;
    }

    @Basic
    @Column(name = "allavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAllavg() {
        return allavg;
    }

    public void setAllavg(BigDecimal allavg) {
        this.allavg = allavg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricehistoryEntity that = (PricehistoryEntity) o;

        if (id != that.id) return false;
        if (typeid != that.typeid) return false;
        if (systems != null ? !systems.equals(that.systems) : that.systems != null) return false;
        if (pricedate != null ? !pricedate.equals(that.pricedate) : that.pricedate != null) return false;
        if (sellmin != null ? !sellmin.equals(that.sellmin) : that.sellmin != null) return false;
        if (sellmax != null ? !sellmax.equals(that.sellmax) : that.sellmax != null) return false;
        if (sellfive != null ? !sellfive.equals(that.sellfive) : that.sellfive != null) return false;
        if (sellavg != null ? !sellavg.equals(that.sellavg) : that.sellavg != null) return false;
        if (sellvolume != null ? !sellvolume.equals(that.sellvolume) : that.sellvolume != null) return false;
        if (buymin != null ? !buymin.equals(that.buymin) : that.buymin != null) return false;
        if (buymax != null ? !buymax.equals(that.buymax) : that.buymax != null) return false;
        if (buyfive != null ? !buyfive.equals(that.buyfive) : that.buyfive != null) return false;
        if (buyavg != null ? !buyavg.equals(that.buyavg) : that.buyavg != null) return false;
        if (buyvolume != null ? !buyvolume.equals(that.buyvolume) : that.buyvolume != null) return false;
        if (allavg != null ? !allavg.equals(that.allavg) : that.allavg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + typeid;
        result = 31 * result + (systems != null ? systems.hashCode() : 0);
        result = 31 * result + (pricedate != null ? pricedate.hashCode() : 0);
        result = 31 * result + (sellmin != null ? sellmin.hashCode() : 0);
        result = 31 * result + (sellmax != null ? sellmax.hashCode() : 0);
        result = 31 * result + (sellfive != null ? sellfive.hashCode() : 0);
        result = 31 * result + (sellavg != null ? sellavg.hashCode() : 0);
        result = 31 * result + (sellvolume != null ? sellvolume.hashCode() : 0);
        result = 31 * result + (buymin != null ? buymin.hashCode() : 0);
        result = 31 * result + (buymax != null ? buymax.hashCode() : 0);
        result = 31 * result + (buyfive != null ? buyfive.hashCode() : 0);
        result = 31 * result + (buyavg != null ? buyavg.hashCode() : 0);
        result = 31 * result + (buyvolume != null ? buyvolume.hashCode() : 0);
        result = 31 * result + (allavg != null ? allavg.hashCode() : 0);
        return result;
    }
}
