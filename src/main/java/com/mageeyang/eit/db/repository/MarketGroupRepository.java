package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/1/2.
 */
public interface MarketGroupRepository extends JpaRepository<InvmarketgroupsEntity, Integer> {
}
