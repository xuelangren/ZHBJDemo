package com.example.fire.zhbjdemo.Fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.fire.zhbjdemo.R;
import com.example.fire.zhbjdemo.base.BasePager;
import com.example.fire.zhbjdemo.pager.GovPager;
import com.example.fire.zhbjdemo.pager.HomePager;
import com.example.fire.zhbjdemo.pager.NewsPager;
import com.example.fire.zhbjdemo.pager.SettingPager;
import com.example.fire.zhbjdemo.pager.SmartPager;

import java.util.ArrayList;

/**
 * Created by fire on 2017/10/28.
 */

public class ContentFragment extends BaseFragment {

    private RadioGroup rg_group;
    private ViewPager mViewpager;
    private ArrayList<BasePager>  list;

    @Override
    public View initViews() {
        View view = View.inflate(activity, R.layout.fragment_content,null);
        rg_group = view.findViewById(R.id.rg_group);
         mViewpager = view.findViewById(R.id.vp_content);
        return view;
    }

    @Override
    public void initData() {
       rg_group.check(R.id.rb_main);

       list = new ArrayList<>();
       list.add(new HomePager(activity));
       list.add(new NewsPager(activity));
       list.add(new SmartPager(activity));
       list.add(new GovPager(activity));
       list.add(new SettingPager(activity));
       mViewpager.setAdapter(new MyViewPagerAdapter());

    }




    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = list.get(position);
            container.addView(basePager.rootView);
            basePager.initDatas();
            return list.get(position).rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
