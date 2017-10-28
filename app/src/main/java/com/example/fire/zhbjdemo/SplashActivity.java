package com.example.fire.zhbjdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.fire.zhbjdemo.utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {
    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        rl_root = (RelativeLayout) findViewById(R.id.rl_root);
        setAnima();
    }

    /**
     * 添加动画
     */
    private void setAnima(){
        AnimationSet set = new AnimationSet(false);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5F,Animation.RELATIVE_TO_SELF,0.5F);
        scaleAnimation.setDuration(5000);
        scaleAnimation.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(5000);
        alphaAnimation.setFillAfter(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

       rl_root.startAnimation(set);
    }

    /**
     * 跳转判断
     */
    private void jumpNextPage() {
        boolean is_login = PrefUtils.getBoolean(this, "is_login", false);
        if(is_login){
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }else {
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
        }
    }
}
