package com.wangxingxing.homepageanim.flex;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexboxLayoutManager;

/**
 * author : 王星星
 * date : 2020/11/27 18:05
 * email : 1099420259@qq.com
 * description :
 */
public class MyFlexboxLayoutManager extends FlexboxLayoutManager {

    private float speedPerPixel = 10f;//滚动速率 越小越快 越大越慢
    private Context context;

    public MyFlexboxLayoutManager(Context context) {
        super(context);
        this.context = context;
    }

    public MyFlexboxLayoutManager(Context context, int flexDirection) {
        super(context, flexDirection);
    }

    public MyFlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        super(context, flexDirection, flexWrap);
    }

    public void setSpeedPerPixel(float speedPerPixel) {
        this.speedPerPixel = speedPerPixel;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller = new CenterSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }


    private class CenterSmoothScroller extends LinearSmoothScroller {

        CenterSmoothScroller(Context context) {
            super(context);
        }

        @Nullable
        @Override //滑动到目标索引
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return MyFlexboxLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        @Override // 滑动位置
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
        }

        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {// 控制滑动速度的
            return speedPerPixel;
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }

    public void setSpeedSlow() {
        speedPerPixel = context.getResources().getDisplayMetrics().density * 3f;
    }

    public void setSpeedFast() {
        speedPerPixel = context.getResources().getDisplayMetrics().density * 0.03f;
    }
}
