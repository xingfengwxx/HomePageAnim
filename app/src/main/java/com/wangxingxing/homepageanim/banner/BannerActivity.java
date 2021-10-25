package com.wangxingxing.homepageanim.banner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wangxingxing.homepageanim.R;
import com.wangxingxing.homepageanim.databinding.ActivityBannerBinding;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private ActivityBannerBinding mBinding;
    private ItemAdapter mAdapter;

    private View mHeaderView;
    private Banner mBanner;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBannerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {
        LogUtils.i();
        mData = new ArrayList<>();
        mAdapter = new ItemAdapter(R.layout.item_banner, mData);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mAdapter);

        mHeaderView = LayoutInflater.from(this).inflate(R.layout.header_banner, null);

        mAdapter.addHeaderView(mHeaderView);

        mData.addAll(getTestData());
        mAdapter.notifyDataSetChanged();

        initBanner();
    }

    private void initBanner() {
        mBanner = mHeaderView.findViewById(R.id.banner);
        mBanner.setAdapter(new BannerImageAdapter<String>(getBannerData()) {
            @Override
            public void onBindView(BannerImageHolder holder, String data, int position, int size) {
                Glide.with(holder.imageView)
                        .load(data)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        })
        .addBannerLifecycleObserver(this)
        .setIndicator(new CircleIndicator(this));
    }

    private List<String> getTestData() {
        List<String> testList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            testList.add("Item---" + i);
        }
        return testList;
    }

    private List<String> getBannerData() {
        List<String> bannerList = new ArrayList<>();
        bannerList.add("https://p1.meituan.net/movie/8130663f1e7d55570cdd74616460656d491654.jpg@464w_644h_1e_1c");
        bannerList.add("https://p1.meituan.net/mmdb/ceab1c48a4a1e2d9fe941757ee2f5152256864.jpg@464w_644h_1e_1c");
        bannerList.add("https://p0.meituan.net/mmdb/e93bb766c6fe26424f6f9609d99768de3910793.jpg@464w_644h_1e_1c");
        bannerList.add("https://p1.meituan.net/movie/e64b4bec8af164962559bdbe243ecb551138615.jpg@464w_644h_1e_1c");
        bannerList.add("https://p0.meituan.net/moviemachine/152f043cabbc6feb9153f89203872657977832.jpg@464w_644h_1e_1c");
        return bannerList;
    }
}