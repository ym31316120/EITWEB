package com.mageeyang.eit.core.cache;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/4.
 */
public class EitConfigInfo {

    public static ArrayList<Integer> primitiveList = new ArrayList<Integer>();

    public static ArrayList<Integer> getPrimitiveList() {
        return primitiveList;
    }

    public static void setPrimitiveList(ArrayList<Integer> primitiveList) {
        EitConfigInfo.primitiveList = primitiveList;
    }
}
