package com.wangxingxing.homepageanim.flex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.wangxingxing.homepageanim.R;

import java.util.ArrayList;
import java.util.List;

public class TagActivity extends AppCompatActivity {

    private AutoPollRecyclerView mRecyclerView;
    private List<String> mData;
    private DataAdapter mDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

       initView();
    }

    private void initView() {
        addTestData();

        mRecyclerView = findViewById(R.id.recycler_view);
        mDataAdapter = new DataAdapter(mData);
        mRecyclerView.setAdapter(mDataAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mRecyclerView.start();

//        startScroll();

    }

    private void addTestData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("tag-" + i);
        }
    }

    private void startScroll() {
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    mHandler.sendEmptyMessage(1);
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mRecyclerView){
            mRecyclerView.stop();
        }
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    break;
            }
        }
    };


}