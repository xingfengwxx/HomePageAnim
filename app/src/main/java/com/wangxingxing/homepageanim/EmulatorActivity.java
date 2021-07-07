package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.lahm.library.EasyProtectorLib;
import com.lahm.library.EmulatorCheckCallback;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.wangxingxing.homepageanim.bean.CheckEmulatorBean;

import java.text.SimpleDateFormat;

public class EmulatorActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emulator);

        mTvInfo = findViewById(R.id.tv_emulator_info);
        mTvResult = findViewById(R.id.tv_check_emulator_result);

        checkEmulator();

        createJson();
    }

    private void checkEmulator() {
        boolean result = isEmulator();
        StringBuffer sb = new StringBuffer();
        sb.append("easy-protector-release：").append(result);
        sb.append("\n");
        sb.append("antifake：").append(EmulatorDetectUtil.isEmulator(this));
        sb.append("\n");
        sb.append("DeviceUtils：").append(DeviceUtils.isEmulator());
        mTvResult.setText(sb.toString());
    }

    private boolean isEmulator() {
        boolean isEmulator = EasyProtectorLib.checkIsRunningInEmulator(this, new EmulatorCheckCallback() {
            @Override
            public void findEmulator(String emulatorInfo) {
                com.blankj.utilcode.util.LogUtils.d("emulatorInfo: " + emulatorInfo);
                mTvInfo.setText(emulatorInfo);
            }
        });
        return isEmulator;
    }

    private void createJson() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = TimeUtils.millis2String(System.currentTimeMillis(), simpleDateFormat);

        CheckEmulatorBean bean = new CheckEmulatorBean();
        bean.setCheckLevel(CheckEmulatorBean.CHECK_NOT);
        bean.setDate(date);
        bean.setVersionCode(1);

        LogUtils.i(GsonUtils.toJson(bean));
    }
}