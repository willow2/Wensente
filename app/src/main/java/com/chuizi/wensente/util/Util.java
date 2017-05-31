package com.chuizi.wensente.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.core.control.ToastUtil;
import com.chuizi.healthJS.Contents;
import com.chuizi.healthJS.R;
import com.chuizi.healthJS.api.HandlerCode;
import com.chuizi.healthJS.model.RegionBean;
import com.chuizi.healthJS.util.rsa.Base64NewUtil;
import com.chuizi.healthJS.util.rsa.RSAUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;

import java.io.File;
import java.security.PublicKey;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * 系统信息
 *
 * @author jiaolj
 */
public class Util {


    /**
     * 是否联网
     * @param context
     * @return
     */
    public static boolean isConnectInternet(Context context)
    {
        try{
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if(connectivity == null){
                return false;
            }
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if(info != null)
            {
                return info.isAvailable();
            }

            WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
            if(wifiInfo != null)
            {
                int ipAddress = wifiInfo.getIpAddress();
                if (mWifiManager.isWifiEnabled() && ipAddress != 0)
                {
                    return true;
                }
            }
        }catch (Exception e) {
        }
        return false;
    }

    public static List<RegionBean> getRegionPinYin(List<RegionBean> list) {

        for (int i = 0; i < list.size(); i++) {
            RegionBean region = list.get(i);
            if (StringUtil.isNullOrEmpty(region.getPinyin())) {
                region.setPinyin(PingYinUtil.getPingYin(region.getName()));
                list.set(i, region);
            }
        }
        // Log.v(TAG, "-----getRegionPinYin--allRegions_--------"+list.size());
        return list;
    }
    /**
     * 开启提示框
     *
     * @param context
     * @param title
     */
    public static void appUpHintDialog(final Context context, final String title,
                           final String download) {

        final AlertDialog dlg = new AlertDialog.Builder(context).create();
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();
        Window window = dlg.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.dialog_hint);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        tv_title.setText(title);
        Button left = (Button) window.findViewById(R.id.btn_left);
        Button right = (Button) window.findViewById(R.id.btn_right);

        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.dismiss();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(download);
                intent.setData(content_url);
                context.startActivity(intent);

            }
        });
    }
    /**
     * 拨打电话
     */
    public static void dialPhoneDialog(final Context context, final String tel,
                                       final String title) {

        final AlertDialog dlg = new AlertDialog.Builder(context).create();
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();

        Window window = dlg.getWindow();
        window.setContentView(R.layout.common_dialog_two_btn);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_title);
        tv_title.setText(tel);
        Button left = (Button) window.findViewById(R.id.btn_left);
        Button right = (Button) window.findViewById(R.id.btn_right);
        left.setText("取消");
        right.setText("呼叫");
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + tel);
                Intent intentPhone = new Intent(Intent.ACTION_DIAL, uri);// 调用拨号程序
                context.startActivity(intentPhone);
                dlg.dismiss();
            }
        });
    }

    public static final String publicKeyNew = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDGOEEKXIePpI/KXN5WXK8oK0Nlv4PO/BQXM4NGBZAq3o9JgXQdCAHo2+DjAaLMkcSHLZk65DgQqvl+OqPFCxRJd8PQWcnEE317dNIMD0s5Gq2bNgnv1AU+2Ls4RykxEtku4tCnDNagDva+c8ry++ZpdvnmU1drNtr1Q6vcejTMSwIDAQAB";
