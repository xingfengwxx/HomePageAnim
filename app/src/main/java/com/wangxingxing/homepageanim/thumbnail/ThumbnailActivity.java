package com.wangxingxing.homepageanim.thumbnail;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.video.VideoSize;
import com.wangxingxing.homepageanim.databinding.ActivityThumbnailBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class ThumbnailActivity extends AppCompatActivity {

    //竖屏 width=1080, height=1439
    public static final String IMG_URL_1 = "https://test.cdn.sbnh.cn/u72kD8xFZA_4cae-644068_9b9-380c-9548-91761d6be655.jpg";
    public static final String IMG_URL_2 = "https://test.cdn.sbnh.cn/u72kD8xFZA_653b-644609_642-31e0-acf3-6049fb768eab.jpg";
    public static final String IMG_URL_3 = "https://test.cdn.sbnh.cn/u72kD8xFZA_9f1a-645143_164-3f55-a3d5-33ded3e39462.jpg";

    //正方形 width=400, height=400
    public static final String IMG_URL_4 = "https://test.cdn.sbnh.cn/u72kD8xFZA_2__7da4-387881_C798C8B87A4FFB5792ECE1556C300682.jpg";

    //GIF width=252, height=222
    public static final String IMG_URL_5 = "https://test.cdn.sbnh.cn/u72kD8xFZA_2__5603-388271_b689-331002.gif";

    //长图 width=1080, height=3594
    public static final String IMG_URL_6 = "https://test.cdn.sbnh.cn/u72kD8xFZA_86c2-428225_Scree-shot_20211101_165338_c-.sb-h.todo.jpg";

    //横屏 width=4624, height=3472
    public static final String IMG_URL_7 = "https://test.cdn.sbnh.cn/8UgkOSxJZl69MG_28__2f4a-715031_IMG_20211024_073055.jpg";

    //竖屏 width=720, height=1280
    public static final String VIDEO_URL_1 = "https://test.cdn.sbnh.cn/8UgkOSxJZl69MG_18__6775-397008_xhs_1629363259904.mp4";
    //横屏 width=1920, height=1080
    public static final String VIDEO_URL_2 = "https://test.cdn.sbnh.cn/u72kD8xFZA_8946-541747_VID_20211110_160413.mp4";

    public static final String[] mImgUrls = new String[]{
            IMG_URL_1, IMG_URL_2, IMG_URL_3, IMG_URL_4,
            IMG_URL_5, IMG_URL_6, IMG_URL_7
    };

    //图片-横屏
    public static final int IMG_HORIZONTAL_WIDTH = 260;
    public static final int IMG_HORIZONTAL_HEIGHT = 145;

    //图片-竖屏
    public static final int IMG_VERTICAL_WIDTH = 145;
    public static final int IMG_VERTICAL_HEIGHT = 182;

    //图片-正方形
    public static final int IMG_SQUARE_SIZE = 210;

    //视频-横屏
    public static final int VIDEO_HORIZONTAL_WIDTH = 260;
    public static final int VIDEO_HORIZONTAL_HEIGHT = 154;

    //视频-竖屏
    public static final int VIDEO_VERTICAL_WIDTH = 145;
    public static final int VIDEO_VERTICAL_HEIGHT = 210;

    public static final int IMG_ORIENTATION_VERTICAL = 0;
    public static final int IMG_ORIENTATION_HORIZONTAL = 1;
    public static final int IMG_ORIENTATION_SQUARE = 2;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({IMG_ORIENTATION_VERTICAL, IMG_ORIENTATION_HORIZONTAL, IMG_ORIENTATION_SQUARE})
    public @interface ImgOrientation {
    }

    private int count = 0;

    private ExoPlayer mExoPlayer;

    private ActivityThumbnailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityThumbnailBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
//        LinearLayoutManager.VERTICAL
    }

    private void test() {
        try {
            throw new OutOfMemoryError("TEST");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void init() {
        mBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImg();
//                test();
            }
        });

        loadImg(IMG_URL_1);

