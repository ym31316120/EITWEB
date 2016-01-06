package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.HttpUtil;
import com.mageeyang.eit.db.bean.BluePrintInfo;
import com.mageeyang.eit.db.bean.BluePrintMaterialList;
import com.mageeyang.eit.db.model.BlueprintpriceEntity;
import com.mageeyang.eit.db.model.IndustryactivitymaterialsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;
import com.mageeyang.eit.db.repository.BluePrintPriceRepository;
import com.mageeyang.eit.db.repository.InvTypesRepository;
import com.mageeyang.eit.db.repository.PricehistoryRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class PriceRequestService {

    @Autowired
    private PricehistoryRepository pricehistoryRepository;

    @Autowired
    private InvTypesRepository invTypesRepository;

    @Autowired
    private BluePrintPriceRepository bluePrintPriceRepository;

    /**
     * 获取原材料的价格
     */
    public void getPrice() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<PricehistoryEntity> pricehistoryEntityList = new ArrayList<PricehistoryEntity>();
        ArrayList<String> typeslist = EitConfigInfo.getTypeslist();
        ArrayList<JSONArray> priceJsonArrayList = new ArrayList<JSONArray>();
        HttpUtil httpUtil = new HttpUtil(10000);
        for (int i = 0; i < typeslist.size(); i++) {
            String url = EitConfigInfo.URL_BEGIN + typeslist.get(i);
            JSONArray jsonArray = httpUtil.getJsonArray(url);
            priceJsonArrayList.add(jsonArray);
        }
        httpUtil.close();
        System.out.println("从eve-centrol获取数据完成");
        for (int i = 0; i < priceJsonArrayList.size(); i++) {
            JSONArray jsonArray = priceJsonArrayList.get(i);
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);
                JSONObject buyJson = jsonObject.getJSONObject("buy");
                JSONObject allJson = jsonObject.getJSONObject("all");
                JSONObject sellJson = jsonObject.getJSONObject("sell");
                String typeidString = allJson.getJSONObject("forQuery").get("types").toString();
                typeidString = typeidString.substring(1, typeidString.length() - 1);
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
        for (int k = 0; k < pricehistoryEntityList.size(); k++) {
            pricehistoryRepository.save(pricehistoryEntityList.get(k));
        }

    }

    public PricehistoryEntity findbytypeidanddate(Integer typeid, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pricehistoryRepository.findByTypeIdAndPricedateBetween(typeid, startDate, endDate);
    }

    public List<PricehistoryEntity> findbydate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(date + " 00:00:00");
            endDate = sdf.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pricehistoryRepository.findByPricedateBetween(startDate, endDate);
    }

    public BlueprintpriceEntity createBluePrintPrice(BluePrintInfo bpi, Timestamp ts, int type, BigDecimal mCost, BigDecimal invCost, PricehistoryEntity productPrice) {
        BlueprintpriceEntity bppe = new BlueprintpriceEntity();
        MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
        bppe.setTypeid(bpi.getBlueprint().getTypeId());
        bppe.setMarketgroupid(bpi.getBlueprint().getMarketGroupId());
        bppe.setTypename(bpi.getProductinfo().getTypeName());
        bppe.setBpdate(ts);
        bppe.setTypegroup(type);
        bppe.setMaterialcost(mCost);
        bppe.setInventcost(invCost);
        BigDecimal total = mCost.add(invCost);
        bppe.setFacilityfee(total.multiply(EitConfigInfo.TAX));
        BigDecimal totalCost = total.add(total.multiply(EitConfigInfo.TAX));
        bppe.setTotalcost(totalCost);
        BigDecimal sellPrice = new BigDecimal(0);
        switch (type){
            case 1:
                sellPrice = productPrice.getSellmin();
                break;
            case 2:
                sellPrice = productPrice.getBuymax();
                break;
            case 3:
                sellPrice = productPrice.getBuymax();
                break;
        }
        bppe.setSellprice(sellPrice);
        bppe.setIncome(sellPrice.subtract(totalCost));
        if(!totalCost.stripTrailingZeros().toPlainString().equals("0")) {
            bppe.setProfit(sellPrice.subtract(totalCost).divide(totalCost,mc).multiply(new BigDecimal(100)));
        }
        //分析物品的销售情况
        if(productPrice.getSellvolume()!=null&&productPrice.getSellvolume()!=0) {
            double t = productPrice.getBuyvolume() * 100 / productPrice.getSellvolume();
            bppe.setSellbalance(new BigDecimal(t));
        }

        return bppe;
    }

    /**
     * 统计蓝图的制造成本及利润
     */
    public void getBluePrice() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HashMap<Integer, PricehistoryEntity> priceMap = new HashMap<Integer, PricehistoryEntity>();
        //将当天价格都放到map中方便查找
        List<PricehistoryEntity> phes = findbydate("2016-01-06");
        for (int i = 0; i < phes.size(); i++) {
            priceMap.put(phes.get(i).getTypeid(), phes.get(i));
        }
        //获取蓝图列表
        List<InvtypesEntity> bplists = invTypesRepository.findBymarketGroupIdIn(EitConfigInfo.getBpMarketGroupids());
        HashMap<Integer, BluePrintInfo> map = EitConfigInfo.getBluePrintInfoHashMap();
        for (int i = 0; i < bplists.size(); i++) {
            //循环蓝图，到缓存map中查找蓝图的详细信息，然后统计蓝图价格
            BluePrintInfo bpi = map.get(bplists.get(i).getTypeId());

            //首先获取蓝图成品价格
            PricehistoryEntity productPrice = priceMap.get(bpi.getProductinfo().getTypeId());
            if(productPrice==null){
                continue;
            }


            List<BluePrintMaterialList> bpmls = bpi.getProductMaterials();

            //开始统计原材料价格
            BigDecimal mCost_sell = new BigDecimal(0);
            BigDecimal mCost_buy = new BigDecimal(0);
            for (int j = 0; j < bpmls.size(); j++) {
                BluePrintInfo sub_bpi = bpmls.get(j).getBluePrintInfo();
                IndustryactivitymaterialsEntity indAtMat = bpmls.get(j).getIndustryactivitymaterialsEntity();
                PricehistoryEntity phe_z = priceMap.get(indAtMat.getMaterialTypeId());
                if (sub_bpi == null) {
                    //该原材料为底层原材料
                    mCost_sell = mCost_sell.add(phe_z.getSellmin().multiply(BigDecimal.valueOf(Math.ceil(indAtMat.getQuantity()*bpi.getMt()))));
                    mCost_buy = mCost_buy.add(phe_z.getBuymax().multiply(BigDecimal.valueOf(Math.ceil(indAtMat.getQuantity() * bpi.getMt()))));
                } else {
                    for (int k = 0; k < sub_bpi.getProductMaterials().size(); k++) {
                        IndustryactivitymaterialsEntity z_indAtMat = sub_bpi.getProductMaterials().get(k).getIndustryactivitymaterialsEntity();
                        PricehistoryEntity z_phe = priceMap.get(z_indAtMat.getMaterialTypeId());

                        mCost_sell = mCost_sell.add(z_phe.getSellmin()
                                .multiply(BigDecimal.valueOf(Math.ceil(z_indAtMat.getQuantity() * sub_bpi.getMt())))
                                .multiply(BigDecimal.valueOf(Math.ceil(indAtMat.getQuantity() * bpi.getMt()))));
                        mCost_buy = mCost_buy.add(z_phe.getBuymax()
                                .multiply(BigDecimal.valueOf(Math.ceil(z_indAtMat.getQuantity() * sub_bpi.getMt())))
                                .multiply(BigDecimal.valueOf(Math.ceil(indAtMat.getQuantity() * bpi.getMt()))));
                    }
                }
            }

            //统计发明成本
            BigDecimal inventCost = new BigDecimal(0);
            if (bpi.getInventMaterial() != null && bpi.getInventMaterial().size() > 0) {
                //如果有发明成本，则统计
                for (int j = 0; j < bpi.getInventMaterial().size(); j++) {
                    IndustryactivitymaterialsEntity z_indAtMat = bpi.getInventMaterial().get(j);
                    PricehistoryEntity z_phe = priceMap.get(z_indAtMat.getMaterialTypeId());
                    inventCost = inventCost.add(z_phe.getSellmin().multiply(BigDecimal.valueOf(z_indAtMat.getQuantity())));
                }
                inventCost = inventCost.subtract(BigDecimal.valueOf(bpi.getInventProbablity()));
            }

            //生成蓝图价格信息,(1)sell-sell
            BlueprintpriceEntity bppe_1 = createBluePrintPrice(bpi,timestamp,1,mCost_sell,inventCost,productPrice);
            //生成蓝图价格信息,(1)sell-buy
            BlueprintpriceEntity bppe_2 = createBluePrintPrice(bpi,timestamp,2,mCost_sell,inventCost,productPrice);
            //生成蓝图价格信息,(1)buy-buy
            BlueprintpriceEntity bppe_3 = createBluePrintPrice(bpi,timestamp,3,mCost_buy,inventCost,productPrice);


            bluePrintPriceRepository.save(bppe_2);
            bluePrintPriceRepository.save(bppe_3);
            bluePrintPriceRepository.save(bppe_1);
        }

    }

}
