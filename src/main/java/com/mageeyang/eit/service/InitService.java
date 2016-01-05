package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.bean.BluePrintInfo;
import com.mageeyang.eit.db.bean.BluePrintMaterialList;
import com.mageeyang.eit.db.model.*;

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
        HashMap<Integer,BluePrintInfo> bluePrintInfoHashMap = new HashMap<Integer, BluePrintInfo>();
        MarketGroupService marketGroupService = BeanUtils.getBean("marketGroupService");
        BluePrintService bluePrintService = BeanUtils.getBean("bluePrintService");
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

            int typeid = bluebaseinfo.get(i).getTypeId();
            if(bluePrintInfoHashMap.get(typeid)==null) {
                createBluePrintInfo(bluePrintService, bluebaseinfo.get(i), bluePrintInfoHashMap);
            }
        }
        EitConfigInfo.setBluePrintInfoHashMap(bluePrintInfoHashMap);

    }

    /**
     * 创建蓝图信息
     * @param bps   蓝图的服务对象
     * @param ite   蓝图的基本信息
     * @param map   对蓝图信息进行判断
     */
    public static void createBluePrintInfo(BluePrintService bps,InvtypesEntity ite,HashMap<Integer,BluePrintInfo> map){
        BluePrintInfo bpi = new BluePrintInfo();
        int typeid = ite.getTypeId();
        //填入蓝图基本信息
        bpi.setBlueprint(ite);
        //填入产物数量及产物信息
        IndustryactivityproductsEntity indatp = bps.findIndAtProBy(typeid,1);
        bpi.setProduct_num(indatp.getQuantity());
        bpi.setProductinfo(bps.findInvtypeByTypeid(indatp.getProductTypeId()));
        //制造产物的时间
        bpi.setIndustryTime(bps.findTimeBytypeid(typeid,1).getTime());
        //查询该蓝图是否是由其他蓝图发明的
        IndustryactivityproductsEntity inventproduct = bps.findIndAtProByProId(typeid,8);
        if(inventproduct!=null){
            //如果是由其他蓝图发明的，则设置发明相关的原材料及发明率等数据
            //发明的蓝图流程数
            bpi.setLine_num(inventproduct.getQuantity());
            //发明的成功率
            bpi.setInventProbablity(bps.findProbabilByProid(typeid).getProbability().add(EitConfigInfo.IVENT_PROBABITY));
            //发明的原材料
            List<IndustryactivitymaterialsEntity> inventMalist =  bps.findMaterialByTypeid(inventproduct.getTypeId(),8);
            bpi.setInventMaterial(inventMalist);
        }
        //下面是最关键的递归查询该蓝图的制造原材料数据
        List<IndustryactivitymaterialsEntity> productMaterlist = bps.findMaterialByTypeid(typeid,1);
        List<BluePrintMaterialList> bpmls = new ArrayList<BluePrintMaterialList>();
        for(int i=0;i<productMaterlist.size();i++){
            BluePrintMaterialList bpml = new BluePrintMaterialList();

            bpml.setIndustryactivitymaterialsEntity(productMaterlist.get(i));
            IndustryactivityproductsEntity indatpro = bps.findIndAtProByProId(productMaterlist.get(i).getMaterialTypeId(),1);
            //如果不为空则表示该物品还有下一级蓝图原材料可以使用，需要设置BluePrintInfo对象
            if(indatp!=null){
                //首先判断该蓝图是否已经在map里了，如果在直接获取
                int sub_typeid = indatpro.getTypeId();
                if(map.get(indatpro.getTypeId())!=null){
                    bpml.setBluePrintInfo(map.get(sub_typeid));
                }else{
                    createBluePrintInfo(bps,bps.findInvtypeByTypeid(sub_typeid),map);
                    bpml.setBluePrintInfo(map.get(sub_typeid));
                }
            }
            bpmls.add(bpml);
        }
        bpi.setProductMaterials(bpmls);
        map.put(typeid,bpi);
    }
}
