package com.mageeyang.eit.db.repository;

import com.mageeyang.eit.db.model.PricehistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public interface PricehistoryRepository extends JpaRepository<PricehistoryEntity,Integer> {
    public List<PricehistoryEntity> findByPricedateBetween(Date bdate,Date edate);

    @Query(value="select o from PricehistoryEntity o where o.typeid = ?1 and o.pricedate between ?2 and ?3")
    public PricehistoryEntity findByTypeIdAndPricedateBetween(Integer type,Date bdate,Date edate);
}
