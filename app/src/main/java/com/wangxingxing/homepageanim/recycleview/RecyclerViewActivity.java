package com.wangxingxing.homepageanim.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.wangxingxing.homepageanim.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author : 王星星
 * date : 2021/7/13 14:30
 * email : 1099420259@qq.com
 * description : 
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<LikeInfo> mLikeInfoList;
    private LikeAdapter mAdapter;

    public static final int[] imgResIds = {
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
        setContentView(R.layout.activity_recycler_view);

        initView();
//        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
//        atomicBoolean.compareAndSet(false, true);
        AtomicInteger count = new AtomicInteger(0);
        count.incrementAndGet();

        CountDownLatch countDownLatch = new CountDownLatch(100);
        Lock l = new ReentrantLock();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLikeInfoList = getLikeInfoList();
        mAdapter = new LikeAdapter(R.layout.item_like, mLikeInfoList);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.addChildClickViewIds(R.id.iv_hug);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_hug:
                        mLikeInfoList.get(position).likeType = 1;
                        mAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });
    }

    private List<LikeInfo> getLikeInfoList() {
        List<LikeInfo> likeInfoList = new ArrayList<>();
        for (int i = 0; i < imgResIds.length; i++) {
            likeInfoList.add(new LikeInfo("title-" + i, imgResIds[i], 0));
        }
        return likeInfoList;
    }


}