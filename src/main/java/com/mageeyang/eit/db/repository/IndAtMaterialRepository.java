package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.IndustryactivitymaterialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public interface IndAtMaterialRepository extends JpaRepository<IndustryactivitymaterialsEntity,Integer> {
    public List<IndustryactivitymaterialsEntity> findByTypeIdAndActivityId(Integer typeid,Integer acid);
}
