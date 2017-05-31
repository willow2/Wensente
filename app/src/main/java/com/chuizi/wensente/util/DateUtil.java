package com.chuizi.wensente.util;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类
 *
 * @author jiaolj
 *
 */
public class DateUtil {

	public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public static String YYYY_MM_DD = "yyyy-MM-dd";

	public static String YYYYMMDDHHMM = "yyyyMMddHHmm";

	public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String YYYYNMMYDDRHHMMSS = "yyyy年MM月dd日HHmmss";

	/**
	 * 将Date日期转换为字符串日期
	 *
	 * @param date
	 *            转换日期
	 * @param format
	 *            转换格式
	 * @return 字符串日期
	 */
	public static String parseDate2Str(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 将string日期转换为指定格式的字符串日期
	 *
	 * @param date
	 *            转换日期
	 * @param format
	 *            转换格式
	 * @return 字符串日期
	 */
	public static String parseStr2Str(String date, String format) {
		if (null == date || "".equals(date)) {
			return "";
		}
		return parseDate2Str(parseStr2Date(date, format), format);
	}
	/**
	 * 将string日期转换为指定格式的字符串日期
	 *
	 * @param date
	 *            转换日期

	 *            转换格式
	 * @return 字符串日期
	 */
	public static String parseStr2YearMonth(String date) {
		if(StringUtil.isNullOrEmpty(date)){
			return "";
		}else{

			String endStr=date.substring(0, 8);
			StringBuffer buffer = new StringBuffer(endStr);
			buffer.replace(4, 5, "年");
			buffer.replace(7, 8, "月");
			return buffer.toString();
		}
	}
	/**
	 * 将string日期转换为指定格式的字符串日期
	 *
	 * @param date
	 *            转换日期

	 * @return 字符串日期
	 */
	public static String parseStr2Xie(String date) {
		if(StringUtil.isNullOrEmpty(date)){
			return "";
		}else{

			String endStr=date.substring(0, 10);
			StringBuffer buffer = new StringBuffer(endStr);
			buffer.replace(4, 5, "/");
			buffer.replace(7, 8, "/");
			return buffer.toString();
		}
	}

	/**
	 * 将Date日期转换为字符串日期
	 *

	 * @return 字符串日期
	 */
	public static Date parseStr2Date(String dateStr, String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * 返回指定时间字符串。
	 * <p>
	 * 格式：yyyy-MM-dd HH:mm:ss
	 *
	 * @return String 指定格式的日期字符串.
	 */
	public static String getDateTime(long microsecond, String format) {
		return parseDate2Str(new Date(microsecond), format);
	}

	/**
	 * 比较两个字符串时间大小
	 *
	 * @param sDate1
	 * @param sDate2
	 * @return
	 */
	public static int compare_date(String sDate1, String sDate2) {

//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date dt1 = df.parse(sDate1);
			Date dt2 = df.parse(sDate2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt2小于dt1");
				return -1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt2大于dt1");
				return 1;
			} else {
				// System.out.println("dt1==dt2");
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	/**
	 * 比较两个字符串时间大小前大于后
	 *
	 * @param sDate1
	 * @param sDate2
	 * @return
	 */
	public static boolean compareOneDaTwo(String sDate1, String sDate2) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			Date dt1 = df.parse(sDate1);
			Date dt2 = df.parse(sDate2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt2小于dt1");
				return true;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt2大于dt1");
				return false;
			} else {
				// System.out.println("dt1==dt2");
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * 位置时间是否有效
	 *
	 * @param time
	 *            时间（毫秒）
	 * @param minute
	 *            分钟
	 * @return
	 */
	public static boolean IsValid(long time, int minute) {
		Date date = new Date();
		long now = date.getTime();

		if ((now - time) > (60 * 1000 * minute)) {
			return false;
		}
		return true;
	}

	/**
	 * 获得当前时间
	 *
	 * @return
	 */
	public static String getCurrentTime() {
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		str = formatter.format(curDate);
		return str;
	}

	/**
	 * 获得当前时间年月日
	 *
	 * @return
	 */
	public static String getCurrentDate() {
		String str = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间

		str = formatter.format(curDate);
		return str;
	}

	/**
	 * 比较两个字符串时间大小
	 *
	 * @param sDate1
	 * @param sDate2
	 * @return
	 */
	public static int compare_dateAll(String sDate1, String sDate2) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(sDate1);
			Date dt2 = df.parse(sDate2);
			if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("dt2小于dt1");
				return -1;
			} else if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("dt2大于dt1");
				return 1;
			} else {
				// System.out.println("dt1==dt2");
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 *
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx秒
	 */
	public static String getDistanceTime(String str1, String str2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = ((diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60) - min * 60);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		String str="";
		if(min<10){
			str+="0"+min;
		}else{
			str+=""+min;
		}
		str+=":";
		if(sec<10){
			str+="0"+sec;
		}else{
			str+=""+sec;
		}
//		return day + "天" + hour + "小时" + min + "分" + sec + "秒";
		return str ;
	}
	/**
	 * long类型转化为00：00
	 */
	public static String getYMRHMS(long diff) {

		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;

			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = ((diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60) - min * 60);

		String str="";
//		if(day>0){
//			if(day<10){
//
//			}
//		}
		if(min<10){
			str+="0"+min;
		}else{
			str+=""+min;
		}
		str+=":";
		if(sec<10){
			str+="0"+sec;
		}else{
			str+=""+sec;
		}
		return str ;
	}
	/**
	 *获取系统时间
	 */
	public static long getTime(String str1,String formatStr) {
		SimpleDateFormat df = new SimpleDateFormat(formatStr);
		Date one;
		long time1=0;
		try {
			one = df.parse(str1);
			time1 = one.getTime();
			long diff;


		} catch (ParseException e) {
			e.printStackTrace();
		}

		return time1 ;
	}

	/**
	 * 当前日期加几天
	 *
	 * @param startdate
	 * @param i
	 * @throws ParseException
	 */
	public static String addDate(String startdate, int i) {

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(startdate);
			Calendar cld = Calendar.getInstance();

			cld.setTime(date);

			cld.add(5, i);

			str = sdf.format(cld.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}
	/**
	 * 当前日期加几小时
	 *
	 * @param startdate
	 * @param i
	 * @throws ParseException
	 */
	public static String addDateHour(String startdate, int i) {

		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(startdate);
			Calendar cld = Calendar.getInstance();

			cld.setTime(date);

			cld.add(Calendar.HOUR_OF_DAY, i);

			str = sdf.format(cld.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 当前日期加几分钟
	 *
	 * @param startdate
	 * @param i
	 * @throws ParseException
	 */
	public static Date addDateMinute(String startdate, int i) {

		Date str = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = sdf.parse(startdate);
			Calendar cld = Calendar.getInstance();

			cld.setTime(date);

			cld.add(Calendar.MINUTE, i);

			str = cld.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 获取日期相差天数
	 *
	 * @param
	 * @return 日期类型时间
	 * @throws ParseException
	 */
	public static Long getDiffDay(String beginDate, String endDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Long checkday = 0l;
		// 开始结束相差天数
		try {
			checkday = (formatter.parse(endDate).getTime() - formatter.parse(
					beginDate).getTime())
					/ (1000 * 24 * 60 * 60);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			checkday = null;
		}
		return checkday;
	}

	/*
     * 将时间戳转换为时间
     */
	public static String stampToDate(long s){
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(s);
		res = simpleDateFormat.format(date);
		return res;
	}

	/*
     * 将时间戳转换为date
     */
	public static Date longToDate(long s){
		Date time;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(s);
		String str = simpleDateFormat.format(date);
		try {
			time = simpleDateFormat.parse(str);
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 比较两个字符串时间大小
	 *
	 * @param sDate1
	 * @param sDate2
	 * @return
	 */
	public static int compare_dateSize(Date sDate1, ArrayList<CalendarDay> sDate2) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			for (int i = 0; i < sDate2.size(); i++) {
				if (sDate1.getTime() == sDate2.get(i).getDate().getTime()) {
					// System.out.println("dt2小于dt1");
					return 0;

				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 1;
	}

	/**
	 * 时间差
	 * @param nowtime
	 * @param endtime
     * @return
     */
	public static long timeDifference(String nowtime, String endtime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long diff = 0;
		try {
			//系统时间转化为Date形式
			Date dstart = format.parse(nowtime);
			//订单时间转化为Date形式
			Date dend = DateUtil.addDateMinute(endtime,10);
			//算出时间差，用ms表示
			diff = dend.getTime() - dstart.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//返回时间差
		return diff;
	}

}
