package com.example.fire.zhbjdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.example.fire.zhbjdemo.Fragment.ContentFragment;
import com.example.fire.zhbjdemo.Fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    private static final String FRAGMENT_CONTENT = "fragment_content";
    private static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.left_menu);//设置左边侧边栏布局
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//设置全屏触摸
//        slidingMenu.setSecondaryMenu(R.layout.right_menu);//设置右边侧边栏布局
//        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);//设置左右两边都显示
        slidingMenu.setBehindOffset(500);//设置预留 activity  的预留宽度

        initFragment();
    }

    private void initFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();//获取 fragment对象
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启事务
        transaction.replace(R.id.fl_leftmenu,new LeftMenuFragment(),FRAGMENT_LEFT_MENU);
        transaction.replace(R.id.fl_content,new ContentFragment(),FRAGMENT_CONTENT);
        transaction.commit();

    }
}
