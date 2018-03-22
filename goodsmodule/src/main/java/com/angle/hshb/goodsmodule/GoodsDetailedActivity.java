package com.angle.hshb.goodsmodule;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.BaseActivity;
import com.angle.hshb.basemodule.CommonUtils;
import com.angle.hshb.routermodule.ReflectUtils;

public class GoodsDetailedActivity extends BaseActivity {

    private TextView tvModule;
    private Button btnButton;


    @Override
    protected void initData() {
        if (getIntent() != null){
            String str =  getIntent().getStringExtra("goods");
            if (!TextUtils.isEmpty(str)){
                CommonUtils.showToast(this,str);
            }
        }
    }

    @Override
    protected void initView() {
        setTitle("商品详情");
        tvModule = (TextView) findViewById(R.id.tv_module);
        btnButton = (Button) findViewById(R.id.btn_jump);
        tvModule.setText("GoodsDetailed");
        btnButton.setText("跳转到购物车");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReflectUtils.startActivityWithName(context, "com.angle.hshb.cartmodule.CartActivity");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detailed;
    }
}
