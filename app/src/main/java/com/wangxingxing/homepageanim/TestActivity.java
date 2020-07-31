package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hoanganhtuan95ptit.library.MeteorView;


/**
 *  author : 王星星
 *  date : 2020/7/27 17:55
 *  email : 1099420259@qq.com
 *  description : 
 */
public class TestActivity extends AppCompatActivity {

    private MeteorView mMeteorView;
    private Button mButtonTest;
    private Button mButtonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mMeteorView = findViewById(R.id.img_meteor0);
        mMeteorView.setImageResource(R.drawable.icon_meteor);

        mButtonStart = findViewById(R.id.btn_start);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAnim();
            }
        });

        mButtonTest = findViewById(R.id.btn_test);
    }

    private void btnAnim() {
        mButtonTest.animate().translationX(300)
                .translationY(300)
                .setDuration(5000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        animator.cancel();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .start();
    }
}