package com.wangxingxing.homepageanim.recycleview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.wangxingxing.homepageanim.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/7/13 11:18
 * email : 1099420259@qq.com
 * description :
 */
public class LikeAdapter extends BaseQuickAdapter<LikeInfo, BaseViewHolder> {

    public LikeAdapter(int layoutResId, @Nullable List<LikeInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, LikeInfo likeInfo) {
        baseViewHolder.setText(R.id.tv_title, likeInfo.title);
        baseViewHolder.setImageResource(R.id.iv_pic, likeInfo.resId);

        LottieAnimationView lavHug = baseViewHolder.getView(R.id.lav_hug);
        if (likeInfo.likeType == 1) {
            lavHug.setVisibility(View.VISIBLE);
            lavHug.playAnimation();
            lavHug.addAnimatorListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    lavHug.setVisibility(View.GONE);
                }
            });
        } else {
            lavHug.setVisibility(View.GONE);
        }
    }
}
