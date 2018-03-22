package com.angle.hshb.routermodule;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.angle.hshb.basemodule.CommonUtils;

/**
 * Created by angle
 * 2018/3/22.
 * 供业务模块使用的跳转工具类
 */

public class ReflectUtils {

    /**
     * 获取到指定模块的Fragment
     * @param fragmentName  完整路径
     * @return
     */
    public static Fragment getFragment(String fragmentName){
        Fragment fragment;
        try {
            Class fragmentClass = Class.forName(fragmentName);
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            Log.e("error --->",e.toString());
            e.printStackTrace();
            return null;
        }
        return fragment;
    }

    /**
     * 获取其他模块中的类
     * @param name
     * @return
     */
    public static Object getModuleCall(String name) {
        Object object;
        try {
            Class aClass = Class.forName(name);
            object = aClass.newInstance();
        } catch (Exception e) {
            Log.d("error--->", e.toString());
            return null;
        }

        return object;
    }

    /**
     * 跳转其他业务模块
     * @param context
     * @param activityName
     */
    public static void startActivityWithName(Context context,String activityName){
        try {
            Class clazz = Class.forName(activityName);
            startActivity(context,clazz);
        } catch (ClassNotFoundException e) {
            CommonUtils.showToast(context, "业务组件单独调试不应该跟其他业务Module产生交互，" +
                    "如果你依然想要在运行期依赖其它组件，那么请参考appModul");
            e.printStackTrace();
        }
    }

    /**
     * 直接跳转至Activity
     * @param context
     * @param clazz
     */
    private static void startActivity(Context context, Class clazz) {
        context.startActivity(getIntent(context,clazz));
    }


    /**
     * 获取Intent
     * @param context
     * @param clazz
     * @return
     */
    private static Intent getIntent(Context context, Class clazz) {
        return new Intent(context,clazz);
    }

    /**
     * 获取Intent
     * @param context
     * @param className
     * @return
     */
    public static Intent getIntent(Context context,String className){
        Intent intent = null;
        try {
            Class clazz = Class.forName(className);
            intent = new Intent(context,clazz);
        } catch (ClassNotFoundException e) {
            Log.e("error --->",e.toString());
            e.printStackTrace();
            return null;
        }
        return intent;
    }




}
