package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.blankj.utilcode.util.ConvertUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.wangxingxing.homepageanim.weight.RoundedCornersTransform;

public class RoundImageActivity extends AppCompatActivity {

    private ImageView mImageView0;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;

    private int[] imgResIds = new int[]{
            R.drawable.ic_pic_0,
            R.drawable.ic_pic_1,
            R.drawable.ic_pic_2,
            R.drawable.ic_pic_3,
            R.drawable.ic_pic_4,
            R.drawable.ic_pic_5,
            R.drawable.ic_pic_6,
            R.drawable.ic_pic_7,
            R.drawable.ic_pic_8,
            R.drawable.ic_pic_9,
            R.drawable.ic_pic_10,
            R.drawable.ic_pic_11,
            R.drawable.ic_pic_12,
            R.drawable.ic_pic_13,
            R.drawable.ic_pic_14,
            R.drawable.ic_pic_15,
            R.drawable.ic_pic_16,
            R.drawable.ic_pic_17,
            R.drawable.ic_pic_18,
            R.drawable.ic_pic_19,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_image);

        init();
    }

    private void init() {

        mImageView0 = findViewById(R.id.iv_0);
        mImageView1 = findViewById(R.id.iv_1);
        mImageView2 = findViewById(R.id.iv_2);
        mImageView3 = findViewById(R.id.iv_3);
        mImageView3 = findViewById(R.id.iv_4);

        RoundedCornersTransform transform = new RoundedCornersTransform(this, ConvertUtils.dp2px(10));
        transform.setNeedCorner(true, false, true, false);
        RequestOptions options = new RequestOptions().placeholder(R.color.colorHeadBorder1).transform(transform);
        Glide.with(this)
                .asBitmap()
                .load(imgResIds[0])
                .apply(options)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mImageView0);

        RoundedCornersTransform transform2 = new RoundedCornersTransform(this, ConvertUtils.dp2px(10));
        transform2.setNeedCorner(false, true, false, true);
        RequestOptions options2 = new RequestOptions().placeholder(R.color.colorHeadBorder1).transform(transform2);
        Glide.with(this)
                .asBitmap()
                .load(imgResIds[1])
                .apply(options2)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mImageView1);
    }
}