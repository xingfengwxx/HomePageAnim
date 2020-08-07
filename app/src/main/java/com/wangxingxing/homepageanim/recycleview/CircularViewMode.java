package com.wangxingxing.homepageanim.recycleview;

import android.view.View;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;


/**
 *  author : 王星星
 *  date : 2020/7/27 19:15
 *  email : 1099420259@qq.com
 *  description : 
 */
public class CircularViewMode implements ItemViewMode {

    private static final String TAG = "CircularViewMode";

    //调整圆弧起始位置
    private int mCircleOffset = 900;
    private float mDegToRad = 1.0f / 180.0f * (float) Math.PI;
    private float mScalingRatio = 0.001f;
    private float mTranslationRatio = 0.09f;

    public CircularViewMode() {}

    public CircularViewMode(int circleOffset, float degToRad, float scalingRatio, float translationRatio) {
        mCircleOffset = circleOffset;
        mDegToRad = degToRad;
        mScalingRatio = scalingRatio;
        mTranslationRatio = translationRatio;

    }


    @Override
    public void applyToView(View v, RecyclerView parent) {
        float halfHeight = v.getHeight() * 0.5f;
        float parentHalfHeight = parent.getHeight() * 0.5f;
        float y = v.getY();
        float rot = parentHalfHeight - halfHeight - y;

        ViewCompat.setPivotX(v, 0.0f);
        ViewCompat.setPivotY(v, halfHeight);
        //旋转角度
        // ViewCompat.setRotation(v, rot * 0.05f);
        // +1.5 可调整其在屏幕中的位置
        ViewCompat.setTranslationX(v, (float)(-Math.cos(rot * mTranslationRatio * mDegToRad) + 1.4) * mCircleOffset);

        float scale = 1.0f - Math.abs(parentHalfHeight - halfHeight - y) * mScalingRatio + 0.3f;
//        LogUtils.d(TAG, "scale=" + scale);
        ViewCompat.setScaleX(v, scale);
        ViewCompat.setScaleY(v, scale);
    }
}
