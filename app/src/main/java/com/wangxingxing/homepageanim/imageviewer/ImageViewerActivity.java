package com.wangxingxing.homepageanim.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.iielse.imageviewer.ImageViewerBuilder;
import com.wangxingxing.homepageanim.R;

public class ImageViewerActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        init();
    }

    private void init() {
        mImageView = findViewById(R.id.iv_img);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviewImage();
            }
        });
    }

    private void showPreviewImage() {

    }
}