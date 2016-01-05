package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.bean.BluePrintInfo;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class InitService {
    /**
     *  1857    矿石产物
     *  499     月矿产物
     *  1332    行星产物
     *  1861    打捞件
     *  1033    冰矿产物
     *  860     气矿产物
     *  4       舰船
     *  9       舰船装备
     *  11      弹药
     */
    private static final int [] MARKETGROUPLIST ={1857,499,1332,1861,1033,860,4,9,11};

    private  HashMap<Integer,BluePrintInfo> bluePrintInfoHashMap = new HashMap<Integer, BluePrintInfo>();


    /**
     * 初始化原材料的TypeID数据
     */
    public static void initEitConfig(){
        //根据MARKETGROUPLIST获取所有的市场分组列表，并放到EitConfig的静态变量中
        ArrayList<Integer> primitiveList = new ArrayList<Integer>();
        MarketGroupService marketGroupService = BeanUtils.getBean("marketGroupService");
        List<InvmarketgroupsEntity> invmarketgroupsEntityArrayList = new ArrayList<InvmarketgroupsEntity>();
        for(int i=0;i<MARKETGROUPLIST.length;i++){
            InvmarketgroupsEntity entity =marketGroupService.getMarketGroupEntity(MARKETGROUPLIST[i]);
            if(entity!=null){
                primitiveList.add(entity.getMarketGroupId());
                marketGroupService.getChildListListByParentId(invmarketgroupsEntityArrayList,entity.getMarketGroupId());
            }
        }
        for(int i=0;i<invmarketgroupsEntityArrayList.size();i++){
            InvmarketgroupsEntity entity = invmarketgroupsEntityArrayList.get(i);
            primitiveList.add(entity.getMarketGroupId());
        }
        EitConfigInfo.setPrimitiveList(primitiveList);

        //---------根据市场分组列表获取所有的属性该分组的物品列表，并把typeid进行拼接处理，并到EitConfig的静态变量中------------
        List<InvtypesEntity> invtypesEntityList = marketGroupService.getTypesByMarketGroupIds(primitiveList);
        ArrayList<String> typeslist = new ArrayList<String>();
        if(invtypesEntityList.size()>0){
            int row = (int)Math.floor(invtypesEntityList.size() / EitConfigInfo.COW_NUM);
            for(int i=0;i<(row+1);i++){
                String typeidstr = "";
                for(int j=0;j<EitConfigInfo.COW_NUM;j++){
                    int index = i*EitConfigInfo.COW_NUM+j;
                    if(index<invtypesEntityList.size()){
                        typeidstr = typeidstr +","+ invtypesEntityList.get(index).getTypeId();
                    }else{
                        break;
                    }
                }
                typeidstr = typeidstr.substring(1);
                if(!typeidstr.equals("")){
                    typeslist.add(typeidstr);
                }
            }
            EitConfigInfo.setTypeslist(typeslist);
        }
    }

    /**
     * 初始化蓝图信息
     */
    public static void initBluePrintInfo(){
        MarketGroupService marketGroupService = BeanUtils.getBean("marketGroupService");
        //首先获取所有的蓝图基础信息列表
        ArrayList<InvmarketgroupsEntity> bluemarketgroups = new ArrayList<InvmarketgroupsEntity>();
        marketGroupService.getChildListListByParentId(bluemarketgroups,2);
        EitConfigInfo.setBluemarketgroups(bluemarketgroups);

        ArrayList<Integer> marketgroupids = new ArrayList<Integer>();
        for(int i=0;i<bluemarketgroups.size();i++){
            marketgroupids.add(bluemarketgroups.get(i).getMarketGroupId());
        }
        List<InvtypesEntity> bluebaseinfo = marketGroupService.getTypesByMarketGroupIds(marketgroupids);
        for(int i=0;i<bluebaseinfo.size();i++){
            BluePrintInfo bpi = new BluePrintInfo();


        }

        System.out.println(marketgroupids.toString());

    }
}
