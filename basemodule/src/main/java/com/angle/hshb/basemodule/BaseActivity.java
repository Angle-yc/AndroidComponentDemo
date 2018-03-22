package com.angle.hshb.basemodule;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by angle
 * 2018/3/21.
 * BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected ImageView mIvBack;
    protected TextView mTitle;
    protected Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(getLayoutId());

        initToolbar();

        initView();

        initData();

    }

    private void initToolbar() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mTitle = (TextView) findViewById(R.id.tv_title);
        if (mIvBack != null) {
            mIvBack.setImageResource(R.drawable.arrow_back);
            mIvBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onLeftClick();
                }
            });
        }
    }

    private void onLeftClick() {
        finish();
    }

    //数据处理
    protected abstract void initData();

    //初始化View
    protected abstract void initView();

    //布局文件
    protected abstract int getLayoutId();

    //设置标题
    protected void setTitle(String title) {
        if (mTitle != null)
            mTitle.setText(title);
    }

}
