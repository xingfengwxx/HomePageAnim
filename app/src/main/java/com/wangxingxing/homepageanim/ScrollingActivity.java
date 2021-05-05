package com.wangxingxing.homepageanim;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.EncodeUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private static final String TAG = "ScrollingActivity";

    private AppBarLayout mAppBarLayout;
    private ConstraintLayout mClTitle;
    private ConstraintLayout mClTopTitle;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragmentList;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
        initEvent();
    }

    private void init() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        mAppBarLayout = findViewById(R.id.app_bar);
        mClTitle = findViewById(R.id.cl_title);
        mClTopTitle = findViewById(R.id.cl_top_title);
        mToolbar = findViewById(R.id.toolbar);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(SubFragment.newInstance());
        mFragmentList.add(SecondFragment.newInstance());

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initEvent() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d(TAG, state.name());
                if (state == State.EXPANDED) {
                    //展开状态
                    mClTitle.setVisibility(View.GONE);
                    mClTopTitle.setVisibility(View.GONE);
                    mToolbar.setBackgroundColor(Color.TRANSPARENT);
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    mClTitle.setVisibility(View.VISIBLE);
                    mClTopTitle.setVisibility(View.VISIBLE);
                    mToolbar.setBackgroundColor(Color.WHITE);
                } else {
                    //中间状态

                }

            }
        });
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        private Context mContext;

        private List<Fragment> mFragmentList;
        private final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};

        public MyPagerAdapter(Context context, @NonNull FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            mFragmentList = fragmentList;
            mContext = context;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mContext.getResources().getString(TAB_TITLES[position]);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}