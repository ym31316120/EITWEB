package com.mageeyang.eit.db.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/1/6.
 */
@Entity
@Table(name = "blueprintprice", schema = "", catalog = "eve")
@IdClass(BlueprintpriceEntityPK.class)
public class BlueprintpriceEntity {
    private int typeid;
    private int typegroup;
    private Timestamp bpdate;
    private String typename;
    private BigDecimal materialcost;
    private BigDecimal inventcost;
    private BigDecimal facilityfee;
    private BigDecimal totalcost;
    private BigDecimal sellprice;
    private BigDecimal income;
    private BigDecimal profit;
    private BigDecimal sellbalance;

    @Id
    @Column(name = "typeid", nullable = false, insertable = true, updatable = true)
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Id
    @Column(name = "typegroup", nullable = false, insertable = true, updatable = true)
    public int getTypegroup() {
        return typegroup;
    }

    public void setTypegroup(int typegroup) {
        this.typegroup = typegroup;
    }

    @Id
    @Column(name = "bpdate", nullable = false, insertable = true, updatable = true)
    public Timestamp getBpdate() {
        return bpdate;
    }

    public void setBpdate(Timestamp bpdate) {
        this.bpdate = bpdate;
    }

    @Basic
    @Column(name = "typename", nullable = true, insertable = true, updatable = true, length = 111)
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Basic
    @Column(name = "materialcost", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getMaterialcost() {
        return materialcost;
    }

    public void setMaterialcost(BigDecimal materialcost) {
        this.materialcost = materialcost;
    }

    @Basic
    @Column(name = "inventcost", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getInventcost() {
        return inventcost;
    }

    public void setInventcost(BigDecimal inventcost) {
        this.inventcost = inventcost;
    }

    @Basic
    @Column(name = "facilityfee", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getFacilityfee() {
        return facilityfee;
    }

    public void setFacilityfee(BigDecimal facilityfee) {
        this.facilityfee = facilityfee;
    }

    @Basic
    @Column(name = "totalcost", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(BigDecimal totalcost) {
        this.totalcost = totalcost;
    }

    @Basic
    @Column(name = "sellprice", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
        this.sellprice = sellprice;
    }

    @Basic
    @Column(name = "income", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Basic
    @Column(name = "profit", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Basic
    @Column(name = "sellbalance", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSellbalance() {
        return sellbalance;
    }

    public void setSellbalance(BigDecimal sellbalance) {
        this.sellbalance = sellbalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlueprintpriceEntity that = (BlueprintpriceEntity) o;

        if (typeid != that.typeid) return false;
        if (typegroup != that.typegroup) return false;
        if (bpdate != null ? !bpdate.equals(that.bpdate) : that.bpdate != null) return false;
        if (typename != null ? !typename.equals(that.typename) : that.typename != null) return false;
        if (materialcost != null ? !materialcost.equals(that.materialcost) : that.materialcost != null) return false;
        if (inventcost != null ? !inventcost.equals(that.inventcost) : that.inventcost != null) return false;
        if (facilityfee != null ? !facilityfee.equals(that.facilityfee) : that.facilityfee != null) return false;
        if (totalcost != null ? !totalcost.equals(that.totalcost) : that.totalcost != null) return false;
        if (sellprice != null ? !sellprice.equals(that.sellprice) : that.sellprice != null) return false;
        if (income != null ? !income.equals(that.income) : that.income != null) return false;
        if (profit != null ? !profit.equals(that.profit) : that.profit != null) return false;
        if (sellbalance != null ? !sellbalance.equals(that.sellbalance) : that.sellbalance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeid;
        result = 31 * result + typegroup;
        result = 31 * result + (bpdate != null ? bpdate.hashCode() : 0);
        result = 31 * result + (typename != null ? typename.hashCode() : 0);
        result = 31 * result + (materialcost != null ? materialcost.hashCode() : 0);
        result = 31 * result + (inventcost != null ? inventcost.hashCode() : 0);
        result = 31 * result + (facilityfee != null ? facilityfee.hashCode() : 0);
        result = 31 * result + (totalcost != null ? totalcost.hashCode() : 0);
        result = 31 * result + (sellprice != null ? sellprice.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        result = 31 * result + (profit != null ? profit.hashCode() : 0);
        result = 31 * result + (sellbalance != null ? sellbalance.hashCode() : 0);
        return result;
    }
}
