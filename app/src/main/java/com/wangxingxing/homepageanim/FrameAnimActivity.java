package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PathUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.bumptech.glide.Glide;
import com.tencent.qgame.animplayer.AnimConfig;
import com.tencent.qgame.animplayer.AnimView;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.util.ScaleType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class FrameAnimActivity extends AppCompatActivity implements IAnimListener {

    public static final String ANIM_VIDEO_PATH = PathUtils.getInternalAppDataPath() + File.separator + "loading.mp4";

    private AnimView mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        ImageView image = (ImageView) findViewById(R.id.iv_loading);
//        AnimationDrawable animationDrawable = (AnimationDrawable) image.getDrawable();
//        animationDrawable.stop();
//        animationDrawable.selectDrawable(0);
//        animationDrawable.start();

        Glide.with(this).load(R.drawable.matching_loading_4).into(image);

//        mAnimView = findViewById(R.id.playerView);
//        loadFile();

    }

    private void loadFile() {
        boolean isCopySuccess = ResourceUtils.copyFileFromAssets("loading.mp4", ANIM_VIDEO_PATH);
        if (isCopySuccess) {
            LogUtils.i("复制文件成功");
            LogUtils.i("文件MD5: " + FileUtils.getFileMD5ToString(ANIM_VIDEO_PATH));
            playVap();
        } else {
            LogUtils.i("复制文件失败");
        }
    }

    private void playVap() {
        mAnimView.setScaleType(ScaleType.FIT_CENTER);
        mAnimView.setAnimListener(this);
        new Thread() {
            @Override
            public void run() {
//                File file = getFileFromAssetsFile(getApplicationContext(), "loading.mp4");
                mAnimView.startPlay(new File(ANIM_VIDEO_PATH));
            }
        }.start();

    }

    @Override
    public void onVideoStart() {
        LogUtils.d();
    }

    @Override
    public void onVideoRender(int frameIndex, @Nullable AnimConfig config) {
        LogUtils.d();
    }

    @Override
    public void onVideoComplete() {
        LogUtils.d();
    }

    @Override
    public void onVideoDestroy() {
        LogUtils.d();
    }

    @Override
    public void onFailed(int errorType, @Nullable String errorMsg) {
        LogUtils.e(errorMsg);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        LogUtils.d();
    }

    @Override
    public boolean onVideoConfigReady(@NotNull AnimConfig config) {
        return false;
    }

    public static File getFileFromAssetsFile(Context context, String fileName){
        String path = "file:///android_asset/" + fileName;
        File file = new File(path);
        return file;
    }

}