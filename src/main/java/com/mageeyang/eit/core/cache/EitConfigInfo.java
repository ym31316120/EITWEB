package com.mageeyang.eit.core.cache;

import com.mageeyang.eit.db.bean.BluePrintInfo;
import com.mageeyang.eit.db.model.InvmarketgroupsEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/1/4.
 */
public class EitConfigInfo {
    //星系收取的制造税及交易税总和
    public static final BigDecimal TAX = new BigDecimal(0.05);
    //人物的技能提供的发明成功率
    public static final BigDecimal IVENT_PROBABITY = new BigDecimal(0.1);
    //用于一次从eve-centrol获取价格的数据条数
    public static final int COW_NUM = 50;
    //用于获取价格的url前缀地址
    public static final String URL_BEGIN = "http://api.eve-central.com/api/marketstat/json?usesystem=30000142&typeid=";
    //用于获取价格的星系ID
    public static final String USE_SYSTEM = "30000142";
    //用于存放原材料的marketGroupId列表
    private static ArrayList<Integer> primitiveList = new ArrayList<Integer>();
    //用于存放处理好的原材料的TypeID拼接字符串的列表
    private static ArrayList<String> typeslist = new ArrayList<String>();
    //用于存放蓝图的marketgroup树形结构列表
    private static ArrayList<InvmarketgroupsEntity> bluemarketgroups = new ArrayList<InvmarketgroupsEntity>();
    //用于存放处理好的蓝图信息
    private static HashMap<Integer,BluePrintInfo> bluePrintInfoHashMap = new HashMap<Integer, BluePrintInfo>();

    private static ArrayList<Integer> bpMarketGroupids = new ArrayList<Integer>();

    public static ArrayList<String> getTypeslist() {
        return typeslist;
    }

    public static void setTypeslist(ArrayList<String> typeslist) {
        EitConfigInfo.typeslist = typeslist;
    }

    public static ArrayList<Integer> getPrimitiveList() {
        return primitiveList;
    }

    public static void setPrimitiveList(ArrayList<Integer> primitiveList) {
        EitConfigInfo.primitiveList = primitiveList;
    }

    public static HashMap<Integer, BluePrintInfo> getBluePrintInfoHashMap() {
        return bluePrintInfoHashMap;
    }

    public static void setBluePrintInfoHashMap(HashMap<Integer, BluePrintInfo> bluePrintInfoHashMap) {
        EitConfigInfo.bluePrintInfoHashMap = bluePrintInfoHashMap;
    }

    public static ArrayList<InvmarketgroupsEntity> getBluemarketgroups() {
        return bluemarketgroups;
    }

    public static void setBluemarketgroups(ArrayList<InvmarketgroupsEntity> bluemarketgroups) {
        EitConfigInfo.bluemarketgroups = bluemarketgroups;
    }

    public static ArrayList<Integer> getBpMarketGroupids() {
        return bpMarketGroupids;
    }

    public static void setBpMarketGroupids(ArrayList<Integer> bpMarketGroupids) {
        EitConfigInfo.bpMarketGroupids = bpMarketGroupids;
    }
}
