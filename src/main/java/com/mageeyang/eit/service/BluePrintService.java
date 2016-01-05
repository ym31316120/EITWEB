package com.mageeyang.eit.service;

import com.mageeyang.eit.db.model.*;
import com.mageeyang.eit.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public class BluePrintService {
    @Autowired
    private IndAtRepository indAtRepository;
    @Autowired
    private InvTypesRepository invTypesRepository;
    @Autowired
    private IndAtMaterialRepository indAtMaterialRepository;
    @Autowired
    private IndAtProbabilitiesRepository indAtProbabilitiesRepository;
    @Autowired
    private IndAtProductRepository indAtProductRepository;

    /**
     * 根据类型编码从蓝图产物表中查询出数据
     * @param typeid    类型编码
     * @param acid      产物类型ID
     * @return
     */
    public IndustryactivityproductsEntity findIndAtProBy(Integer typeid,Integer acid){
        return indAtProductRepository.findByTypeIdAndActivityId(typeid, acid);
    }

    public InvtypesEntity findInvtypeByTypeid(Integer typeid){
        return invTypesRepository.findBytypeId(typeid);
    }

    public IndustryactivityproductsEntity findIndAtProByProId(Integer proid,Integer acid){
        return indAtProductRepository.findByProductTypeIdAndActivityId(proid, acid);
    }

    public IndustryactivityprobabilitiesEntity findProbabilByProid(Integer proid){
        return indAtProbabilitiesRepository.findByProductTypeId(proid);
    }

    public List<IndustryactivitymaterialsEntity> findMaterialByTypeid(Integer typeid,Integer acid){
        return indAtMaterialRepository.findByTypeIdAndActivityId(typeid,acid);
    }



    public IndustryactivityEntity findTimeBytypeid(Integer typeid,Integer acid){
        return indAtRepository.findByTypeIdAndActivityId(typeid,acid);
    }



}
