package com.angle.hshb.goodsmodule;

import android.content.Context;

import com.angle.hshb.routermodule.GoodsModuleService;

/**
 * Created by angle
 * 2018/3/22.
 */

public class GoodsServiceImpl implements GoodsModuleService{

    Context context;
    @Override
    public void initContext(Context context) {
        this.context = context;
    }

    @Override
    public String getMethod() {
        return Utils.getMethod();
    }
}
