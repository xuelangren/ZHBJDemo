package com.example.fire.zhbjdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.fire.zhbjdemo.utils.PrefUtils;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {
    private static final int[] picturs = {R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private ViewPager vp_guide;
    private ArrayList<ImageView> list;
    private LinearLayout linearLayout;
    private View view_red_point;
    private int width;//两个圆点之间的距离
    private Button bt_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gilde);
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        linearLayout = (LinearLayout) findViewById(R.id.ll_pointGroup);
        view_red_point = findViewById(R.id.vw_red_point);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到主页面
                PrefUtils.setBoolean(GuideActivity.this,"is_login",true);
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
               finish();
            }
        });
        initView();
        vp_guide.setAdapter(new MyAdapter());
        vp_guide.setOnPageChangeListener(new GuidePageListener());


    }


    /**
     * 初始化界面
     */
    private void initView() {
        list = new ArrayList<>();
        //初始化引导页的页面
        for (int i = 0; i < picturs.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(picturs[i]);
            list.add(imageView);
        }
        //初始化圆点
        for (int i = 0; i < picturs.length; i++) {
            View point = new View(this);
            point.setBackgroundResource(R.drawable.shape_point_gray);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            if (i > 0) {
                params.leftMargin = 10;
            }
            point.setLayoutParams(params);//设置圆点的大小
            linearLayout.addView(point);
        }
        //获取视图数,对 Layout构建完成进行监听,构建完成后获取2个点之间的位置
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                width = linearLayout.getChildAt(1).getLeft() - linearLayout.getChildAt(0).getLeft();
                Log.d("aaaaaaa", "onGlobalLayout: " + width);
            }
        });



    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class GuidePageListener implements ViewPager.OnPageChangeListener {
        //滑动监听
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //根据2个点的位置,*百分比(positionOffset)计算出圆点的偏移位置.
            int v = (int) (width * positionOffset) + position * width;
            //获取当前圆点的位置
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view_red_point.getLayoutParams();
            //移动到偏移的位置
            layoutParams.leftMargin = v;
            view_red_point.setLayoutParams(layoutParams);

        }

        @Override
        public void onPageSelected(int position) {
            if(position==list.size()-1){
                bt_start.setVisibility(View.VISIBLE);
            }else {
                bt_start.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}

