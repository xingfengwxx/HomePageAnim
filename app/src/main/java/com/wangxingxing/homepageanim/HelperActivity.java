package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.wangxingxing.homepageanim.databinding.ActivityHelperBinding;

import java.util.ArrayList;
import java.util.List;

public class HelperActivity extends AppCompatActivity {

    private ActivityHelperBinding mBinding;
    private HelperAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHelperBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HelperAdapter();
//        mAdapter.setEmptyView(R.layout.empty_helper);
        mAdapter.setUseEmpty(true);
        mBinding.recyclerView.setAdapter(mAdapter);

//        mAdapter.setList(null);

//        List<String> data = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            data.add("哈撒给---" + i);
//        }
//        mAdapter.setList(data);

        mBinding.recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setEmptyView(R.layout.empty_helper);
            }
        }, 1000);
    }
}