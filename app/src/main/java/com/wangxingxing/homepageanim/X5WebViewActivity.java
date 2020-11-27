package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.webkit.ValueCallback;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.ycbjie.webviewlib.X5WebUtils;
import com.ycbjie.webviewlib.X5WebView;

import java.util.HashMap;

public class X5WebViewActivity extends AppCompatActivity {

    private X5WebView mX5WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5_web_view);

        mX5WebView = findViewById(R.id.web_view);

        PerUtils.checkPermission();



        mX5WebView.loadUrl("file:///android_asset/www/layabox-web/index.html");
//        mX5WebView.loadUrl("http://www.baidu.com");
//        mX5WebView.loadUrl("https://dev.sbnh.cn/help_page/");

//        initX5WebView();
    }

    private void sendAppInfo2JS() {
        String appInfo = "{\"cookie\":\"sid\\u003dabddd88f4db24d6eb438807bc2fee383\",\"imei\":\"a92bd76a-897f-4d52-99d4-b89878cfb104\",\"ipStr\":\"https://dev.sbnh.cn/\",\"language\":\"zh\",\"os\":\"xiaomi\",\"push_id\":\"Taf7jPAE1Em6WkX2tHpjBqAvPHxgdiamWuHrbSP281oAXnnwxmvgn9zedlFIY0tB\",\"sid\":\"abddd88f4db24d6eb438807bc2fee383\",\"tags\":[\"标签3\",\"薇恩\",\"赵信\",\"嘉文四世\",\"英勇之厅\",\"凯尔\",\"卢锡安\",\"德玛西亚钢\",\"光明使者神殿\",\"波比\",\"菲奥娜\",\"莫甘娜\",\"塞拉斯\"],\"token\":\"\",\"version\":\"v1.0.5\"}";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            mX5WebView.evaluateJavascript("javascript:if(window.getAppInfo){window.getAppInfo(' + " + appInfo + "');}", new com.tencent.smtt.sdk.ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {
                    LogUtils.d("sendAppInfo2JS receive value=" + s);
                }
            });
        }
    }

    private void initX5WebView() {
        // 在调用TBS初始化、创建WebView之前进行如下配置
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
    }
}