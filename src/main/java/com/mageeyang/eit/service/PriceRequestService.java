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

    @Autowired
    private PricehistoryRepository pricehistoryRepository;

    @Autowired
    private InvTypesRepository invTypesRepository;

    /**
     * 获取原材料的价格
     */
    public void getPrice(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<PricehistoryEntity> pricehistoryEntityList = new ArrayList<PricehistoryEntity>();
        ArrayList<String> typeslist = EitConfigInfo.getTypeslist();
        ArrayList<JSONArray> priceJsonArrayList = new ArrayList<JSONArray>();
        HttpUtil httpUtil = new HttpUtil(10000);
        for(int i=0;i<typeslist.size();i++){
            String url = EitConfigInfo.URL_BEGIN+typeslist.get(i);
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
                pricehistoryEntity.setSystems(EitConfigInfo.USE_SYSTEM);
                pricehistoryEntity.setPricedate(timestamp);
                //----------SELL----------------
                pricehistoryEntity.setSellmin(sellJson.getBigDecimal("min"));
                pricehistoryEntity.setSellmax(sellJson.getBigDecimal("max"));
                pricehistoryEntity.setSellfive(sellJson.getBigDecimal("fivePercent"));
                pricehistoryEntity.setSellavg(sellJson.getBigDecimal("avg"));
                pricehistoryEntity.setSellvolume(sellJson.getDouble("volume"));
                pricehistoryEntity.setSellmedian(sellJson.getBigDecimal("median"));
                pricehistoryEntity.setSellwavg(sellJson.getBigDecimal("wavg"));
                //----------BUY----------------
                pricehistoryEntity.setBuymin(buyJson.getBigDecimal("min"));
                pricehistoryEntity.setBuymax(buyJson.getBigDecimal("max"));
                pricehistoryEntity.setBuyfive(buyJson.getBigDecimal("fivePercent"));
                pricehistoryEntity.setBuyavg(buyJson.getBigDecimal("avg"));
                pricehistoryEntity.setBuyvolume(buyJson.getDouble("volume"));
                pricehistoryEntity.setBuymedian(buyJson.getBigDecimal("median"));
                pricehistoryEntity.setBuywavg(buyJson.getBigDecimal("wavg"));
                //-------------ALL------------------------
                pricehistoryEntity.setAllavg(allJson.getBigDecimal("avg"));
                pricehistoryEntity.setAllmedian(allJson.getBigDecimal("median"));
                pricehistoryEntity.setAllwavg(allJson.getBigDecimal("wavg"));
                pricehistoryEntityList.add(pricehistoryEntity);
            }
        }
        System.out.println(pricehistoryEntityList.size());
        for(int k=0;k<pricehistoryEntityList.size();k++){
            pricehistoryRepository.save(pricehistoryEntityList.get(k));
        }

    }

    /**
     * 统计蓝图的制造成本及利润
     */
    public void getBluePrice(){

    }

}
