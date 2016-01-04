package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
public interface MarketGroupRepository extends JpaRepository<InvmarketgroupsEntity, Integer> {
    public List<InvmarketgroupsEntity> findByparentGroupId(int parentID);
    public InvmarketgroupsEntity findBymarketGroupId(int marketGroudID);
}
