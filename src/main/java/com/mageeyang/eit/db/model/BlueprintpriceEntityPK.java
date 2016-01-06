package com.mageeyang.eit.db.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/1/6.
 */
public class BlueprintpriceEntityPK implements Serializable {
    private int typeid;
    private int typegroup;
    private Timestamp bpdate;

    @Column(name = "typeid", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Column(name = "typegroup", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTypegroup() {
        return typegroup;
    }

    public void setTypegroup(int typegroup) {
        this.typegroup = typegroup;
    }

    @Column(name = "bpdate", nullable = false, insertable = true, updatable = true)
    @Id
    public Timestamp getBpdate() {
        return bpdate;
    }

    public void setBpdate(Timestamp bpdate) {
        this.bpdate = bpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlueprintpriceEntityPK that = (BlueprintpriceEntityPK) o;

        if (typeid != that.typeid) return false;
        if (typegroup != that.typegroup) return false;
        if (bpdate != null ? !bpdate.equals(that.bpdate) : that.bpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeid;
        result = 31 * result + typegroup;
        result = 31 * result + (bpdate != null ? bpdate.hashCode() : 0);
        return result;
    }
}
