package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void toTest(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }

    public void toStars(View view) {
        startActivity(new Intent(this, StarsActivity.class));
    }
}