package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnTest;
    private Button mBtnShow;

    private LottieAnimationView lavCure;

    private LottieAnimationView lavHug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnTest = findViewById(R.id.btn_test);
        mBtnShow = findViewById(R.id.btn_show);

        lavCure = findViewById(R.id.lav_cure);
        lavHug = findViewById(R.id.lav_hug);

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
}