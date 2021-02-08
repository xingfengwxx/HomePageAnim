package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.ycbjie.webviewlib.X5WebUtils;
import com.ycbjie.webviewlib.X5WebView;

import java.util.HashMap;

public class X5WebViewActivity extends AppCompatActivity {

    private X5WebView mX5WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5_web_view);

        PerUtils.checkPermission();

        mX5WebView = findViewById(R.id.web_view);

//        mX5WebView.loadUrl("file:///android_asset/www/layabox-web/index.html");
//        mX5WebView.loadUrl("http://www.baidu.com");
        mX5WebView.loadUrl("https://dev.sbnh.cn/help_page/");

        initEvent();
        test();
    }

    private void test() {
        // todoapp://clickHeadPortrait?userData={"id":"5fe96881c178e67dd6b7ebf0","nickName":"%E4%B8%BD%E8%99%B9&money","header":"icon_female_b","tags":["%E5%81%A5%E8%BA%AB","%E7%94%B5%E5%BD%B1","%E6%BB%91%E6%9D%BF","%E7%A9%BF%E6%90%AD","%E9%98%85%E8%AF%BB","%E6%AD%A3%E8%83%BD%E9%87%8F","%E4%B9%90%E5%A4%A9%E6%B4%BE","%E6%B2%99%E9%9B%95","%E6%84%9F%E6%80%A7","%E5%8F%8C%E7%9C%BC%E7%9A%AE","%E6%89%BE%E9%99%AA%E4%BC%B4"],"matchingType":null,"matchingPurpose":"%E8%81%8A%E6%BB%A115%E5%88%86%E9%92%9F%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%81%9A%E4%B8%80%E5%91%A8CP%E5%90%A7","matchingSex":0,"tcCloudUserSig":"eJw9jl0LgjAYhf-LrkM2nfsQugqxwIhQiS7d9ipDk6EWVvTfE40uz8dzOG*Up5kHk7M9oIhhKjDeLN4DehQh38No1YNpSuesQRGhGAdchixYE2ugG21lFyCsQDIhiCZcAOPGMMVBVf8VW8*ltjgWPs3qq5Zu6OLDc3IquZ8gf7XlLjkPGpq0idVlb-T2B472Nh8kDEsS*ISRzxep0zbg","birthday":697737600000,"sex":2,"matchingTime":1609132462094}
        Uri uri = Uri.parse("todoapp://clickHeadPortrait?userData={\"id\":\"5fe96881c178e67dd6b7ebf0\",\"nickName\":\"%E4%B8%BD%E8%99%B9&money\",\"header\":\"icon_female_b\",\"tags\":[\"%E5%81%A5%E8%BA%AB\",\"%E7%94%B5%E5%BD%B1\",\"%E6%BB%91%E6%9D%BF\",\"%E7%A9%BF%E6%90%AD\",\"%E9%98%85%E8%AF%BB\",\"%E6%AD%A3%E8%83%BD%E9%87%8F\",\"%E4%B9%90%E5%A4%A9%E6%B4%BE\",\"%E6%B2%99%E9%9B%95\",\"%E6%84%9F%E6%80%A7\",\"%E5%8F%8C%E7%9C%BC%E7%9A%AE\",\"%E6%89%BE%E9%99%AA%E4%BC%B4\"],\"matchingType\":null,\"matchingPurpose\":\"%E8%81%8A%E6%BB%A115%E5%88%86%E9%92%9F%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%81%9A%E4%B8%80%E5%91%A8CP%E5%90%A7\",\"matchingSex\":0,\"tcCloudUserSig\":\"eJw9jl0LgjAYhf-LrkM2nfsQugqxwIhQiS7d9ipDk6EWVvTfE40uz8dzOG*Up5kHk7M9oIhhKjDeLN4DehQh38No1YNpSuesQRGhGAdchixYE2ugG21lFyCsQDIhiCZcAOPGMMVBVf8VW8*ltjgWPs3qq5Zu6OLDc3IquZ8gf7XlLjkPGpq0idVlb-T2B472Nh8kDEsS*ISRzxep0zbg\",\"birthday\":697737600000,\"sex\":2,\"matchingTime\":1609132462094}");
        String userData = uri.getQueryParameter("userData");
        LogUtils.i("userData=" + userData);
    }

    private void initEvent() {
        mX5WebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                sendAppInfo2JS();
            }
        });
    }

    private void sendAppInfo2JS() {
        String appInfo = "{\"cookie\":\"sid\\u003d906fe112018a436d9e51355462fb4848\",\"imei\":\"5a0ef820-454c-4791-94d5-d0bb3b20e61a\",\"ipStr\":\"https://dev.sbnh.cn/\",\"language\":\"zh\",\"os\":\"xiaomi\",\"push_id\":\"AIEPczmla3iFN1mGdYy80bqw9WQs6Kf9Qd6gnfpZ6bQicwhJRmRah8/0luEbK+VN\",\"sid\":\"906fe112018a436d9e51355462fb4848\",\"tags\":[\"英雄联盟\",\"苍井空\",\"游戏\",\"留学生\",\"厨师\",\"医生\",\"记者\",\"健身\",\"企业高管\",\"白领\",\"程序员\",\"行政\",\"运营喵\"],\"token\":\"\",\"version\":\"v1.2.0\"}";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            mX5WebView.evaluateJavascript("javascript:if(window.getAppInfo){window.getAppInfo(' + " + appInfo + "');}", new com.tencent.smtt.sdk.ValueCallback<String>() {
                @Override
                public void onReceiveValue(String s) {
                    LogUtils.d("sendAppInfo2JS receive value=" + s);
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mX5WebView != null) {
            mX5WebView.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mX5WebView != null) {
            mX5WebView.getSettings().setJavaScriptEnabled(false);
        }
    }

}