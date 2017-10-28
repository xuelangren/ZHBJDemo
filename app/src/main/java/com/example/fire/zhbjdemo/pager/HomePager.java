package com.example.fire.zhbjdemo.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.fire.zhbjdemo.base.BasePager;

/**
 * Created by fire on 2017/10/28.
 */

public class HomePager extends BasePager {
    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initDatas() {
       tv_title.setText("智慧北京");
        TextView textView = new TextView(mActivity);
        textView.setText("首页");
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(50);
        fl.addView(textView);

    }
}
