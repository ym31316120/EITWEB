package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.InvtypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public interface InvTypesRepository extends JpaRepository<InvtypesEntity,Integer> {
    public InvtypesEntity findBytypeId(int typeid);
    public List<InvtypesEntity> findBymarketGroupId(Integer marketGroupId);
    public List<InvtypesEntity> findBymarketGroupIdIn(Collection<Integer> arg);
}
