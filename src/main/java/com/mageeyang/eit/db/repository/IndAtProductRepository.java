package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.IndustryactivityproductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/1/5.
 */
public interface IndAtProductRepository extends JpaRepository<IndustryactivityproductsEntity,Integer> {
    public IndustryactivityproductsEntity findByTypeIdAndActivityId(Integer typeid,Integer actid);
    public IndustryactivityproductsEntity findByProductTypeIdAndActivityId(Integer proid,Integer actid);

}
