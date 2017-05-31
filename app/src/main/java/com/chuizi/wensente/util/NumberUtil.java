package com.chuizi.wensente.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/3/15.
 */

public class NumberUtil {
//    /**
//     * 设置为整数
//     * @param num
//     * @return
//     */
//    public static String intNumber(double num){
//        try {
//            DecimalFormat df = new DecimalFormat("#0");
//            return df.format(num); // 总共大小
//        } catch (Exception e) {
//            // TODO: handle exception
//            return null;
//        }
//    }
//    /**
//     * 小数点后面一位
//     * @param num
//     * @return
//     */
//    public static String doubleOne(double num){
//        try {
//            DecimalFormat df = new DecimalFormat("#0.0");
//            df.setRoundingMode(RoundingMode.HALF_UP);
//            return df.format(num); // 总共大小
//        } catch (Exception e) {
//            // TODO: handle exception
//            return null;
//        }
//    }
//    /**
//     * 小数点后面两位
//     * @param num
//     * @return
//     */
//    public static String doubleTwo(double num){
//        try {
//            DecimalFormat df = new DecimalFormat("#0.00");
//            df.setRoundingMode(RoundingMode.HALF_UP);
//            return df.format(num); //
//        } catch (Exception e) {
//            // TODO: handle exception
//            return "";
//        }
//    }

    public static String money(String str){
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float folatStr=Float.valueOf(str);
        str=df.format(folatStr);
//        if(str.indexOf(".") > 0){
//            //正则表达
//            str = str.replaceAll("0+?$", "");//去掉后面无用的零
//            str = str.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
//        }

        return str;
    }
}
