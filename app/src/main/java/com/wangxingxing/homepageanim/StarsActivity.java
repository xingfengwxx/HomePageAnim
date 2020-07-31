package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sofakingforever.stars.AnimatedStarsView;

public class StarsActivity extends AppCompatActivity {

    private AnimatedStarsView mAnimatedStarsViewWhite;
    private AnimatedStarsView mAnimatedStarsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);

        mAnimatedStarsView = findViewById(R.id.stars);
        mAnimatedStarsViewWhite = findViewById(R.id.stars_white);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimatedStarsView.onStart();
        mAnimatedStarsViewWhite.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAnimatedStarsViewWhite.onStop();
        mAnimatedStarsView.onStop();
    }
}