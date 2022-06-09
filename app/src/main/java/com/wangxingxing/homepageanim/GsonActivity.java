package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.wangxingxing.homepageanim.bean.DanceInfo;
import com.wangxingxing.homepageanim.bean.MetaMsgBean;

import java.util.HashMap;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        init();
    }

    private void init() {

//        String jsonStr = "{\"width\":2159,\"height\":1080,\"capturepath\":\"/storage/emulated/0/Android/data/cn.sbnh.todo/files/Screenshot376b23b1-d201-4fcf-a4ce-a436b2b86930.png\"}";
//        HashMap map = GsonUtils.fromJson(jsonStr, new TypeToken<HashMap<String, Object>>() {
//        }.getType());
//        LogUtils.i("width: " + map.get("width") + ", capturepath: " + map.get("capturepath"));

        // {"messageType":0,"message":"{\"title\":\"reqDanceTogether\",\"data\":{\"uid_self\":\"1008\",\"uid_other\":\"1007\",\"danceType\":\"JiaoJi\"}}"}

//        String jsonStr = "{\"messageType\":0,\"message\":\"{\\\"title\\\":\\\"reqDanceTogether\\\",\\\"data\\\":{\\\"uid_self\\\":\\\"1008\\\",\\\"uid_other\\\":\\\"1007\\\",\\\"danceType\\\":\\\"JiaoJi\\\"}}\"}";
        String jsonStr = "{\n" +
                "    \"messageType\": 0, \n" +
                "    \"message\": \"{\\\"title\\\":\\\"takephoto\\\",\\\"phase\\\":\\\"feedback\\\",\\\"data\\\":\\\"{\\\\\\\"width\\\\\\\":2259,\\\\\\\"height\\\\\\\":1080,\\\\\\\"capturepath\\\\\\\":\\\\\\\"/storage/emulated/0/Android/data/cn.sbnh.todo/files/Screenshot6fb1e48d-9d73-45a3-850f-4ef92ee2dec0.png\\\\\\\"}\\\"}\"\n" +
                "}";
        HashMap<String, Object> map = GsonUtils.fromJson(jsonStr, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        String message = (String) map.get("message");
        MetaMsgBean bean = GsonUtils.fromJson(message, MetaMsgBean.class);
        LogUtils.i("title: " + bean.title + ", phase: " + bean.phase + ", data: " + bean.data);

//        HashMap<String, Object> msgMap = GsonUtils.fromJson(message, new TypeToken<HashMap<String, Object>>() {
//        }.getType());
//        String title = (String) msgMap.get("title");
//        String data = (String) msgMap.get("data");
//        LogUtils.i("title: " + title + ", data: " + data);
    }
}