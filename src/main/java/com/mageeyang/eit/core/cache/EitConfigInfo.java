package com.mageeyang.eit.core.cache;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/4.
 */
public class EitConfigInfo {

    public static final int COW_NUM = 50;

    public static final String URL_BEGIN = "http://api.eve-central.com/api/marketstat/json?usesystem=30000142&typeid=";

    private static ArrayList<Integer> primitiveList = new ArrayList<Integer>();

    private static ArrayList<String> typeslist = new ArrayList<String>();

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
}
