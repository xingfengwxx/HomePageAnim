package com.wangxingxing.homepageanim.flex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.wangxingxing.homepageanim.R;

import java.util.ArrayList;
import java.util.Calendar;

public class FlexActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private ArrayList<SearchHistoryBean> mSearchHistoryBeanArrayList;
    private SearchHistoryAdapter mSearchHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex);

        initViews();
        initDatas();
        initEvents();

    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recycler_view);
//        mRecyclerView.addOnScrollListener(onScrollListenerTwo);
    }

    private void initDatas() {
        //初始化集合
        mSearchHistoryBeanArrayList = new ArrayList<SearchHistoryBean>();
        String[] testDatas = new String[]{
                "牙刷","灭蚊器","移动空调","吸尘器","布衣柜","收纳箱 书箱","暑期美食满99减15","挂烫机","吸水拖把","反季特惠",
                "牙刷-2","灭蚊器-2","移动空调-2","吸尘器-2","布衣柜-2","收纳箱 书箱-2","暑期美食满99减15-2","挂烫机-2","吸水拖把-2","反季特惠-2",
                "牙刷-3333333","灭蚊器-3333333","移动空调-3333333","吸尘器-3333333","布衣柜-3333333","收纳箱 书箱-3333333","暑期美食满99减15-3333333","挂烫机-3333333","吸水拖把-3333333","反季特惠-3333333"
        };
        for(int i=0; i<testDatas.length;i++){
            SearchHistoryBean channelBean = new SearchHistoryBean();
            channelBean.setSearchTitle(testDatas[i]);
            //获取当前日期
            Calendar calendar = Calendar.getInstance();
            channelBean.setSearchDate(calendar.getTime());

            mSearchHistoryBeanArrayList.add(channelBean);
        }

        //设置布局管理器
        MyFlexboxLayoutManager flexboxLayoutManager = new MyFlexboxLayoutManager(this);
        //flexDirection 属性决定主轴的方向（即项目的排列方向）。类似 LinearLayout 的 vertical 和 horizontal。
        flexboxLayoutManager.setFlexDirection(FlexDirection.COLUMN);//主轴为水平方向，起点在左端。
        //flexWrap 默认情况下 Flex 跟 LinearLayout 一样，都是不带换行排列的，但是flexWrap属性可以支持换行排列。
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);//按正常方向换行
        //justifyContent 属性定义了项目在主轴上的对齐方式。
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);//交叉轴的起点对齐。
        //设置滚动速度
//        flexboxLayoutManager.setSpeedSlow();

//        LooperLayoutManager layoutManager = new LooperLayoutManager();
//        layoutManager.setLooperEnable(true);

        mRecyclerView.setLayoutManager(flexboxLayoutManager);

        //设置适配器
        if(mSearchHistoryAdapter == null){
            //设置适配器
            mSearchHistoryAdapter = new SearchHistoryAdapter(this, mSearchHistoryBeanArrayList);
            mRecyclerView.setAdapter(mSearchHistoryAdapter);
            //添加分割线
            //设置添加删除动画
            //调用ListView的setSelected(!ListView.isSelected())方法，这样就能及时刷新布局
            mRecyclerView.setSelected(true);
        }else{
            mSearchHistoryAdapter.notifyDataSetChanged();
        }
    }

    private void initEvents() {
        //列表适配器的点击监听事件
        mSearchHistoryAdapter.setOnItemClickLitener(new SearchHistoryAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(FlexActivity.this, mSearchHistoryBeanArrayList.get(position).getSearchTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    RecyclerView.OnScrollListener onScrollListenerTwo = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            isVisBottom(recyclerView);
        }
    };

    public void isVisBottom(RecyclerView recyclerView) {
        MyFlexboxLayoutManager linearLayoutManager = (MyFlexboxLayoutManager) recyclerView.getLayoutManager();
        if (!recyclerView.canScrollHorizontally(-1)) {//当前在顶部
            recyclerView.smoothScrollToPosition(linearLayoutManager.getItemCount() - 1);
        }
        if (!recyclerView.canScrollHorizontally(1)) {//当前在底部
            recyclerView.smoothScrollToPosition(0);
        }
    }
}
