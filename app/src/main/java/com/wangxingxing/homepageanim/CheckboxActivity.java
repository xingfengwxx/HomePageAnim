package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.wangxingxing.homepageanim.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class CheckboxActivity extends AppCompatActivity implements CheckboxAdapter.ItemCheckListener{

    private RecyclerView mRecyclerView;
    private List<ItemBean> mData;
    private CheckboxAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CheckboxAdapter(getData(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemCheck(int position, boolean isChecked) {
        mData.get(position).setCheck(isChecked);
//        mAdapter.notifyDataSetChanged();
    }

    private List<ItemBean> getData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mData.add(new ItemBean(false, "item---" + i));
        }
        return mData;
    }
}