package com.chuizi.wensente.util;

import android.content.Context;
import android.location.LocationManager;

import com.baidu.location.BDLocation;
import com.chuizi.healthJS.map.MyBDLocationListener;
import com.chuizi.healthJS.model.LocationInfoBean;

/**
 * Created by Administrator on 2017/2/22 0022.
 */

public class LocationUtil {

    /**
     * 位置管理
     */
    public static LocationManager lm = null;
    /**
     * 位置监听类
     */
    public static MyBDLocationListener baiDuLocationListener = null;
    /**
     * 位置信息
     */
    public static LocationInfoBean locationInfo_ = null;

    public  static void startBaiduLocation(Context context) {
        lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        baiDuLocationListener = MyBDLocationListener
                .getBDLocationListener(context.getApplicationContext());
        if (baiDuLocationListener != null) {
            baiDuLocationListener.startLocation();
        }
    }

    /**
     * 获取百度定位数据
     */
    public static LocationInfoBean getBaiduLocationResult(Context context) {

        locationInfo_ = LocationUtil.getLocationInfo(baiDuLocationListener,
                context, lm);

        if (locationInfo_ != null) {
            LogUtil.showLog("-------获取定位-------:",
                    locationInfo_.getLongitude() + locationInfo_.getLatitude()
                            + ",城市：" + locationInfo_.getCity());
        }

        return locationInfo_;
    }

    /**
     * 获取位置信息
     *
     * @param baiDuLocationListener
     * @param context
     * @param lm
     * @return
     */
    public static LocationInfoBean getLocationInfo(

            MyBDLocationListener baiDuLocationListener, Context context,
            LocationManager lm) {

        String moshi = "";
        String longitude = "0";
        String latitude = "0";
        int mnc = 0;
        int cid = 0;
        int lac = 0;
        String provice = "";
        String district = "";
        String city = "";

        LocationInfoBean locationInfo_ = new LocationInfoBean();


        if (baiDuLocationListener != null && baiDuLocationListener.bdlocation_ != null) {
            longitude = baiDuLocationListener.bdlocation_.getLongitude() + "";
            latitude = baiDuLocationListener.bdlocation_.getLatitude() + "";
            moshi = baiDuLocationListener.bdlocation_.getLocType() == 61 ? "0" : "1";
            city = baiDuLocationListener.bdlocation_.getCity();
            provice = baiDuLocationListener.bdlocation_.getProvince();
            district = baiDuLocationListener.bdlocation_.getDistrict();
        }

        locationInfo_.setMoshi(moshi);
        locationInfo_.setLongitude(longitude);
        locationInfo_.setLatitude(latitude);
        locationInfo_.setLac(lac + "");
        locationInfo_.setMnc(mnc + "");
        locationInfo_.setCid(cid + "");
        locationInfo_.setCity(city);
        locationInfo_.setDistrict(district);
        locationInfo_.setProvince(provice);
        locationInfo_.setDescribe(locationInfo(baiDuLocationListener.bdlocation_));

        return locationInfo_;
    }

    /***
     * 定位信息
     * @param location
     */
    private static String locationInfo(BDLocation location) {
        if (location == null) return "未获取到位置";
//		Map<String, Double> map = PositionUtil.gcj_To_Gps84(location.getLatitude(),
//				location.getLongitude());
        StringBuffer sb = new StringBuffer(256);
//		sb.append("time : ");
//		sb.append(location.getTime());
//		sb.append("\nerror code : ");
//		sb.append(location.getLocType());
//		sb.append("\nlatitude : ");
//		sb.append(location.getLatitude());
//		sb.append("\nlontitude : ");
//		sb.append(location.getLongitude());
//		sb.append("\nradius : ");
//		sb.append(location.getRadius());
//		sb.append("\naddr : ");
        sb.append(location.getAddrStr());

        return sb.toString();
    }

}
