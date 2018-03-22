package com.angle.hshb.basemodule;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * BaseActivity
 */
public abstract class BaseFragment extends Fragment {


    protected Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

}
