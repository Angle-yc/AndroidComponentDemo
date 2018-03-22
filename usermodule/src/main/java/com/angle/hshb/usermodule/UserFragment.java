package com.angle.hshb.usermodule;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.AppContent;
import com.angle.hshb.basemodule.BaseFragment;
import com.angle.hshb.routermodule.ReflectUtils;


/**
 * 我的模块
 */
public class UserFragment extends BaseFragment {

    TextView tvModule;
    Button btnButton;

    @Override
    protected void initView(View view) {
        tvModule = (TextView) view.findViewById(R.id.tv_module);
        btnButton = (Button) view.findViewById(R.id.btn_jump);
        tvModule.setText("我的\nUserModule");
        btnButton.setText("跳转至购物车");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ReflectUtils.getIntent(context,"com.angle.hshb.androidcomponentdemo.MainActivity");
                if (intent!= null){
                    intent.putExtra(AppContent.JUMP_MIAN,AppContent.MODULE_CART);
                    startActivity(intent);
                }
//                ReflectUtils.startActivityWithName(context, "com.angle.hshb.cartmodule.CartActivity");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

}
