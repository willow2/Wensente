package com.chuizi.wensente.util;

 


import android.content.Context;
import android.content.SharedPreferences;

import com.chuizi.healthJS.AppApplication;


public class PreferencesManager {
	private static PreferencesManager instance_ = new PreferencesManager(
			AppApplication.getInstance());
	private Context context_;

	private final String PREFERENCE_NAME = "plife_preference";

	private PreferencesManager(Context context) {
		this.context_ = context;
	}

	public static PreferencesManager getInstance() {
		return instance_;
	}

/*
	public void saveUser(UserBean user) {
		if (user != null) {
			putString("user_id", user.getId_());
			putString("user_phone", user.getPhone_());
			putString("user_imsi", Util.getImsi());
			putString("user_score", user.getScore_());
			putString("user_alias", user.getAlias_());
			putString("user_sign", user.getSign_());
			putString("user_city", user.getCity_());
			putString("user_vip", user.getVip_());
			putBoolean("user_isRegister", user.isRegister_());
			putString("user_add", user.getAddress_());
			putString("user_headimg", user.getHead_img());
			putBoolean("user_isLogin", user.isLogin_state());
		}
	}

	*//**
	 * 
	 * @return
	 *//*
	public UserBean getUser() {
		UserBean _user = new UserBean();
		_user.setId_(getString("user_id", ""));
		_user.setPhone_(getString("user_phone", ""));
		_user.setImsi_(getString("user_imsi", ""));
		_user.setScore_(getString("user_score", ""));
		_user.setAlias_(getString("user_alias", ""));
		_user.setSign_(getString("user_sign", ""));
		_user.setCity_(getString("user_city", ""));
		_user.setVip_(getString("user_vip", ""));
		_user.setAddress_(getString("user_add", ""));
		_user.setHead_img(getString("user_headimg", ""));
		_user.setRegister_(getBoolean("user_isRegister", false));
		_user.setLogin_state(getBoolean("user_isLogin", false));
		return _user;
	}*/
	public void clearData(String s) {
		context_.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
				.edit().remove(s).commit();

	}
	public boolean putInt(String key, int value) {
		boolean flag = context_
				.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
				.edit().putInt(key, value).commit();
		return flag;
	}

	public int getInt(String key, int defValue) {
		return context_.getSharedPreferences(PREFERENCE_NAME,
				Context.MODE_PRIVATE).getInt(key, defValue);
	}

	public boolean putLong(String key, long value) {
		boolean flag = context_
				.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
				.edit().putLong(key, value).commit();
		return flag;
	}

	public long getLong(String key, long defValue) {
		return context_.getSharedPreferences(PREFERENCE_NAME,
				Context.MODE_PRIVATE).getLong(key, defValue);
	}

	public boolean putString(String key, String value) {
		boolean flag = context_
				.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
				.edit().putString(key, value).commit();
		return flag;
	}

	public String getString(String key, String defValue) {
		
		 
		return context_.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE).getString(key, defValue);
		 
	}
	public void setFirstTime(boolean firsttime) {
		putBoolean("firsttime", firsttime);

	}

	public boolean getFirstTime() {

		return getBoolean("firsttime", true);
	}
	public boolean putBoolean(String key, boolean value) {
		boolean flag = context_
				.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
				.edit().putBoolean(key, value).commit();
		return flag;
	}

	public boolean getBoolean(String key, boolean defValue) {
		// LogUtil.showPrint("canshu inner before::::");
		return context_.getSharedPreferences(PREFERENCE_NAME,
				Context.MODE_PRIVATE).getBoolean(key, defValue);

	}
	public String getHomeCity() {
		SharedPreferences spf = context_.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
		return spf.getString("homecity", "");
	}
	public void setHomeCity(String city) {
		SharedPreferences spf = context_.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = spf.edit();
		editor.putString("homecity", city);
		editor.commit();
	}
	
	public boolean isShowMessage(){
		return  getBoolean("message", true);
	}
	public void chageMessageSetting(){
		putBoolean("message", !getBoolean("message", true));
	}
	
 
}
