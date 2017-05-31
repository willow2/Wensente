package com.chuizi.wensente.widget;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonUtil {

	private static Gson gson = new Gson();

	public static Gson getGson() {
		return new Gson();
	}


	/**
	 * json转换为map
	 *
	 * @param json
	 * @return
	 */
	public static Map getMap(String json) {
		return new Gson().fromJson(json, Map.class);
	}

	public static String getJson(Object src) {
		return new Gson().toJson(src);
	}
	/**
	 * 获取轮播图列表
	 * @param json
	 * @return
	 */
//	public static List getScrollAdBeanList(String json) {
//		// gson.fromJson(json,new TypeToken<List<RegionBean>>() { }.getType());
//
//		return new Gson().fromJson(json, new TypeToken<List<ScrollAdBean>>() {
//		}.getType());
//
//	}
//	/**
//	 * json转换为list
//	 * 
//	 * @param json
//	 * @return
//	 */
//	public static List getList(String json) {
//		return new Gson().fromJson(json, List.class);
//	}
//	public static ResultMapBean getMapString(String json) {
//
//		ResultMapBean bean = null;
//		try {
//			JSONObject jsonObject = new JSONObject(json);
//			bean = new ResultMapBean();
//			
//			bean.setResultcode(jsonObject.has("resultcode")?jsonObject.getString("resultcode"):"");
//			bean.setReason(jsonObject.has("reason")?jsonObject.getString("reason"):"");
//			bean.setResult(jsonObject.has("result")?jsonObject.getString("result"):"");
//			bean.setError_code(jsonObject.has("error_code")?jsonObject.getInt("error_code"):0);
//
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return bean;
//	}

















}
