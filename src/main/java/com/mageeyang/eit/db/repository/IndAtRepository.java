package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.IndustryactivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/1/5.
 */
public interface IndAtRepository extends JpaRepository<IndustryactivityEntity,Integer> {
    public IndustryactivityEntity findByTypeIdAndActivityId(Integer typeid,Integer acid);
}
