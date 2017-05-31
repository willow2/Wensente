package com.chuizi.wensente.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chuizi.healthJS.R;

/**
 * Created by Administrator on 2017/3/31.
 */

public class PackageUtil {
    /**
     *
     * @param mContext
     * @param command
     * @param intent
     */
    public static  void qiangDialog(final Context mContext, final String command, final Intent intent) {

        final AlertDialog dlg = new AlertDialog.Builder(mContext).create();
        dlg.setCanceledOnTouchOutside(true);
        dlg.setCancelable(true);
        dlg.show();
        Window window = dlg.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.dialog_orderok_order);
        // 为确认按钮添加事件,执行退出应用操作
        Button btn_ensure = (Button) window.findViewById(R.id.btn_ensure);
        final EditText et_yanzheng = (EditText) window.findViewById(R.id.et_yanzheng);
        dlg.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        btn_ensure.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String yanzheng = et_yanzheng.getText().toString().trim();
                if(yanzheng.equals(command)){
                    mContext.startActivity(intent);
                }else{
                    Toast.makeText(mContext,"您的口令不正确",Toast.LENGTH_SHORT).show();
                }
                dlg.dismiss();
            }
        });

    }
}
