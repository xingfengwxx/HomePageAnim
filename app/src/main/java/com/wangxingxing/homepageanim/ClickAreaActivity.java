package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.wangxingxing.homepageanim.databinding.ActivityClickAreaBinding;

public class ClickAreaActivity extends AppCompatActivity {

    private ActivityClickAreaBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityClickAreaBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {
        ClickUtils.expandClickArea(mBinding.ivKol, ConvertUtils.dp2px(100));
        mBinding.ivKol.setOnClickListener(v -> {
            LogUtils.i("click kol---" + System.currentTimeMillis());
        });
    }
}