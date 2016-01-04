package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.HttpUtil;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;
import com.mageeyang.eit.db.repository.InvTypesRepository;
import com.mageeyang.eit.db.repository.PricehistoryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class PriceRequestService {
    private static final int COW_NUM = 50;
    private static final String URL_BEGIN = "http://api.eve-central.com/api/marketstat/json?usesystem=30000142&typeid=";


    @Autowired
    private PricehistoryRepository pricehistoryRepository;

    @Autowired
    private InvTypesRepository invTypesRepository;

    public void getPrice(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<PricehistoryEntity> pricehistoryEntityList = new ArrayList<PricehistoryEntity>();
        ArrayList<String> typeslist = EitConfigInfo.getTypeslist();
        ArrayList<JSONArray> priceJsonArrayList = new ArrayList<JSONArray>();
        HttpUtil httpUtil = new HttpUtil(10000);
        for(int i=0;i<typeslist.size();i++){
            String url = URL_BEGIN+typeslist.get(i);
            JSONArray jsonArray = httpUtil.getJsonArray(url);
            priceJsonArrayList.add(jsonArray);
        }
        httpUtil.close();

        for(int i=0;i<priceJsonArrayList.size();i++){

        }



    }
}
