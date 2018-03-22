package com.angle.hshb.goodsmodule;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.BaseFragment;


/**
 * 分类模块
 */
public class GoodsFragment extends BaseFragment {

    TextView tvModule;
    Button btnButton;

    @Override
    protected void initView(View view) {
        tvModule = (TextView) view.findViewById(R.id.tv_module);
        btnButton = (Button) view.findViewById(R.id.btn_jump);
        tvModule.setText("分类\nGoodsModule");
        btnButton.setText("跳转到商品详情");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,GoodsDetailedActivity.class));
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods;
    }

}
