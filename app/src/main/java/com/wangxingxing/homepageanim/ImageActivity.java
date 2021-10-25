package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    private AppCompatImageView mAivPic;
    private AppCompatButton mBtnChangeColor;
    private boolean isSelect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mAivPic = findViewById(R.id.aiv_pic);
        mBtnChangeColor = findViewById(R.id.btn_change_color);

        mBtnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSelect) {
                    isSelect = false;
                    ColorStateList csl = AppCompatResources.getColorStateList(getApplication(), R.color.colorHeadBorder1);
                    ImageViewCompat.setImageTintList(mAivPic, csl);
                } else {
                    isSelect = true;
                    ColorStateList csl = AppCompatResources.getColorStateList(getApplication(), R.color.black);
                    ImageViewCompat.setImageTintList(mAivPic, csl);
                }
            }
        });
    }
}