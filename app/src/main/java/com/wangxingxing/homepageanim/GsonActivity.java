package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        init();
    }

    private void init() {

        String jsonStr = "{\"width\":2159,\"height\":1080,\"capturepath\":\"/storage/emulated/0/Android/data/cn.sbnh.todo/files/Screenshot376b23b1-d201-4fcf-a4ce-a436b2b86930.png\"}";
        HashMap map = GsonUtils.fromJson(jsonStr, new TypeToken<HashMap<String, Object>>() {
        }.getType());

        LogUtils.i("width: " + map.get("width") + ", capturepath: " + map.get("capturepath"));
    }
}