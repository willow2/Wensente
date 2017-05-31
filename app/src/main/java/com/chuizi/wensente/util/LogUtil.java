package com.chuizi.wensente.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * @author jiaolj
 *
 */
public class LogUtil {

	/**
	 * @param tag
	 * @param msg
	 */
	public static void showLog(String tag,String msg)
	{
		Log.e(tag, msg);
	}
	/**
	 * @param tag
	 * @param msg
	 */
	public static void showLog(Class<?> tag,String msg)
	{
		Log.e(tag.getName(), msg);
	}

	/**
	 * @param msg
	 */
	public static void showPrint(String msg)
	{

		System.out.println(msg);

	}
	/**
	 * @param msg
	 */
	public static void showToastMsg(Context context, String msg)
	{

		Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();

	}
}
