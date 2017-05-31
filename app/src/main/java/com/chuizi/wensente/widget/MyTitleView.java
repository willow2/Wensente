package com.chuizi.wensente.widget;


import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chuizi.wensente.R;

/**
 * @author wangjie
 * @date 2013-8-8涓嬪崍02:55:01
 * @version 1.0 TODO锟?
 */

public class MyTitleView extends LinearLayout {
	TextView iv_left;
	public TextView iv_right;
	public TextView tv_title, count_tv;
	RelativeLayout top_title;
	Context mContext;
	LeftBtnListener leftBtnListener;
	RightBtnListener rightBtnListener;
	Right2BtnListener right2BtnListener;
	public TextView iv_right2;
	public TextView tv_right_jiaobiao;
	public TextView tv_right2_jiaobiao;
	private View lines;

	private final static int LEFT_BUTTON = 0;
	private final static int RIGHT_BUTTON = 1;

	public MyTitleView(final Context context) {
		super(context);
		mContext = context;
		init();
	}

	public MyTitleView(final Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		context.getTheme();

		init();
	}

	public void init() {
		// setOrientation(LinearLayout.HORIZONTAL);
		LayoutInflater mInflater = LayoutInflater.from(mContext);
		View view = mInflater.inflate(R.layout.my_title_view, null);
		iv_left = (TextView) view.findViewById(R.id.iv_left);
		iv_right = (TextView) view.findViewById(R.id.iv_right);
		iv_right2 = (TextView) view.findViewById(R.id.iv_right2);
		tv_right_jiaobiao = (TextView) view
				.findViewById(R.id.tv_right_jiaobiao);
		tv_right2_jiaobiao = (TextView) view
				.findViewById(R.id.tv_right2_jiaobiao);
		tv_title = (TextView) view.findViewById(R.id.tv_title);
		count_tv = (TextView) view.findViewById(R.id.count_tv);
		top_title = (RelativeLayout) view.findViewById(R.id.top_title);

		lines = (View) view.findViewById(R.id.lines);

		iv_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (leftBtnListener != null) {
					leftBtnListener.onLeftBtnClick();
				}
			}
		});

		iv_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (rightBtnListener != null) {
					rightBtnListener.onRightBtnClick();
				}
			}
		});
		iv_right2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (right2BtnListener != null) {
					right2BtnListener.onRight2BtnClick();
				}
			}
		});

		addView(view, new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

	}

	/**
	 * 设置背景为红色
	 *
	 * @param type
	 */
	public void setBgColor(int type) {// 默认白底黑字
		Resources resource = (Resources) mContext.getResources();
		ColorStateList white = (ColorStateList) resource
				.getColorStateList(R.color.white);
		ColorStateList title_black = (ColorStateList) resource
				.getColorStateList(R.color.black);
		ColorStateList main = (ColorStateList) resource
				.getColorStateList(R.color.main);

		switch (type) {
			case 1:// 绿底白字
				top_title.setBackgroundResource(R.color.buttonColor);
				tv_title.setTextColor(white);
				iv_left.setTextColor(white);
				iv_right.setTextColor(white);
				iv_right2.setTextColor(white);
				lines.setVisibility(View.GONE);
				break;
			case 2:// 白底黑字有线
				top_title.setBackgroundResource(R.color.white);
				tv_title.setTextColor(title_black);
				iv_left.setTextColor(title_black);
				iv_right.setTextColor(title_black);
				iv_right2.setTextColor(title_black);
				lines.setVisibility(View.VISIBLE);

				break;
			case 3:// 白底黑字无线
				top_title.setBackgroundResource(R.color.white);
				tv_title.setTextColor(title_black);
				iv_left.setTextColor(title_black);
				iv_right.setTextColor(title_black);
				iv_right2.setTextColor(title_black);
				lines.setVisibility(View.GONE);

				break;
			case 4:// 白底红字
				top_title.setBackgroundResource(R.color.white);
				tv_title.setTextColor(main);
				iv_left.setTextColor(main);
				iv_right.setTextColor(main);
				iv_right2.setTextColor(main);
				lines.setVisibility(View.VISIBLE);
				break;

			default:
				break;
		}
	}

	// 璁剧疆鏂规硶
	public void setTitle(String title) {
		if (title != null) {
			tv_title.setText(title);
		}
	}

	public void setTv_right_jiaobiaoText(String title) {
		if (tv_right_jiaobiao != null) {
			tv_right_jiaobiao.setText(title);
		}
	}

	public void setTv_right2_jiaobiaoText(String title) {
		if (tv_right2_jiaobiao != null) {
			tv_right2_jiaobiao.setText(title);
		}
	}

	public void setTv_right_jiaobiaoVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		tv_right_jiaobiao.setVisibility(visibility);
	}

	public void setTv_right2_jiaobiaoVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		tv_right2_jiaobiao.setVisibility(visibility);
	}

	public void setTitleSize(float size) {
		if (size != 0) {
			tv_title.setTextSize(size);
		}
	}

	public void setCount(String count) {
		if (count != null) {
			count_tv.setText(count);
		}
	}

	public void setTitleTextColor(int color) {
		tv_title.setTextColor(color);
	}

	public void setTitle(int title) {
		if (title > 0) {
			tv_title.setText(title);
		}
	}

	public void setLeftBackGround(int res) {
		if (iv_left != null) {
			iv_left.setBackgroundResource(res);
		}
	}

	public void setMiddleBackGround(int res) {
		if (tv_title != null) {
			tv_title.setBackgroundResource(res);
		}
	}

	public void setRightBackGround(int res) {
		if (iv_right != null) {
			iv_right.setBackgroundResource(res);
		}
	}

	public void setRight2BackGround(int res) {
		if (iv_right2 != null) {
			iv_right2.setBackgroundResource(res);
		}
	}

	public void setRightText(String text) {
		if (iv_right != null) {
			iv_right.setText(text);
		}
	}

	public void setRight2Text(String text) {
		if (iv_right2 != null) {
			iv_right2.setText(text);
		}
	}

	public void setTopTitleGround(int res) {
		if (top_title != null) {
			top_title.setBackgroundResource(res);
		}
	}

	public void setLeftButtonVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		iv_left.setVisibility(visibility);
	}

	public void setCountVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		count_tv.setVisibility(visibility);
	}

	public void setRightButtonVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		iv_right.setVisibility(visibility);
	}

	public void setRight2ButtonVisibility(int visibility) {
		if (visibility == View.GONE) {
			visibility = View.INVISIBLE;
		}
		iv_right2.setVisibility(visibility);
	}

	public interface LeftBtnListener {
		public void onLeftBtnClick();
	}

	public LeftBtnListener getLeftBtnListener() {
		return leftBtnListener;
	}

	public void setLeftBtnListener(LeftBtnListener leftBtnListener) {
		this.leftBtnListener = leftBtnListener;
	}

	public interface RightBtnListener {
		public void onRightBtnClick();
	}

	public RightBtnListener getRightBtnListener() {
		return rightBtnListener;
	}

	public void setRightBtnListener(RightBtnListener rightBtnListener) {
		this.rightBtnListener = rightBtnListener;
	}

	public interface Right2BtnListener {
		public void onRight2BtnClick();
	}

	public Right2BtnListener getRight2BtnListener() {
		return right2BtnListener;
	}

	public void setRight2BtnListener(Right2BtnListener right2BtnListener) {
		this.right2BtnListener = right2BtnListener;
	}

}
