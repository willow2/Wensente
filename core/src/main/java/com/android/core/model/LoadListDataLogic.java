package com.android.core.model;

import com.android.core.base.BaseView;

import retrofit2.Response;

/**
 * @author: 蜡笔小新
 * @date: 2016-08-01 15:34
 * @GitHub: https://github.com/meikoz
 */
public interface LoadListDataLogic<T> {
    void onLoadComplete(Response<T> response);

    void onFailer(String msg);

    interface LoadListView<T> extends BaseView {
        void onLoadCompleteData(T body);

        void onLoadComplete();
    }
}
