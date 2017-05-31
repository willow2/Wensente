package com.android.core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.Window;

import com.android.core.control.ScreenUtil;
import com.android.core.control.ToastUtil;
import com.android.core.model.LogicProxy;
import com.android.core.widget.dialog.DialogManager;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * @author: 蜡笔小新
 * @date: 2016-05-26 17:17
 * @GitHub: https://github.com/meikoz
 */
public abstract class AbsBaseActivity extends FragmentActivity implements BaseView {

    public int displayWidth;
    public int displayHeight;

    protected Context mContext = null;//context
    protected BasePresenter mPresenter;
    protected abstract void handleMsg(Message msg);
    protected Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {

                default:
                    break;
            }
            handleMsg(msg);
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = this;
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        onInitView();

        displayWidth = ScreenUtil.getScreenWidth(this);
        displayHeight = ScreenUtil.getScreenHeight(this);
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitView();

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        // 打开Activity动画
    }

    //获得该页面的实例
    public <T> T getLogicImpl(Class cls, BaseView o) {
        return LogicProxy.getInstance().bind(cls, o);
    }

    @Override
    public void finish() {
        super.finish();
        // 关闭动画
        hideProgress();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public void showMessage(String msg) {
        ToastUtil.show(msg);
    }

    public void showProgress(String message) {
        DialogManager.showProgressDialog(mContext, message);
    }

    @Override
    public void showProgress(String message, int progress) {
        DialogManager.showProgressDialog(mContext, message, progress);
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
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (isReturn) {
            startActivityForResult(intent, requestCode);
        } else {
            startActivity(intent);
        }
        if (isFinish) {
            finish();
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
