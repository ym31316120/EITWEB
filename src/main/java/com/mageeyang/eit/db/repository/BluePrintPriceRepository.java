package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.BlueprintpriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface BluePrintPriceRepository extends JpaRepository<BlueprintpriceEntity,Integer>{
    public List<BlueprintpriceEntity> findByMarketgroupidIn(Collection<Integer> arg);

    @Query(value="select o from BlueprintpriceEntity o where o.typegroup = ?1 and o.marketgroupid in ?2 and o.bpdate between ?3 and ?4 ")
    public List<BlueprintpriceEntity> findByMarketgroupidIdAndPricedateBetween(Integer type,Collection<Integer> arg,Date bdate,Date edate);
}
