package com.mageeyang.eit.db.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/1/5.
 */
@Entity
@javax.persistence.Table(name = "pricehistory", schema = "", catalog = "eve")
public class PricehistoryEntity {
    private int id;

    @Id
    @javax.persistence.Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int typeid;

    @Basic
    @javax.persistence.Column(name = "typeid", nullable = false, insertable = true, updatable = true)
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    private String systems;

    @Basic
    @javax.persistence.Column(name = "systems", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSystems() {
        return systems;
    }

    public void setSystems(String systems) {
        this.systems = systems;
    }

    private Timestamp pricedate;

    @Basic
    @javax.persistence.Column(name = "pricedate", nullable = false, insertable = true, updatable = true)
    public Timestamp getPricedate() {
        return pricedate;
    }

    public void setPricedate(Timestamp pricedate) {
        this.pricedate = pricedate;
    }

    private BigDecimal sellmin;

    @Basic
    @javax.persistence.Column(name = "sellmin", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellmin() {
        return sellmin;
    }

    public void setSellmin(BigDecimal sellmin) {
        this.sellmin = sellmin;
    }

    private BigDecimal sellmax;

    @Basic
    @javax.persistence.Column(name = "sellmax", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellmax() {
        return sellmax;
    }

    public void setSellmax(BigDecimal sellmax) {
        this.sellmax = sellmax;
    }

    private BigDecimal sellfive;

    @Basic
    @javax.persistence.Column(name = "sellfive", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellfive() {
        return sellfive;
    }

    public void setSellfive(BigDecimal sellfive) {
        this.sellfive = sellfive;
    }

    private BigDecimal sellavg;

    @Basic
    @javax.persistence.Column(name = "sellavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellavg() {
        return sellavg;
    }

    public void setSellavg(BigDecimal sellavg) {
        this.sellavg = sellavg;
    }

    private BigDecimal sellwavg;

    @Basic
    @javax.persistence.Column(name = "sellwavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellwavg() {
        return sellwavg;
    }

    public void setSellwavg(BigDecimal sellwavg) {
        this.sellwavg = sellwavg;
    }

    private BigDecimal sellmedian;

    @Basic
    @javax.persistence.Column(name = "sellmedian", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellmedian() {
        return sellmedian;
    }

    public void setSellmedian(BigDecimal sellmedian) {
        this.sellmedian = sellmedian;
    }

    private Double sellvolume;

    @Basic
    @javax.persistence.Column(name = "sellvolume", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getSellvolume() {
        return sellvolume;
    }

    public void setSellvolume(Double sellvolume) {
        this.sellvolume = sellvolume;
    }

    private BigDecimal buymin;

    @Basic
    @javax.persistence.Column(name = "buymin", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuymin() {
        return buymin;
    }

    public void setBuymin(BigDecimal buymin) {
        this.buymin = buymin;
    }

    private BigDecimal buymax;

    @Basic
    @javax.persistence.Column(name = "buymax", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuymax() {
        return buymax;
    }

    public void setBuymax(BigDecimal buymax) {
        this.buymax = buymax;
    }

    private BigDecimal buyfive;

    @Basic
    @javax.persistence.Column(name = "buyfive", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuyfive() {
        return buyfive;
    }

    public void setBuyfive(BigDecimal buyfive) {
        this.buyfive = buyfive;
    }

    private BigDecimal buyavg;

    @Basic
    @javax.persistence.Column(name = "buyavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuyavg() {
        return buyavg;
    }

    public void setBuyavg(BigDecimal buyavg) {
        this.buyavg = buyavg;
    }

    private BigDecimal buywavg;

    @Basic
    @javax.persistence.Column(name = "buywavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuywavg() {
        return buywavg;
    }

    public void setBuywavg(BigDecimal buywavg) {
        this.buywavg = buywavg;
    }

    private BigDecimal buymedian;

    @Basic
    @javax.persistence.Column(name = "buymedian", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getBuymedian() {
        return buymedian;
    }

    public void setBuymedian(BigDecimal buymedian) {
        this.buymedian = buymedian;
    }

    private Double buyvolume;

    @Basic
    @javax.persistence.Column(name = "buyvolume", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getBuyvolume() {
        return buyvolume;
    }

    public void setBuyvolume(Double buyvolume) {
        this.buyvolume = buyvolume;
    }

    private BigDecimal allavg;

    @Basic
    @javax.persistence.Column(name = "allavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAllavg() {
        return allavg;
    }

    public void setAllavg(BigDecimal allavg) {
        this.allavg = allavg;
    }

    private BigDecimal allmedian;

    @Basic
    @javax.persistence.Column(name = "allmedian", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAllmedian() {
        return allmedian;
    }

    public void setAllmedian(BigDecimal allmedian) {
        this.allmedian = allmedian;
    }

    private BigDecimal allwavg;

    @Basic
    @javax.persistence.Column(name = "allwavg", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAllwavg() {
        return allwavg;
    }

    public void setAllwavg(BigDecimal allwavg) {
        this.allwavg = allwavg;
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
        if (sellwavg != null ? !sellwavg.equals(that.sellwavg) : that.sellwavg != null) return false;
        if (sellmedian != null ? !sellmedian.equals(that.sellmedian) : that.sellmedian != null) return false;
        if (sellvolume != null ? !sellvolume.equals(that.sellvolume) : that.sellvolume != null) return false;
        if (buymin != null ? !buymin.equals(that.buymin) : that.buymin != null) return false;
        if (buymax != null ? !buymax.equals(that.buymax) : that.buymax != null) return false;
        if (buyfive != null ? !buyfive.equals(that.buyfive) : that.buyfive != null) return false;
        if (buyavg != null ? !buyavg.equals(that.buyavg) : that.buyavg != null) return false;
        if (buywavg != null ? !buywavg.equals(that.buywavg) : that.buywavg != null) return false;
        if (buymedian != null ? !buymedian.equals(that.buymedian) : that.buymedian != null) return false;
        if (buyvolume != null ? !buyvolume.equals(that.buyvolume) : that.buyvolume != null) return false;
        if (allavg != null ? !allavg.equals(that.allavg) : that.allavg != null) return false;
        if (allmedian != null ? !allmedian.equals(that.allmedian) : that.allmedian != null) return false;
        if (allwavg != null ? !allwavg.equals(that.allwavg) : that.allwavg != null) return false;

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
        result = 31 * result + (sellwavg != null ? sellwavg.hashCode() : 0);
        result = 31 * result + (sellmedian != null ? sellmedian.hashCode() : 0);
        result = 31 * result + (sellvolume != null ? sellvolume.hashCode() : 0);
        result = 31 * result + (buymin != null ? buymin.hashCode() : 0);
        result = 31 * result + (buymax != null ? buymax.hashCode() : 0);
        result = 31 * result + (buyfive != null ? buyfive.hashCode() : 0);
        result = 31 * result + (buyavg != null ? buyavg.hashCode() : 0);
        result = 31 * result + (buywavg != null ? buywavg.hashCode() : 0);
        result = 31 * result + (buymedian != null ? buymedian.hashCode() : 0);
        result = 31 * result + (buyvolume != null ? buyvolume.hashCode() : 0);
        result = 31 * result + (allavg != null ? allavg.hashCode() : 0);
        result = 31 * result + (allmedian != null ? allmedian.hashCode() : 0);
        result = 31 * result + (allwavg != null ? allwavg.hashCode() : 0);
        return result;
    }
}
