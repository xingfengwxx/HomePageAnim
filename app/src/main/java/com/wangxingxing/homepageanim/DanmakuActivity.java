package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.HashMap;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class DanmakuActivity extends AppCompatActivity {

    private DanmakuView mDanmakuView;
    private DanmakuContext mDanmakuContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danmaku);

        mDanmakuView = findViewById(R.id.danmaku_view);
        initDanmaku();
        startDanmaku();
    }

    private void initDanmaku() {
        //设置最大显示行数
        HashMap<Integer, Integer> maxLInesPair = new HashMap<>(5);
        maxLInesPair.put(BaseDanmaku.TYPE_SCROLL_RL, 8);
        //设置是否禁止重叠
        HashMap<Integer, Boolean> overlappingEnablePair = new HashMap<>(16);
        overlappingEnablePair.put(BaseDanmaku.TYPE_SCROLL_RL, true);
        overlappingEnablePair.put(BaseDanmaku.TYPE_FIX_TOP, true);
        //创建弹幕上下文
        mDanmakuContext = DanmakuContext.create();
        //设置一些相关的配置
        mDanmakuContext.setDuplicateMergingEnabled(false)
                //是否重复合并
                .setScrollSpeedFactor(1.2f)
                //设置文字的比例
                .setScaleTextSize(1.2f)
                //图文混排的时候使用！这里可以不用
//                .setCacheStuffer(new MyCacheStuffer(mActivity), mBackgroundCacheStuffer)
                //设置显示最大行数
                .setMaximumLines(maxLInesPair)
                //设置防，null代表可以重叠
                .preventOverlapping(overlappingEnablePair);
        //设置解析器
        BaseDanmakuParser defaultDanmakuParser = getDefaultDanmakuParser();


        mDanmakuView.setCallback(new master.flame.danmaku.controller.DrawHandler.Callback() {
            @Override
            public void updateTimer(DanmakuTimer timer) {
                //定时器更新的时候回掉
            }

            @Override
            public void drawingFinished() {
                //弹幕绘制完成时回掉
            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {
                //弹幕展示的时候回掉
            }

            @Override
            public void prepared() {
                //弹幕准备好的时候回掉，这里启动弹幕
                mDanmakuView.start();
            }
        });
        mDanmakuView.prepare(defaultDanmakuParser, mDanmakuContext);
        mDanmakuView.enableDanmakuDrawingCache(true);
    }

    private void startDanmaku() {

//        for (int i = 0; i < 100; i++) {
//
//        }

        mDanmakuView.postDelayed(new Runnable() {
            @Override
            public void run() {
                addDanmaku(false);
            }
        }, 3000);
    }

    private void addDanmaku(boolean islive) {
        //创建一个弹幕对象，这里后面的属性是设置滚动方向的！
        BaseDanmaku danmaku = mDanmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        if (danmaku == null || mDanmakuView == null) {
            return;
        }
        //弹幕显示的文字
        danmaku.text = "这是一条弹幕" + System.nanoTime();
        //设置相应的边距，这个设置的是四周的边距
        danmaku.padding = 5;
        // 可能会被各种过滤器过滤并隐藏显示，若果是本机发送的弹幕，建议设置成1；
        danmaku.priority = 0;
        //是否是直播弹幕
        danmaku.isLive = islive;
        danmaku.setTime(mDanmakuView.getCurrentTime() + 1200);
        //设置文字大小
        danmaku.textSize = 25f;
        //设置文字颜色
        danmaku.textColor = Color.RED;
        //设置阴影的颜色
        danmaku.textShadowColor = Color.WHITE;
        // danmaku.underlineColor = Color.GREEN;
        //设置背景颜色
        danmaku.borderColor = Color.GREEN;
        //添加这条弹幕，也就相当于发送
        mDanmakuView.addDanmaku(danmaku);

    }

    public static BaseDanmakuParser getDefaultDanmakuParser() {
        return new BaseDanmakuParser() {
            @Override
            protected IDanmakus parse() {
                return new Danmakus();
            }
        };
    }

}