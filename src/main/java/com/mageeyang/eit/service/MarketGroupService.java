package com.mageeyang.eit.service;

import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.repository.InvTypesRepository;
import com.mageeyang.eit.db.repository.MarketGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class MarketGroupService {

    @Autowired
    private MarketGroupRepository marketGroupRepository;

    @Autowired
    private InvTypesRepository invTypesRepository;

    public void getChildListListByParentId(List<InvmarketgroupsEntity> marketGroupList, int parentGroupID) {
        List<InvmarketgroupsEntity> marketList = marketGroupRepository.findByparentGroupId(parentGroupID);
        if (marketList != null && marketList.size() > 0) {
            for (int i = 0; i < marketList.size(); i++) {
                InvmarketgroupsEntity invmarketgroupsEntity = marketList.get(i);
                marketGroupList.add(invmarketgroupsEntity);
                this.getChildListListByParentId(marketGroupList, invmarketgroupsEntity.getMarketGroupId());
            }
        }
    }

    public InvmarketgroupsEntity getMarketGroupEntity(int marketGroupID){
        InvmarketgroupsEntity invmarketgroupsEntity = marketGroupRepository.findBymarketGroupId(marketGroupID);
        return invmarketgroupsEntity;
    }

    public List<InvtypesEntity> getTypesByMarketGroupIds(List<Integer> args){
        return invTypesRepository.findBymarketGroupIdIn(args);
    }
}
