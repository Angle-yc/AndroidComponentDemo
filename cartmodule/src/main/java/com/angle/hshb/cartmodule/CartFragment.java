package com.angle.hshb.cartmodule;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.BaseFragment;
import com.angle.hshb.basemodule.CommonUtils;
import com.angle.hshb.routermodule.GoodsModuleService;
import com.angle.hshb.routermodule.ReflectUtils;


/**
 * 购物车模块
 */
public class CartFragment extends BaseFragment {
    private TextView tvModule;
    private Button btnButton;
    private Button btnCall;

    @Override
    protected void initView(View view) {
        tvModule = (TextView) view.findViewById(R.id.tv_module);
        btnButton = (Button) view.findViewById(R.id.btn_jump);
        tvModule.setText("购物车\nCartModule");
        btnButton.setText("跳转商品详情");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReflectUtils.startActivityWithName(context,"com.angle.hshb.goodsmodule.GoodsDetailedActivity");
            }
        });

        btnCall = (Button) view.findViewById(R.id.btn_call);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsModuleService moduleCall = (GoodsModuleService) ReflectUtils.getModuleCall("com.angle.hshb.goodsmodule" +
                        ".GoodsServiceImpl");
                if (moduleCall != null){
                    CommonUtils.showToast(context,moduleCall.getMethod());
                }
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cart;
    }

}
