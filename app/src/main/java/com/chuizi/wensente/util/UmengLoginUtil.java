package com.chuizi.wensente.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/16.
 * 友盟第三方登录
 */

public class UmengLoginUtil {

    private final Handler handler;
    private final int what;
    private final UMShareAPI mShareAPI;
    private Context context;


    public UmengLoginUtil(Context context,UMShareAPI mShareAPI,int what,Handler handler) {
        this.context = context;
        this.mShareAPI = mShareAPI;
        this.handler = handler;
        this.what = what;

        initConfig();
    }

    //最新版
    UMAuthListener authListener = new UMAuthListener() {
        public int type;

        @Override
        public void onStart(SHARE_MEDIA share_media) {
            if (share_media == SHARE_MEDIA.QQ) {
                LogUtil.showLog("QQ登录", "QQ登录");
            }
            if (share_media == SHARE_MEDIA.WEIXIN) {
                LogUtil.showLog("WEIXIN", "WEIXIN");
            }
            if (share_media == SHARE_MEDIA.SINA) {
                LogUtil.showLog("SINA", "SINA");
            }
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//	            String temp = "";
//	            for (String key : data.keySet()) {
//	                temp = temp + key + " : " + data.get(key) + "\n";
//	            }
            Map map = new HashMap();
            if (data != null) {
                if (platform == SHARE_MEDIA.WEIXIN) {
                    type=1;
                    // 微信
                    data.toString();
                    if (data != null) {
                        LogUtil.showLog("微信登录", data.toString());
                        StringBuilder sb = new StringBuilder();
                        Set<String> keys = data.keySet();
                        for (String key : keys) {
                            sb.append(key + "="
                                    + data.get(key).toString()
                                    + "\r\n");
                        }
                        Log.d("TestData", sb.toString());
                        String wxNum = data.get("openid")
                                .toString();

                        String name = data.get("name")
                                .toString();
                        String header = data.get("iconurl")
                                .toString();
                        String sex = data.get("gender")
                                .toString();
                        if("2".equals(sex)){
                            sex="女";
                            map.put("sex", sex);
                        }else if("1".equals(sex)){
                            sex="男";
                            map.put("sex", sex);
                        }
                        map = new HashMap();
                        map.put("wxNum", wxNum);
                        map.put("sex", sex);
                        map.put("name", name);
                        map.put("header", header);

                    }

                } else if (platform == SHARE_MEDIA.QQ) {
                    type=2;
                    LogUtil.showLog("QQ登录", data.toString());
                    StringBuilder sb = new StringBuilder();
                    Set<String> keys = data.keySet();
                    for (String key : keys) {
                        sb.append(key + "="
                                + data.get(key).toString()
                                + "\r\n");
                    }
                    String name = data.get("name")
                            .toString();
                    String header = data.get("iconurl")
                            .toString();
                    String qqNum = data.get("uid").toString();
                    String sex = data.get("gender").toString();

                    map = new HashMap();
                    map.put("qqNum", qqNum);
                    if("2".equals(sex)){
                        sex="女";
                    }else if("1".equals(sex)){
                        sex="男";
                    }
                    map.put("sex", sex);
                    map.put("name", name);
                    map.put("header", header);


                }else if (platform == SHARE_MEDIA.SINA) {
                    type=3;
                    LogUtil.showLog("新浪", data.toString());
                    StringBuilder sb = new StringBuilder();
                    Set<String> keys = data.keySet();
                    for (String key : keys) {
                        sb.append(key + "="
                                + data.get(key).toString()
                                + "\r\n");
                    }
                    String name = data.get("name")
                            .toString();
                    String header = data.get("iconurl")
                            .toString();
                    String sinaNum = data.get("uid").toString();
                    String sex = data.get("gender").toString();

                    map = new HashMap();
                    map.put("sinaNum", sinaNum);
                    map.put("sex", sex);
                    map.put("name", name);
                    map.put("header", header);

                }
                if(map!=null&&map.size()>0){//
                    Message msg = handler.obtainMessage(what);
                    msg.obj = map;;
                    msg.arg1 = type;

                    msg.sendToTarget();
                }
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
//	            result.setText("错误" + t.getMessage());
            if (platform == SHARE_MEDIA.QQ) {
                LogUtil.showLog("QQ登录", "QQ登录"+"错误" + t.getMessage());
            }
            if (platform == SHARE_MEDIA.WEIXIN) {
                LogUtil.showLog("WEIXIN", "WEIXIN"+"错误" + t.getMessage());
            }
            if (platform == SHARE_MEDIA.SINA) {
                LogUtil.showLog("SINA", "SINA"+"错误" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

            if (platform == SHARE_MEDIA.QQ) {
                LogUtil.showLog("QQ登录", "QQ登录");
            }
            if (platform == SHARE_MEDIA.WEIXIN) {
                LogUtil.showLog("WEIXIN", "WEIXIN");
            }
            if (platform == SHARE_MEDIA.SINA) {
                LogUtil.showLog("SINA", "SINA");
            }
        }
    };
    UMAuthListener authListenerDel = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
//	            Toast.makeText(context, "成功了", Toast.LENGTH_LONG).show();
        }


        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
//	            Toast.makeText(context, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
//	            Toast.makeText(context, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    /**
     * 微信登录、QQ和微博登录
     */
    public void umengLogin(int umengLoginType) {
        switch (umengLoginType) {
            case 1:// 微信登录
                if (!mShareAPI.isInstall((Activity) context, SHARE_MEDIA.WEIXIN)) {// 如果没有安装客户端，
                    Toast.makeText(context, "您还没有安装微信,请安装后重试", Toast.LENGTH_LONG).show();
                    return;
                }

                mShareAPI.getPlatformInfo((Activity) context, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case 2:// QQ
                if (!mShareAPI.isInstall((Activity) context, SHARE_MEDIA.QQ)) {// 如果没有安装客户端，
                    Toast.makeText(context, "您还没有安装QQ,请安装后重试", Toast.LENGTH_LONG).show();

                    return;
                }
                mShareAPI.getPlatformInfo((Activity) context, SHARE_MEDIA.QQ, authListener);
                break;
            case 3:// 微博登录
                // 授权登录成功
                mShareAPI.getPlatformInfo((Activity) context, SHARE_MEDIA.SINA, authListener);
                break;

            default:
                break;
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public void deleteOauth(int umengLoginType) {
        // TODO Auto-generated method stub
        switch (umengLoginType) {
            case 1:// 微信登录
                UMShareAPI.get(context).deleteOauth((Activity) context, SHARE_MEDIA.WEIXIN, authListenerDel);
                break;
            case 2:// QQ
                UMShareAPI.get(context).deleteOauth((Activity) context, SHARE_MEDIA.QQ, authListenerDel);
                break;
            case 3:// 微博登录
                // 授权登录成功
                UMShareAPI.get(context).deleteOauth((Activity) context, SHARE_MEDIA.SINA, authListenerDel);
                break;

            default:
                break;
        }
    }
    /**
     * 各个平台的配置，建议放在全局Application或者程序入口
     */
    public void initConfig() {
        // TODO Auto-generated method stub
        PlatformConfig.setWeixin("wx09a524e3258350da",
                "c127e10c53c7faffb3673788deb7a0df");
        // QQ和Qzone appid appkey
        PlatformConfig.setQQZone("1105975411", "KkH5LHblQXhPzyTY");
        // PlatformConfig.setTencentWB("1105398558",
        // "84r0jFEw65dFIAWE");
        // 新浪微博 appkey appsecret
        PlatformConfig.setSinaWeibo("2490917220",
                "450b9d7d5ee4409e28d325261992b9c4","");
    }
}
