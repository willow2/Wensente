package com.chuizi.wensente.util;

import android.content.Context;

/**
 *
 * @author wangst
 * @created 2013-08-02
 */
public class UIUtil {
	public static int px2dip(Context context, float f) {
		return (int) (0.5F + f
				/ context.getResources().getDisplayMetrics().density);
	}

	public static int dip2px(Context context, float f) {
		return (int) (0.5F + f
				* context.getResources().getDisplayMetrics().density);
	}
}
