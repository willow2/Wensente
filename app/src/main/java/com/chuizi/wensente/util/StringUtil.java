package com.chuizi.wensente.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class StringUtil {
	/**
	 * 判断是否手机号
	 * @param phones
	 * @return
	 */
	public static boolean isPhoneNum(String phones){
		if(TextUtils.isEmpty(phones)){
			return false;
		}
		phones = phones.replaceAll("，", ",");
		String[] phoneAarry = phones.split(",");
		for(String phone : phoneAarry){
			if(TextUtils.isEmpty(phone)){
				continue;
			}
			if(phone.length()!=11){
				return false;
			}
		}
		return true;
	}

	/**
	 * 检查手机号是否合法
	 * @param context
	 * @param phones
	 * @return
	 */
	public static boolean checkPhone(Context context, String phones){
		if(TextUtils.isEmpty(phones)){
			Toast.makeText(context, "请输入手机号", Toast.LENGTH_LONG).show();
			return false;
		}
		phones = phones.replaceAll("，", ",");
		String[] phoneAarry = phones.split(",");
		for(String phone : phoneAarry){
			if(TextUtils.isEmpty(phone)){
				continue;
			}
			if(phone.length()!=11){
				Toast.makeText(context, "手机号" + phone + "长度不正确", Toast.LENGTH_LONG).show();
				return false;
			}
//			if(!Util.isUnicom(phone)){
//				Toast.makeText(context, "手机号" + phone + "非联通", Toast.LENGTH_LONG).show();
//				return false;
//			}
		}
		return true;
	}
	/**
	 * 验证字符串是否符合手机号格式
	 *
	 * @param str
	 *            需要验证的字符串
	 * @return 不是手机号返回false，是手机号就返回true
	 */
	public static boolean isMobile(String str) {

		return str != null && str.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
	}
	/**
	 * 判断是否为null或空值
	 *
	 * @param str String
	 * @return true or false
	 */
	public static boolean isNullOrEmpty(String str)
	{
		return str == null || str.trim().length() == 0 || str.toLowerCase().equals("null")|| str.trim().equals("");
	}


	/**
	 * 截取第一个字符串
	 * @return
	 */
	public static String getImageFirst(String url){
		if(url==null){
			return "";
		}
		return url.split(";")[0];
	}
	/**
	 * 根据;截取字符串变成list集合
	 * @return
	 */
	public static List<String> getListStr(String str){
		List<String> list=new ArrayList<String>();

		if(!StringUtil.isNullOrEmpty(str)){
			if(str.contains(";")){
				String[] strArr=str.split(";");
				if(strArr!=null&&strArr.length>0){
					for (int i=0;i<strArr.length;i++){
						list.add(strArr[i]);
					}
				}else{
					list.add(str);
				}
			}else{
				list.add(str);
			}
		}
		return list;
	}
}
