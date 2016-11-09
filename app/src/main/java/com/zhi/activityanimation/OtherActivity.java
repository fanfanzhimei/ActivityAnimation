package com.zhi.activityanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

/**
 * 在这个界面中实现 两页之间的切换动画
 * Created by Administrator on 2016/11/9.
 */
public class OtherActivity extends Activity {
    private ViewFlipper viewFlipper;
    private Animation in_right_to_left;
    private Animation out_right_to_left;
    private Animation in_left_to_right;
    private Animation out_left_to_right;

    private float x;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        in_right_to_left = AnimationUtils.loadAnimation(OtherActivity.this, R.anim.in_right_to_left);
        out_right_to_left = AnimationUtils.loadAnimation(OtherActivity.this, R.anim.out_right_to_left);
        in_left_to_right = AnimationUtils.loadAnimation(OtherActivity.this, R.anim.in_left_to_right);
        out_left_to_right = AnimationUtils.loadAnimation(OtherActivity.this, R.anim.out_left_to_right);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float cunrrentX = event.getX();
                if(cunrrentX > x){ // 向右，显示上一张
                    viewFlipper.setInAnimation(in_left_to_right);
                    viewFlipper.setOutAnimation(out_left_to_right);
                    viewFlipper.showPrevious();
                }

                if(cunrrentX < x){  // 向左，显示下一张
                    viewFlipper.setInAnimation(in_right_to_left);
                    viewFlipper.setOutAnimation(out_right_to_left);
                    viewFlipper.showNext();
                }
                break;
        }
        return true;
    }
}