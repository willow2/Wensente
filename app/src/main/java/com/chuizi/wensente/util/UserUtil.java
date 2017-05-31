package com.chuizi.wensente.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.chuizi.healthJS.model.UserBean;
import com.chuizi.healthJS.view.db.UserDBUtils;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;


public class UserUtil {

	public static boolean isLogin(Context context) {
		try {
			UserBean user2 = new UserDBUtils(context).getDbUserData();
			LogUtil.showLog("UserUtil.user2", user2.toString());
			LogUtil.showLog("UserUtil.isLogin_state", user2.isLogin_state()
					+ "");

			if (user2 == null || StringUtil.isNullOrEmpty(user2.getId() + "") || StringUtil.isNullOrEmpty(user2.getId() + "")
					|| !user2.isLogin_state()) {

				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public static boolean isPhone(Context context) {
		try {
			UserBean user2 = new UserDBUtils(context).getDbUserData();
			LogUtil.showLog("UserUtil.user2", user2.toString());
			LogUtil.showLog("UserUtil.isLogin_state", user2.isLogin_state()
					+ "");

			if (user2 == null || StringUtil.isNullOrEmpty(user2.getId() + "") || StringUtil.isNullOrEmpty(user2.getId() + "")
					|| !user2.isLogin_state()) {

				return false;
			}
			if(StringUtil.isNullOrEmpty(user2.getPhone())){
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public  static void inintJiPush( Context context) {
		JPushInterface.setDebugMode(false); // 设置开启日志,发布时请关闭日志

		if (JPushInterface.isPushStopped(context)) {
			LogUtil.showPrint("JPUSH resumePush");
			JPushInterface.resumePush(context);
		} else {
			JPushInterface.init(context); // 初始化 JPush
			LogUtil.showPrint("JPUSH init ");
		}
		if (isLogin(context)) {
			// 设置极光推送别名
			Set<String> tags = new HashSet<String>();
			UserBean user = new UserDBUtils(context).getDbUserData();
			tags.add("userId" + user.getId() + "");
			JPushInterface.setAliasAndTags(context,"userId"+user.getId(), tags,null);
//			JPushInterface.setAliasAndTags(context, "userId"+user.getId(), tags);
		}else{
			Set<String> tags = new HashSet<String>();
			UserBean user = new UserDBUtils(context).getDbUserData();
			tags.add("userId" + "0");
			JPushInterface.setAliasAndTags(context, "userId" +"0", tags,null);
		}
		LogUtil.showPrint("JPUSH init ACTION_REGISTRATION_ID "+JPushInterface.ACTION_REGISTRATION_ID);

	}

	public static String getAppVersionName(Context context) {  
	    String versionName = "";  
	    try {  
	        // ---get the package info---  
	        PackageManager pm = context.getPackageManager();  
	        PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);  
	        versionName = pi.versionName;  
	        if (versionName == null || versionName.length() <= 0) {  
	            return "";  
	        }  
	    } catch (Exception e) {  
	        Log.e("VersionInfo", "Exception", e);  
	    }  
	    return versionName;  
	}  
}