//        long startTime = System.currentTimeMillis();
//        getVideoInfo(VIDEO_URL_2);
//        LogUtils.i("get video info duration: " + (System.currentTimeMillis() - startTime));

        initExoPlayer();

        initProgressBar();
    }

    private void initProgressBar() {


        mBinding.btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(mBinding.progressBar, "progress", 0, 100);
                objectAnimator.setInterpolator(new DecelerateInterpolator());
                objectAnimator.setDuration(5000);
                objectAnimator.start();
            }
        });
    }

    private void initExoPlayer() {
        mExoPlayer = new SimpleExoPlayer.Builder(this).build();
        mBinding.playerView.setPlayer(mExoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(VIDEO_URL_2);
        mExoPlayer.setMediaItem(mediaItem);
        mExoPlayer.prepare();
        mExoPlayer.play();

        mExoPlayer.addListener(new Player.Listener() {
            @Override
            public void onVideoSizeChanged(VideoSize videoSize) {
                LogUtils.i("video width=" + videoSize.width + ", height=" + videoSize.height);
                ViewGroup.LayoutParams layoutParams = mBinding.playerView.getLayoutParams();
                if (isVerticalVideo(videoSize.width, videoSize.height)) {
                     layoutParams.width = ConvertUtils.dp2px(VIDEO_VERTICAL_WIDTH);
                     layoutParams.height = ConvertUtils.dp2px(VIDEO_VERTICAL_HEIGHT);
                } else {
                    layoutParams.width = ConvertUtils.dp2px(VIDEO_HORIZONTAL_WIDTH);
                    layoutParams.height = ConvertUtils.dp2px(VIDEO_HORIZONTAL_HEIGHT);
                }

                mBinding.playerView.setLayoutParams(layoutParams);
            }
        });
    }

    private void loadImg() {
        count++;
        int index = count % mImgUrls.length;
        loadImg(mImgUrls[index]);
    }

    private void loadImg(String url) {
        Glide.with(this)
                .load(url)
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        // 在这里可以获得图片的宽高
                        int width = resource.getIntrinsicWidth();
                        int height = resource.getIntrinsicHeight();
                        LogUtils.i("src width=" + width + ", height=" + height);
                        setImageViewSize(mBinding.ivPic, width, height);

                        LogUtils.i("dest width=" + ConvertUtils.dp2px(IMG_HORIZONTAL_WIDTH) + ", height=" + ConvertUtils.dp2px(IMG_HORIZONTAL_HEIGHT));

                        Glide.with(ThumbnailActivity.this)
                                .load(resource)
//                                .transform(new RoundedCorners(ConvertUtils.dp2px(6)))
                                .apply(new RequestOptions().transform(new FitCenter(), new RoundedCorners(6)))
                                .into(mBinding.ivPic);

                        mBinding.ivPic.post(new Runnable() {
                            @Override
                            public void run() {
                                int viewWidth = mBinding.ivPic.getWidth();
                                int viewHeight = mBinding.ivPic.getHeight();
                                LogUtils.i("view width=" + viewWidth + ", height=" + viewHeight);
                            }
                        });
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    /**
     * 判断图片是竖屏、横屏或矩形
     *
     * @param width
     * @param height
     * @return
     */
    private @ImgOrientation
    int getImgOrientation(int width, int height) {
        if (width < height) {
            return IMG_ORIENTATION_VERTICAL;
        } else if (width == height) {
            return IMG_ORIENTATION_SQUARE;
        } else {
            return IMG_ORIENTATION_HORIZONTAL;
        }
    }

    private void setImageViewSize(ImageView imageView, int width, int height) {
        int orientation = getImgOrientation(width, height);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        switch (orientation) {
            case IMG_ORIENTATION_VERTICAL:
                layoutParams.width = ConvertUtils.dp2px(IMG_VERTICAL_WIDTH);
                layoutParams.height = ConvertUtils.dp2px(IMG_VERTICAL_HEIGHT);
                break;
            case IMG_ORIENTATION_HORIZONTAL:
                layoutParams.width = ConvertUtils.dp2px(IMG_HORIZONTAL_WIDTH);
                layoutParams.height = ConvertUtils.dp2px(IMG_HORIZONTAL_HEIGHT);
                break;
            case IMG_ORIENTATION_SQUARE:
                layoutParams.width = ConvertUtils.dp2px(IMG_SQUARE_SIZE);
                layoutParams.height = ConvertUtils.dp2px(IMG_SQUARE_SIZE);
                break;
        }
        imageView.setLayoutParams(layoutParams);
    }

    /**
     * 判断视频是竖屏还是横屏
     *
     * @param width
     * @param height
     * @return true:竖屏；false：横屏
     */
    private boolean isVerticalVideo(int width, int height) {
        return width < height;
    }

    /**
     * 根据URL获取视频信息
     *
     * @param url
     */
    private void getVideoInfo(String url) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        try {
            if (url != null) {
                Map<String, String> headers = null;
                if (headers == null) {
                    headers = new HashMap<>();
                    headers.put("userAgent", "Mozilla/5.0 (Linux; Android 9; MI 8 Build/PKQ1.180729.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/72.0.3626.121 Mobile Safari/537.36");
                }
                mmr.setDataSource(url, headers);

                String duration = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                String width = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
                String height = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
                LogUtils.i("video duration=" + duration + ", width=" + width + ", height=" + height);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mmr.release();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExoPlayer.release();
    }
}