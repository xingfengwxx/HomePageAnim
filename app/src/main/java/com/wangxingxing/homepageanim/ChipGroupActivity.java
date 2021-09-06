package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.wangxingxing.homepageanim.databinding.ActivityChipGroupBinding;
import com.wangxingxing.homepageanim.databinding.ActivityClickAreaBinding;

public class ChipGroupActivity extends AppCompatActivity {

    private static final String TAG = "ChipGroupActivity";

    private ActivityChipGroupBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityChipGroupBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initView();
        LogUtils.i("View.VISIBLE=" + View.VISIBLE);
    }

    private void initView() {

        for (int i = 0; i < 20; i++) {
            mBinding.chipGroup.addView(createChip("chip-------" + i));
        }

        mBinding.chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                LogUtils.i("checkedId=" + checkedId);
            }
        });
    }

    private Chip createChip(String text) {
//        Chip chip = new Chip(this);
        Chip chip = (Chip)getLayoutInflater().inflate(R.layout.layout_single_chip, mBinding.chipGroup, false);
        chip.setText(text);
        return chip;
    }
}