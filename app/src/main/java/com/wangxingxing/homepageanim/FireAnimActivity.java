package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wangxingxing.homepageanim.weight.BezierView;

public class FireAnimActivity extends AppCompatActivity {

    private Button mBtnStart;
    private BezierView mBezierView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_anim);

        init();
    }

    private void init() {
        mBtnStart = findViewById(R.id.btn_start);
        mBezierView = findViewById(R.id.bezier_view);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBezierView.startLoading();
            }
        });
    }
}