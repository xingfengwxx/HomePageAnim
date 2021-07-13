package com.wangxingxing.homepageanim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hoanganhtuan95ptit.library.MeteorView;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;


/**
 *  author : 王星星
 *  date : 2020/7/27 17:55
 *  email : 1099420259@qq.com
 *  description : 
 */
@Route(path = "/test/TestActivity")
public class TestActivity extends AppCompatActivity {

    private MeteorView mMeteorView;
    private Button mButtonTest;
    private Button mButtonStart;
    private Button mButtonOpenGL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        mMeteorView = findViewById(R.id.img_meteor0);
//        mMeteorView.setImageResource(R.drawable.icon_meteor_new);

//        mButtonStart = findViewById(R.id.btn_start);
//        mButtonStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnAnim();
//            }
//        });
//
//        mButtonTest = findViewById(R.id.btn_test);
//
//        mButtonOpenGL = findViewById(R.id.btn_opengl);
//        mButtonOpenGL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(TestActivity.this, OpenGLActivity.class));
//            }
//        });
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

//    @Override
//    public Resources getResources() {
//        Resources res = super.getResources();
//        Configuration config = new Configuration();
//        config.setToDefaults();
//        res.updateConfiguration(config, res.getDisplayMetrics());
//        return res;
//    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res != null && res.getConfiguration().fontScale != 1.0f) {
            res.getConfiguration().fontScale = 1.0f; //恢复默认的[字体大小]
            res.getConfiguration().densityDpi = getDefaultDisplayDensity(); //恢复默认的[显示大小]
            res.updateConfiguration(res.getConfiguration(), res.getDisplayMetrics());
        }
        return super.getResources();
    }

    private int getDefaultDisplayDensity() {
        try {
            Class<?> clazz = Class.forName("android.view.WindowManagerGlobal");
            Method method = clazz.getMethod("getWindowManagerService");
            method.setAccessible(true);
            Object iwm = method.invoke(clazz);
            Method getInitialDisplayDensity  = iwm.getClass().getMethod("getInitialDisplayDensity", int.class);
            getInitialDisplayDensity.setAccessible(true);
            int densityDpi = (int) getInitialDisplayDensity.invoke(iwm, Display.DEFAULT_DISPLAY);
            return densityDpi;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull @NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.fontScale != 1.0f) {
            //刷新
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }
}