package com.angle.hshb.androidcomponentdemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.angle.hshb.basemodule.AppContent;
import com.angle.hshb.basemodule.BaseActivity;
import com.angle.hshb.basemodule.CommonUtils;
import com.angle.hshb.routermodule.ReflectUtils;

public class MainActivity extends BaseActivity {
    RadioButton bottomHome;
    RadioButton bottomCart;
    RadioGroup radioGroup;
    private Fragment[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        Fragment homeFragment = ReflectUtils.getFragment("com.angle.hshb.homemodule.HomeFragment");
        Fragment goodsFragment = ReflectUtils.getFragment("com.angle.hshb.goodsmodule.GoodsFragment");
        Fragment cartFragment = ReflectUtils.getFragment("com.angle.hshb.cartmodule.CartFragment");
        Fragment userFragment = ReflectUtils.getFragment("com.angle.hshb.usermodule.UserFragment");
        if (homeFragment == null || goodsFragment == null || cartFragment == null || userFragment == null){
            CommonUtils.showToast(context,"找不到对应模块,请重新检查代码");
        }else {
            list = new Fragment[]{homeFragment,goodsFragment,cartFragment,userFragment};
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(R.id.fl_main,homeFragment);
            transaction.add(R.id.fl_main,goodsFragment);
            transaction.add(R.id.fl_main,cartFragment);
            transaction.add(R.id.fl_main,userFragment);
            transaction.commit();
            showHome();
        }
    }

    /**
     * 默认切换在首页
     */
    private void showHome() {
        bottomHome.setChecked(true);
        changeFragment(0);
    }

    /**
     * Fragment的切换
     */
    private void changeFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < list.length; i++) {
            if (i != position){
                //隐藏选项卡
                transaction.hide(list[i]);
            }else {
                transaction.show(list[i]);
            }
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void initView() {
        bottomHome = (RadioButton) findViewById(R.id.bottom_home);
        bottomCart = (RadioButton) findViewById(R.id.bottom_cart);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.bottom_home://首页
                        changeFragment(0);
                        break;
                    case R.id.bottom_sort://分类
                        changeFragment(1);
                        break;
                    case R.id.bottom_cart://购物车
                        changeFragment(2);
                        break;
                    case R.id.bottom_user://我的
                        changeFragment(3);
                        break;
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent() != null){
            String indexStr = getIntent().getStringExtra(AppContent.JUMP_MIAN);
            if (!TextUtils.isEmpty(indexStr)){
                switch (indexStr){
                    case AppContent.MODULE_HOME:
                        break;
                    case AppContent.MODULE_GOODS:
                        break;
                    case AppContent.MODULE_CART:
                        bottomCart.setChecked(true);
                        changeFragment(2);
                        break;
                    case AppContent.MODULE_USER:
                        break;
                }
            }

        }
    }
}
