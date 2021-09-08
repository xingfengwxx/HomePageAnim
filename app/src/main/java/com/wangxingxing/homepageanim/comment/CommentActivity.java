package com.wangxingxing.homepageanim.comment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.wangxingxing.homepageanim.R;
import com.wangxingxing.homepageanim.databinding.ActivityCommentBinding;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private ActivityCommentBinding mBinding;

    private NodeAdapter mNodeAdapter;

    private List<BaseNode> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {
        mNodeAdapter = new NodeAdapter();
        mBinding.recyclerView.setAdapter(mNodeAdapter);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
        mNodeAdapter.setList(mData);
        mNodeAdapter.addChildClickViewIds(R.id.tv_footer);
        mNodeAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_footer:
                        LogUtils.i("加载更多");
                        mNodeAdapter.nodeAddData(mNodeAdapter.getData().get(1), 5, getAddData());
//                        mNodeAdapter.notifyDataSetChanged();
                        break;
                }
            }
        });


    }

    private List<BaseNode> getData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            List<BaseNode> itemNodeList = new ArrayList<>();
            for (int n = 0; n < 5; n++) {
                ItemNode node = new ItemNode("child item - " + n);
                itemNodeList.add(node);
            }

            RootNode entity = new RootNode(itemNodeList, "parent item - " + i);
            mData.add(entity);
        }
        return mData;
    }

    private List<BaseNode> getAddData() {
        List<BaseNode> secondNodeList = new ArrayList<>();
        for (int n = 0; n < 5; n++) {
            ItemNode node = new ItemNode("child item - " + n);
            secondNodeList.add(node);
        }

        return secondNodeList;
    }

}