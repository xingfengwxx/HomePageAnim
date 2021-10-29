package com.wangxingxing.homepageanim.imageviewer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.iielse.imageviewer.ImageViewerBuilder;
import com.wangxingxing.homepageanim.R;
import com.wangxingxing.homepageanim.databinding.ActivityImageViewerBinding;

import java.util.ArrayList;
import java.util.List;

public class ImageViewerActivity extends AppCompatActivity {

    private ActivityImageViewerBinding mBinding;

    public static final int[] mPicList = new int[] {
            R.drawable.pic_test_0,
            R.drawable.pic_test_1,
            R.drawable.pic_test_2,
//            R.drawable.pic_test_3,
//            R.drawable.pic_test_4,
//            R.drawable.pic_test_5,
//            R.drawable.pic_test_6,
//            R.drawable.pic_test_7,
//            R.drawable.pic_test_8,
    };

    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityImageViewerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();

        // ViewDragHelper,拖拽滑动帮助类
    }

    private void init() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mPicList.length; i++) {
            mFragmentList.add(PhotoFragment.newInstance(mPicList[i]));
        }
        mFragmentList.add(UserInfoFragment.newInstance());

//        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, mFragmentList);
//        mBinding.viewPager.setAdapter(myPagerAdapter);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT, mFragmentList);
        mBinding.viewPager.setAdapter(pagerAdapter);

        mBinding.viewPager.setOffscreenPageLimit(3);
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mPicList.length) {
                    mBinding.tvContent.setVisibility(View.GONE);
                } else {
                    mBinding.tvContent.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    static class MyPagerAdapter extends FragmentStateAdapter {

        private List<Fragment> mFragments;

        public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
            super(fragmentActivity);
            mFragments = fragments;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragments.size();
        }
    }

    static class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public PagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragments) {
            super(fm, behavior);
            mFragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}