package com.example.fire.zhbjdemo.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.fire.zhbjdemo.base.BasePager;

/**
 * Created by fire on 2017/10/28.
 */

public class SmartPager extends BasePager {
    public SmartPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initDatas() {
       tv_title.setText("生活");
        TextView textView = new TextView(mActivity);
        textView.setText("智慧服务");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(50);
        fl.addView(textView);

    }
}
