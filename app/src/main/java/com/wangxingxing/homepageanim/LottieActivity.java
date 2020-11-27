package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.bumptech.glide.Glide;

import java.io.File;

public class LottieActivity extends AppCompatActivity {

    private static final String TAG = "LottieActivity";

    public static final String VIDEO_PATH = "/storage/emulated/0/todo/download/demo.mp4";
    public static final String VIDEO_PATH_2 = "/storage/emulated/0/todo/download/demo2.mp4";
    public static final String VIDEO_PATH_3 = "/storage/emulated/0/todo/download/demo3.mp4";

    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    private LottieAnimationView lav;
    private ImageView mIvGifGlide;
    private ImageView mIvFrameAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        checkPermission();

        playAnim();

        playFrame();
    }

    private void playFrame() {
        mIvFrameAnim = findViewById(R.id.iv_frame);
        AnimationDrawable animationDrawable = (AnimationDrawable) mIvFrameAnim.getDrawable();
//        animationDrawable.stop();
        animationDrawable.selectDrawable(2);
//        animationDrawable.start();
    }

    private void playAnim() {
        lav = findViewById(R.id.lav);
        mIvGifGlide = findViewById(R.id.iv_gif_glide);
        Glide.with(this).load(R.raw.anim_voice).into(mIvGifGlide);

//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
//        animator.addUpdateListener(animation -> {
//            lav.setProgress((float)animation.getAnimatedValue());
//        });
//        animator.setDuration(2000);
//        animator.start();
//
//        lav.addAnimatorListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                LogUtils.i("onAnimationStart");
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                LogUtils.i("onAnimationEnd");
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                LogUtils.i("onAnimationCancel");
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                LogUtils.i("onAnimationRepeat");
//                animator.start();
//            }
//        });
//
//        lav.setRepeatCount(Integer.MAX_VALUE);
//        lav.playAnimation();
    }

    private void checkPermission() {
        if (!PermissionUtils.isGranted(permissions)) {
            PermissionUtils.permission(permissions).request();
        } else {
            getVideoInfo();
        }
    }

    private void getVideoInfo() {
        File videoFile = new File(VIDEO_PATH_3);
        Log.i(TAG, "getVideoInfo: length=" + videoFile.length());
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(this, Uri.fromFile(videoFile));
        String width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
        String rotation = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
        String height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
        Log.i(TAG, "getVideoInfo: width=" + width + ", height=" + height + ", rotation=" + rotation);
    }
}