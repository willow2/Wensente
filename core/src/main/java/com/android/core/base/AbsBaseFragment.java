package com.android.core.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.core.control.ToastUtil;
import com.android.core.control.logcat.Logcat;
import com.android.core.model.LogicProxy;
import com.android.core.widget.dialog.DialogManager;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * @author: 蜡笔小新
 * @date: 2016-05-26 17:19
 * @GitHub: https://github.com/meikoz
 */
public abstract class AbsBaseFragment extends Fragment implements BaseView {

    public Display currDisplay;
    public int displayWidth;
    public int displayHeight;

    protected BasePresenter mPresenter;
    protected Context mContext;
    protected abstract void handleMsg(Message msg);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getLayoutResource() != 0) {
            return inflater.inflate(getLayoutResource(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
    protected Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {

                default:
                    break;
            }
            // dismissProgressDialog();
            handleMsg(msg);
        };
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logcat.d("Fragment Location (%s.java:0)", getClass().getSimpleName());
        mContext = getActivity();
        currDisplay = (getActivity()).getWindowManager().getDefaultDisplay();// 获取屏幕当前分辨率
        displayWidth = currDisplay.getWidth();
        displayHeight = currDisplay.getHeight();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onInitView();
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitView();


    //获得该页面的实例
    public <T> T getLogicImpl(Class cls, BaseView o) {
        return LogicProxy.getInstance().bind(cls, o);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(msg);
    }

    @Override
    public void showProgress(String msg) {
        DialogManager.showProgressDialog(mContext, msg);
    }

    @Override
    public void showProgress(String msg, int progress) {
        DialogManager.showProgressDialog(mContext, msg, progress);
    }

    @Override
    public void hideProgress() {
        DialogManager.hideProgressDialog();
    }

    @Override
    public void showErrorMessage(String msg, String content) {
        DialogManager.showErrorDialog(mContext, msg, content, new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismissWithAnimation();
            }
        });
    }

    /**
     * 跳转到其他界面
     *
     * @param cls
     *            跳转页面
     * @param bundle
     *            Bundle参数
     * @param isReturn
     *            是否返回
     * @param requestCode
     *            请求Code
     * @param isFinish
     *            是否销毁当前页面
     */
    protected void jumpToPage(Class<?> cls, Bundle bundle, boolean isReturn,
                              int requestCode, boolean isFinish) {
        if (cls == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (isReturn) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
        if (isFinish) {
            getActivity().finish();
        }
    }

    /**
     * 跳转到其他界面
     *
     * @param cls
     *            跳转页面
     * @param bundle
     *            Bundle参数
     * @param isFinish
     *            是否销毁当前页面
     */
    public void jumpToPage(Class<?> cls, Bundle bundle, boolean isFinish) {
        jumpToPage(cls, bundle, false, 0, isFinish);
    }

    /**
     * 跳转到其他界面，不销毁当前页面，也不传参数
     *
     * @param cls
     *            跳转页面
     */
    protected void jumpToPage(Class<?> cls) {
        jumpToPage(cls, null, false, 0, false);
    }



}
