package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.HttpUtil;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;
import com.mageeyang.eit.db.repository.InvTypesRepository;
import com.mageeyang.eit.db.repository.PricehistoryRepository;
import org.json.JSONArray;
import org.json.JSONObject;
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
    private static final String USE_SYSTEM = "30000142";


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
        for(int i=0;i<1;i++){
            String url = URL_BEGIN+typeslist.get(i);
            JSONArray jsonArray = httpUtil.getJsonArray(url);
            priceJsonArrayList.add(jsonArray);
        }
        httpUtil.close();

        for(int i=0;i<priceJsonArrayList.size();i++){
            JSONArray jsonArray = priceJsonArrayList.get(i);
            for(int j=0;j<jsonArray.length();j++){
                JSONObject jsonObject = jsonArray.getJSONObject(j);
                JSONObject buyJson = jsonObject.getJSONObject("buy");
                JSONObject allJson = jsonObject.getJSONObject("all");
                JSONObject sellJson = jsonObject.getJSONObject("sell");
                String typeidString = allJson.getJSONObject("forQuery").get("types").toString();
                typeidString = typeidString.substring(1,typeidString.length()-1);
                PricehistoryEntity pricehistoryEntity = new PricehistoryEntity();
                pricehistoryEntity.setTypeid(Integer.parseInt(typeidString));
                pricehistoryEntity.setSystems(USE_SYSTEM);
                pricehistoryEntity.setPricedate(timestamp);
                //----------SELL----------------
                pricehistoryEntity.setSellmin(sellJson.getBigDecimal("min"));
                pricehistoryEntity.setSellmax(sellJson.getBigDecimal("max"));
                pricehistoryEntity.setSellfive(sellJson.getBigDecimal("fivePercent"));
                pricehistoryEntity.setSellavg(sellJson.getBigDecimal("avg"));
                pricehistoryEntity.setSellvolume(sellJson.getDouble("volume"));
                //----------BUY----------------
                pricehistoryEntity.setBuymin(buyJson.getBigDecimal("min"));
                pricehistoryEntity.setBuymax(buyJson.getBigDecimal("max"));
                pricehistoryEntity.setBuyfive(buyJson.getBigDecimal("fivePercent"));
                pricehistoryEntity.setBuyavg(buyJson.getBigDecimal("avg"));
                pricehistoryEntity.setBuyvolume(buyJson.getDouble("volume"));
                //-------------ALL------------------------
                pricehistoryEntity.setAllavg(allJson.getBigDecimal("avg"));
                pricehistoryEntityList.add(pricehistoryEntity);
            }
        }
        System.out.println(pricehistoryEntityList.size());
        for(int k=0;k<pricehistoryEntityList.size();k++){
            pricehistoryRepository.save(pricehistoryEntityList.get(k));
        }

    }
}
