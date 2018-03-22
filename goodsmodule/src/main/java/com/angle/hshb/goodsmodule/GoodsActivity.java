package com.angle.hshb.goodsmodule;

import android.os.Bundle;

import com.angle.hshb.basemodule.BaseActivity;

public class GoodsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        setTitle("分类模块");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods;
    }
}
