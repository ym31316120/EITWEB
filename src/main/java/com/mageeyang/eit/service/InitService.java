package com.mageeyang.eit.service;

import com.mageeyang.eit.core.cache.EitConfigInfo;
import com.mageeyang.eit.core.util.BeanUtils;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;
import com.mageeyang.eit.db.model.InvtypesEntity;
import com.mageeyang.eit.db.model.PricehistoryEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class InitService {
    /**
     *  1857    ��ʯ����
     *  499     �¿�
     *  1332    ���ǲ���
     *  1861    ���̼�
     *  1033    �������
     *  860     �������
     *  4       ��ֻ
     *  9       ����װ��
     *  11      ��ҩ
     */
    private static final int [] MARKETGROUPLIST ={1857,499,1332,1861,1033,860,4,9,11};
    public static void initEitConfig(){
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

        //--------------------------------
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
}
