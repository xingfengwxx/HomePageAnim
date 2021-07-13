package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.text.style.ImageSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.ToastUtils;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnTest;
    private Button mBtnShow;

    private LottieAnimationView lavCure;

    private LottieAnimationView lavHug;

    private Button mBtnJump;

    private TextView mTvKol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnTest = findViewById(R.id.btn_test);
        mBtnShow = findViewById(R.id.btn_show);

        lavCure = findViewById(R.id.lav_cure);
        lavHug = findViewById(R.id.lav_hug);

        mBtnJump = findViewById(R.id.btn_jump);

        mTvKol = findViewById(R.id.tv_kol);

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showPopupWindow();
//                showToast();

//                lavCure.playAnimation();
//                lavHug.setSpeed(0.5f);
                lavHug.playAnimation();
            }
        });

        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/test/TestActivity")
                        .navigation();
            }
        });

        showKol();
    }

    private void showPopupWindow() {
        LikePopupWindow likePopupWindow = LikePopupWindow.create(PopupWindowActivity.this);
        likePopupWindow.showAsDropDown(mBtnTest, -50, 0);
        likePopupWindow.setListener(new LikePopupWindow.IListener() {
            @Override
            public void onClickLike(int likeType) {
                likePopupWindow.dismiss();
            }

        });
    }

    private void showToast() {
        View toastView = LayoutInflater.from(this).inflate(R.layout.toast_custom, null);
        ToastUtils.make().setGravity(Gravity.TOP, 0, 100).show(toastView);
    }

    private void showKol() {
        String nickname = "一二三四五六七八九十一二三四五六七八九十";
        if (nickname.length() > 10) {
            nickname = nickname.substring(0, 10) + "...";
        }

        ImageSpan imageSpan = new ImageSpan(ResourceUtils.getDrawable(R.drawable.icon_kol_official), ImageSpan.ALIGN_CENTER);

        SpanUtils.with(mTvKol)
                .append(nickname)
                .setFontSize(24, true)
                .appendImage(R.drawable.icon_kol_official)
//                .setSpans(imageSpan)
                .create();
    }
}