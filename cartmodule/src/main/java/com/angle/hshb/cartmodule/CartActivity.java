package com.angle.hshb.cartmodule;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.angle.hshb.basemodule.BaseActivity;
import com.angle.hshb.basemodule.CommonUtils;
import com.angle.hshb.routermodule.ReflectUtils;

public class CartActivity extends BaseActivity {
    TextView tvModule;
    Button btnButton;
    @Override
    protected void initData() {
        tvModule = (TextView) findViewById(R.id.tv_module);
        btnButton = (Button) findViewById(R.id.btn_jump);
        tvModule.setText("购物车\nCartModule");
        btnButton.setText("跳转到商品详情");
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ReflectUtils.getIntent(context, "com.angle.hshb.goodsmodule" +
                        ".GoodsDetailedActivity");
                if (intent != null){
                    intent.putExtra("goods","我是购物车跳转");
                    startActivity(intent);
                }else {
                    CommonUtils.showToast(CartActivity.this,"没有获取到实例");
                }
            }
        });
    }

    @Override
    protected void initView() {
        setTitle("购物车");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cart;
    }

}
