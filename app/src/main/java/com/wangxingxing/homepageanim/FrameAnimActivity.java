package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FrameAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        ImageView image = (ImageView) findViewById(R.id.iv_loading);
//        AnimationDrawable animationDrawable = (AnimationDrawable) image.getDrawable();
//        animationDrawable.stop();
//        animationDrawable.selectDrawable(0);
//        animationDrawable.start();

        Glide.with(this).load(R.drawable.matching_loading).into(image);
    }
}