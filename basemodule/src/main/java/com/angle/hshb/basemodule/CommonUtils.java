package com.angle.hshb.basemodule;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by angle
 * 2018/3/22.
 * 公共的工具类
 */

public class CommonUtils {

    /**
     * 弹出消息
     * @param context
     * @param msg
     */
    public static void showToast(final Context context, final String msg){
        if (TextUtils.isEmpty(msg)){
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                Looper.loop();
            }
        }).start();

    }
}
