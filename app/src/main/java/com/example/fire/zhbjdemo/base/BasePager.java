package com.example.fire.zhbjdemo.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fire.zhbjdemo.R;

/**
 * Created by fire on 2017/10/28.
 */

public class BasePager {
    public Activity mActivity;
    public View rootView;
    public TextView tv_title;
    public FrameLayout fl;
    public BasePager(Activity activity) {
        this.mActivity = activity;
        initViews();
    }

    public void initViews(){
        rootView = View.inflate(mActivity, R.layout.base_pager,null);
        tv_title = rootView.findViewById(R.id.tv_title);
        fl = rootView.findViewById(R.id.fl);
    }
    public void initDatas(){


    }
}
