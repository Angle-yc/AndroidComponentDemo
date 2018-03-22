package com.angle.hshb.homemodule;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.BaseFragment;
import com.angle.hshb.routermodule.ReflectUtils;


/**
 * 首页模块
 */
public class HomeFragment extends BaseFragment {


    TextView tvModule;
    Button btnButton;

    @Override
    protected void initView(View view) {
        tvModule = (TextView) view.findViewById(R.id.tv_module);
        btnButton = (Button) view.findViewById(R.id.btn_jump);
        tvModule.setText("首页\nHomeModule");
        btnButton.setText("跳转到商品详情");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ReflectUtils.getIntent(context, "com.angle.hshb.goodsmodule" +
                        ".GoodsDetailedActivity");
                intent.putExtra("goods","我是首页跳转");
                startActivity(intent);
            }
        });
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

}
