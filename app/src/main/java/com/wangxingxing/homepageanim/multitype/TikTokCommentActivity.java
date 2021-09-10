package com.wangxingxing.homepageanim.multitype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.drakeet.multitype.MultiTypeAdapter;
import com.wangxingxing.homepageanim.R;
import com.wangxingxing.homepageanim.databinding.ActivityTikTokCommentBinding;

import java.util.ArrayList;
import java.util.List;

public class TikTokCommentActivity extends AppCompatActivity {

    private ActivityTikTokCommentBinding mBinding;

    private MultiTypeAdapter mMultiTypeAdapter;
    private List<Object> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityTikTokCommentBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {

        LoadMoreAdapter loadMoreAdapter = new LoadMoreAdapter();
        FirstCommentAdapter firstCommentAdapter = new FirstCommentAdapter();
        SecondCommentAdapter secondCommentAdapter = new SecondCommentAdapter();

        mMultiTypeAdapter = new MultiTypeAdapter();
        mMultiTypeAdapter.register(LoadMoreBean.class, loadMoreAdapter);
        mMultiTypeAdapter.register(FirstCommentBean.class, firstCommentAdapter);
        mMultiTypeAdapter.register(SecondCommentBean.class, secondCommentAdapter);

        mData = new ArrayList<>();
        mMultiTypeAdapter.setItems(mData);

        mBinding.recyclerView.setAdapter(mMultiTypeAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addTestData();
        mMultiTypeAdapter.notifyDataSetChanged();

        loadMoreAdapter.setLoadMoreListener(new LoadMoreAdapter.LoadMoreListener() {
            @Override
            public void onLoadMore(int position) {
                List<SecondCommentBean> moreList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    moreList.add(new SecondCommentBean("child item more - " + i));
                }
                mData.addAll(position, moreList);
                mMultiTypeAdapter.setItems(mData);
                mMultiTypeAdapter.notifyItemRangeChanged(position, 6);
            }
        });
    }

    private void addTestData() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mData.add(new FirstCommentBean("parent item - " + i));
            } else {
                mData.add(new FirstCommentBean("parent item - " + i));
                for (int j = 0; j < 3; j++) {
                    mData.add(new SecondCommentBean("child item - " + j));
                }
                mData.add(new LoadMoreBean("加载更多"));
            }
        }
    }
}