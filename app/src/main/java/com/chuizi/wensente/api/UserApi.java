package com.chuizi.wensente.api;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.core.control.ToastUtil;
import com.chuizi.healthJS.model.AppParamsBean;
import com.chuizi.healthJS.model.CommonParameterBean;
import com.chuizi.healthJS.model.NewsResponse;
import com.chuizi.healthJS.model.UserBean;
import com.chuizi.healthJS.util.DateUtil;
import com.chuizi.healthJS.util.LogUtil;
import com.chuizi.healthJS.util.Urls;
import com.chuizi.healthJS.util.UserUtil;
import com.chuizi.healthJS.util.Util;
import com.chuizi.healthJS.util.rsa.Des3;
import com.chuizi.healthJS.view.activity.LoginActivity;
import com.chuizi.healthJS.view.activity.cache.NewsCallback;
import com.chuizi.healthJS.view.db.AppParamsDBUtils;
import com.chuizi.healthJS.view.db.CommonParamsDBUtils;
import com.chuizi.healthJS.view.db.UserDBUtils;
import com.chuizi.healthJS.widget.GsonUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 用户信息操作接口
 *
 * @author miaoxl
 * @created 2015-01-07
 */
public class UserApi {
    static Message msg_ = null;

    /**
     * 公共參數接口
     *
     * @param handler
     * @param context
     * @param type
     * @param map
     * @param mapOther
     * @param url
     */
    public static void postMethod(final Handler handler,
                                  final Context context, final int type, Map map, Map mapOther, final String url) {
        HttpParams params = new HttpParams();
        if (url.equals(Urls.REGISTER) || url.equals(Urls.USER_UPDATE) || url.equals(Urls.SAVE_FEEDBACK) || url.equals(Urls.LOGIN_UMENG)
                || url.equals(Urls.PUBLISH_POSTER) || url.equals(Urls.PUBLISH_VEDIO) || url.equals(Urls.PUBLISH_CARD)
                || url.equals(Urls.MONEY_SAVE)  || url.equals(Urls.USER_COLLECT)
                || url.equals(Urls.USER_ATTENTION) || url.equals(Urls.PAY)) {
            params.put("osType", "android");
        }

        JSONObject jsonObject = new JSONObject();
        try {
            Date date = new Date();
            String time = DateUtil.parseDate2Str(date, DateUtil.YYYYMMDDHHMMSS);
            jsonObject.put("T", "" + time);

            if (UserUtil.isLogin(context)) {
                UserBean user = new UserDBUtils(context).getDbUserData();
                jsonObject.put("tecSessionId", "" + user.getId());
            }

//				if (map != null) {
//
//					for (Object key : map.keySet()) {
//						jsonObject.put(key.toString(), map.get(key).toString());
//					}
//				}
            String jsonStr = jsonObject.toString();
            LogUtil.showPrint("加密前的数据:" + url + jsonStr);
            String signStr = Util.signPublic(jsonStr, Util.publicKeyNew);
            params.put("signCode", signStr);
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (map != null) {

            for (Object key : map.keySet()) {
                params.put(key.toString(), map.get(key).toString());
            }
        }
//        if (mapOther != null) {
//            for (Object key : mapOther.keySet()) {
//                params.put(key.toString(), mapOther.get(key).toString());
//            }
//        }
        OkGo.get(url)
                .params(params)//未加密参数
//					.params("sign", signStr)
//					.params(other_key, other_value)
//					.params("page", 1)                              //初始化或者下拉刷新,默认加载第一页
//                .cacheKey("TabFragment_" + fragmentTitle)       //由于该fragment会被复用,必须保证key唯一,否则数据会发生覆盖
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)  //缓存模式先使用缓存,然后使用网络数据
                .execute(new NewsCallback<NewsResponse<String>>() {
                    @Override
                    public void onSuccess(NewsResponse<String> result, Call call, Response response) {
                        String newsModel = result.getData();
                        if (result != null) {
                            if (result.getStatus().equals("success") && result.getStatusCode().equals("200")) {

                                if (result.getData() != null) {
                                    try {
                                        result.setData(Des3.decode(result.getData())); // 统一解码

                                        LogUtil.showLog("result--->", "result--->" + result.toString());

                                        LogUtil.showLog("result.data--->", "result--->" + result.getData().toString());

                                        switch (type) {
                                            case HandlerCode.COMMON_PARAM://获取公共参数存储到本地
                                                CommonParameterBean commonParameterBean = (CommonParameterBean) GsonUtil.getObject(result.getData(), CommonParameterBean.class);
                                                new CommonParamsDBUtils(context).commonParmeterCreateUpdate(true, commonParameterBean);
                                                Log.e("公共参数", "提示");
                                                break;
                                            case HandlerCode.APP_PARAM://获取APP公共参数存储到本地
                                                AppParamsBean appParamsBean = (AppParamsBean) GsonUtil.getObject(result.getData(), AppParamsBean.class);
                                                new AppParamsDBUtils(context).appParamCreateUpdate(true, appParamsBean);
                                                Log.e("app", "提示");
                                                break;
                                            case HandlerCode.GET_USERINFO://用户信息
                                                UserBean userBean = (UserBean) GsonUtil.getObject(result.getData(), UserBean.class);
                                                if (userBean.getIsBlack() == 1) {
                                                    if (UserUtil.isLogin(context)) {
                                                        new UserDBUtils(context).userCreateUpdate(true,
                                                                new UserBean(), false);
                                                    }

                                                    UserUtil.inintJiPush(context);
                                                    Intent i = new Intent(context,LoginActivity.class);
                                                    context.startActivity(i);
                                                }
                                                new UserDBUtils(context).userCreateUpdate(true, userBean, true);

                                                Log.e("app", "提示");
                                                break;
                                        }
                                        msg_ = handler.obtainMessage(
                                                HandlerCode.SUCCESS,
                                                result);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        msg_ = handler.obtainMessage(
                                                HandlerCode.SUCCESS,
                                                result);
                                    }

                                } else if (result.getStatus().equals("black") && result.getStatusCode().equals("200")) {
                                    ToastUtil.show("1"+result.getMessage());
                                    new UserDBUtils(context).userCreateUpdate(true,new UserBean(), false);
                                    UserUtil.inintJiPush(context);
                                    context.startActivity(new Intent(context, LoginActivity.class));
                                } else {
                                    msg_ = handler.obtainMessage(
                                            HandlerCode.SUCCESS,
                                            result);
                                }


                            } else if (result.getStatus().equals("black") && result.getStatusCode().equals("200")) {
                                ToastUtil.show(result.getMessage());
                                new UserDBUtils(context).userCreateUpdate(true,new UserBean(), false);
                                UserUtil.inintJiPush(context);
                                context.startActivity(new Intent(context, LoginActivity.class));
                                msg_ = handler.obtainMessage(HandlerCode.FAIL,result.getMessage());
                            }  else {
                                msg_ = handler.obtainMessage(HandlerCode.FAIL,
                                        result.getMessage());
                            }
                        } else {
                            msg_ = handler.obtainMessage(HandlerCode.FAIL,ErrorCode.ERROR_CONN_SERVER);

                        }
                        msg_.arg1 = type;
                        msg_.sendToTarget();
                    }

                    @Override
                    public void onCacheSuccess(NewsResponse<String> newsResponse, Call call) {
                        //一般来说,只需呀第一次初始化界面的时候需要使用缓存刷新界面,以后不需要,所以用一个变量标识
//                            boolean isInitCache = false;
//                            if (!isInitCache) {
//                                //一般来说,缓存回调成功和网络回调成功做的事情是一样的,所以这里直接回调onSuccess
//                                onSuccess(newsResponse, call, null);
//                                isInitCache = true;
//                                Toast.makeText(MainApp.getContext(), "4失败", Toast.LENGTH_SHORT);
//                            }
//                            Toast.makeText(MainApp.getContext(), "4失败", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onCacheError(Call call, Exception e) {
                        //获取缓存失败的回调方法,一般很少用到,需要就复写,不需要不用关心
//							Toast.makeText(MainApp.getContext(), "1失败", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        //网络请求失败的回调,一般会弹个Toast
                        msg_ = handler.obtainMessage(HandlerCode.FAIL,
                                "网络异常，请检查网络设置！");
                        msg_.arg1 = type;
                        msg_.sendToTarget();
                    }

                    @Override
                    public void onAfter(@Nullable NewsResponse<String> newsResponse, @Nullable Exception e) {
                        super.onAfter(newsResponse, e);
                        //可能需要移除之前添加的布局
//                        newsAdapter.removeAllFooterView();
//                        //最后调用结束刷新的方法
//                        setRefreshing(false);
//							Toast.makeText(MainApp.getContext(), "3失败", Toast.LENGTH_SHORT);
                    }
                });

//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

    }


    public static void uploadFile(Context mContext, String urls, List<File> files, final Handler handler) {


//		String urls= Urls.SAVE_IMG+"?userId="+userId+"1&type=1";
        OkGo.post(urls)//
                .tag(mContext)//


                .addFileParams("uploadFile", files)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {


                        msg_ = handler.obtainMessage(
                                HandlerCode.UPLOAD_FILE_SUCCESS,
                                s);

                        msg_.sendToTarget();

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        msg_ = handler.obtainMessage(
                                HandlerCode.UPLOAD_FILE_FAIL,
                                e.getMessage());
                        msg_.sendToTarget();
                    }
                });

    }
}