//    public static final String publicKeyNew = "";
    /**
     * RSA签名
     *
     * @param content 待签名数据
     * @return 签名值
     */
    public static String signPublic(String content, String publicKeyStr) {
        // 从字符串中得到公钥
        PublicKey publicKey;
        try {
            publicKey = RSAUtils.loadPublicKey(publicKeyStr);
            // 加密
//			byte[] contentByte = new byte[128] ;
//			contentByte = content.getBytes("utf-8") ;
            byte[] encryptByte = RSAUtils.encryptData(content.getBytes("utf-8"), publicKey);
            // 为了方便观察吧加密后的数据用base64加密转一下，要不然看起来是乱码,所以解密是也是要用Base64先转换
            String afterencrypt = Base64NewUtil.encode(encryptByte);
            return afterencrypt;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static void inputDialog(final Context context,
                                   final Handler handler, final String title,final String titleText, final String leftStr,
                                   final String rightStr, final int what, final Object obj,
                                   final int arg1, final int arg2) {

        final AlertDialog dlg = new AlertDialog.Builder(context).create();
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();
        Window window = dlg.getWindow();
        dlg.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.common_dialog_input_et);
        final EditText et_code = (EditText) window.findViewById(R.id.et_code);
        LinearLayout.LayoutParams paramLT = (LinearLayout.LayoutParams) et_code
                .getLayoutParams();
        switch (arg1){
            case 2:
                paramLT.height = 150;
                et_code.setFilters(new InputFilter[]{ new  InputFilter.LengthFilter(8)});
                break;
            case 3:
                paramLT.height = 240;
                et_code.setFilters(new InputFilter[]{ new  InputFilter.LengthFilter(30)});
                break;
            default:
                paramLT.height = 150;
                break;
        }

        et_code.setLayoutParams(paramLT);
//		Button left = (Button) window.findViewById(R.id.btn_left);
        Button right = (Button) window.findViewById(R.id.btn_right);
        et_code.setHint(title);
        if(!StringUtil.isNullOrEmpty(titleText)){
            et_code.setText(titleText);
        }
//		left.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				dlg.dismiss();
//					Message msg = handler.obtainMessage(what);
//					msg.obj = obj;
//					msg.arg1 = arg1;
//					msg.arg2 = arg2;
//					msg.sendToTarget();
//			}
//		});
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String code = et_code.getText().toString();

                if (StringUtil.isNullOrEmpty(code)) {
                    Toast.makeText(context, title, Toast.LENGTH_LONG)
                            .show();
                    return;
                }
//                if (StringUtil.isNullOrEmpty(code.toString().trim())) {
//                    Toast.makeText(context, "最多可以设置8个字的昵称", Toast.LENGTH_LONG)
//                            .show();
//                    return;
//                }
                Message msg = handler.obtainMessage(what);
                msg.obj = et_code.getText().toString();;
                msg.arg1 = arg1;
                msg.arg2 = arg2;
                msg.sendToTarget();

                dlg.dismiss();

                // 访问接口查询订单信息查到了跳转查不到不跳转
            }
        });
    }
    /**
     * 只有一个按钮并且弹出来一下  不可取消
     *
     * @param context
     */
    public static void hintOne(final Context context, final String title,
                             final String btn, final Handler handler, final int what,
                             final Object obj, final int arg1, final int arg2) {

        final AlertDialog dlg = new AlertDialog.Builder(context).setCancelable(false).create();
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.common_dialog_one_btn);
        TextView tv_title = (TextView) window.findViewById(R.id.tv_hint_text);
        tv_title.setText(title);
        Button btn_confirm = (Button) window.findViewById(R.id.btn_confirm);
        btn_confirm.setText(btn);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(handler!=null){
                    Message msg = handler.obtainMessage(what, obj);
                    msg.arg1 = arg1;
                    msg.arg2 = arg2;
                    msg.sendToTarget();
                }
                dlg.dismiss();
            }
        });
        dlg.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if(handler!=null){
                    Message msg = handler.obtainMessage(HandlerCode.ONLY_DISSMISS, obj);
                    msg.arg1 = arg1;
                    msg.arg2 = arg2;
                    msg.sendToTarget();
                }
            }
        });
    }

    public static void showEwmDialog(final Activity mContext, final String header) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = inflater.inflate(R.layout.qrcode_dialog, null);
        final PopupWindow popupWindow = new PopupWindow(viewPopupwindow, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow.setAnimationStyle(R.style.popwin_anim_style);
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置popupWindow的背景透明度
        backgroundAlpha(mContext,1f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(mContext,1f);
            }
        });
        Button btnKeepQRCode = (Button) viewPopupwindow.findViewById(R.id.keep_qrcode);
        ImageView imgQRCode = (ImageView) viewPopupwindow.findViewById(R.id.img_qrcode);
        btnKeepQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadImag(context,header);
                popupWindow.dismiss();
            }
        });
    }

    public static void downloadImag(final Context context, String imgPath) {
        OkGo.get(imgPath)//
                .tag(context)//
                .execute(new FileCallback(Contents.ROOT_PATH, FileUtils.getFileNameNoFormat(imgPath) + ".jpeg") { //文件下载时，需要指定下载的文件目录和文件名
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        ToastUtil.show("下载成功！");
                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        Uri uri = Uri.fromFile(file);
                        intent.setData(uri);
                        context.sendBroadcast(intent);
                    }
                });
    }

    private static void backgroundAlpha(Activity mContext, float bgAlpha) {
        WindowManager.LayoutParams lp = mContext.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        mContext.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        mContext.getWindow().setAttributes(lp);
    }


}
