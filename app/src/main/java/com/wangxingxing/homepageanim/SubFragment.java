package com.wangxingxing.homepageanim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class SubFragment extends Fragment {

    private static final String TAG = "SubFragment";

    private RecyclerView mRecyclerView;
    private TestAdapter mAdapter;
    private List<String> mData;

    public SubFragment() {
        // Required empty public constructor
    }

    public static SubFragment newInstance() {
        SubFragment fragment = new SubFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        mAdapter = new TestAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
        Log.i(TAG, "onActivityCreated: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sub, container, false);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.i(TAG, "onCreateView: ");
        return rootView;
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mData.add("test---SubFragment---" + i);
        }
    }
}