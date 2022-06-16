package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CountDownTimerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CountDownTimerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CountDownTimerAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setGetTime(System.currentTimeMillis());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cancelAllTimers();
    }
}