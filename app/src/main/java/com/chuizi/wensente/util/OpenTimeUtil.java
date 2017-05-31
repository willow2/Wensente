package com.chuizi.wensente.util;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class OpenTimeUtil {

    public static ArrayList<String> Times(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 24; i+=2) {
            if (i < 10) {
                list.add("0"+i+":00");
            }else{
                list.add(String.valueOf(i)+":00");
            }
        }
        return list;
    }

    public static ArrayList<String> Min(){
        ArrayList<String> list = new ArrayList<>();
        list.add("至");
        return list;
    }
}
