package com.wangxingxing.homepageanim;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

public class WindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);

        getWindow().setBackgroundDrawableResource(R.mipmap.icon_voice_bg);

        test();
    }

    private void test() {
        // todoapp://clickHeadPortrait?userData={"id":"5fe96881c178e67dd6b7ebf0","nickName":"%E4%B8%BD%E8%99%B9&money","header":"icon_female_b","tags":["%E5%81%A5%E8%BA%AB","%E7%94%B5%E5%BD%B1","%E6%BB%91%E6%9D%BF","%E7%A9%BF%E6%90%AD","%E9%98%85%E8%AF%BB","%E6%AD%A3%E8%83%BD%E9%87%8F","%E4%B9%90%E5%A4%A9%E6%B4%BE","%E6%B2%99%E9%9B%95","%E6%84%9F%E6%80%A7","%E5%8F%8C%E7%9C%BC%E7%9A%AE","%E6%89%BE%E9%99%AA%E4%BC%B4"],"matchingType":null,"matchingPurpose":"%E8%81%8A%E6%BB%A115%E5%88%86%E9%92%9F%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%81%9A%E4%B8%80%E5%91%A8CP%E5%90%A7","matchingSex":0,"tcCloudUserSig":"eJw9jl0LgjAYhf-LrkM2nfsQugqxwIhQiS7d9ipDk6EWVvTfE40uz8dzOG*Up5kHk7M9oIhhKjDeLN4DehQh38No1YNpSuesQRGhGAdchixYE2ugG21lFyCsQDIhiCZcAOPGMMVBVf8VW8*ltjgWPs3qq5Zu6OLDc3IquZ8gf7XlLjkPGpq0idVlb-T2B472Nh8kDEsS*ISRzxep0zbg","birthday":697737600000,"sex":2,"matchingTime":1609132462094}
        // "todoapp://clickHeadPortrait?userData={\"id\":\"5fe96881c178e67dd6b7ebf0\",\"nickName\":\"%E4%B8%BD%E8%99%B9=money\",\"header\":\"icon_female_b\",\"tags\":[\"%E5%81%A5%E8%BA%AB\",\"%E7%94%B5%E5%BD%B1\",\"%E6%BB%91%E6%9D%BF\",\"%E7%A9%BF%E6%90%AD\",\"%E9%98%85%E8%AF%BB\",\"%E6%AD%A3%E8%83%BD%E9%87%8F\",\"%E4%B9%90%E5%A4%A9%E6%B4%BE\",\"%E6%B2%99%E9%9B%95\",\"%E6%84%9F%E6%80%A7\",\"%E5%8F%8C%E7%9C%BC%E7%9A%AE\",\"%E6%89%BE%E9%99%AA%E4%BC%B4\"],\"matchingType\":null,\"matchingPurpose\":\"%E8%81%8A%E6%BB%A115%E5%88%86%E9%92%9F%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%81%9A%E4%B8%80%E5%91%A8CP%E5%90%A7\",\"matchingSex\":0,\"tcCloudUserSig\":\"eJw9jl0LgjAYhf-LrkM2nfsQugqxwIhQiS7d9ipDk6EWVvTfE40uz8dzOG*Up5kHk7M9oIhhKjDeLN4DehQh38No1YNpSuesQRGhGAdchixYE2ugG21lFyCsQDIhiCZcAOPGMMVBVf8VW8*ltjgWPs3qq5Zu6OLDc3IquZ8gf7XlLjkPGpq0idVlb-T2B472Nh8kDEsS*ISRzxep0zbg\",\"birthday\":697737600000,\"sex\":2,\"matchingTime\":1609132462094}"
        Uri uri = Uri.parse("todoapp://clickHeadPortrait?userData={\"id\":\"5fe96881c178e67dd6b7ebf0\",\"nickName\":\"%E4%B8%BD%E8%99%B9&money\",\"header\":\"icon_female_b\",\"tags\":[\"%E5%81%A5%E8%BA%AB\",\"%E7%94%B5%E5%BD%B1\",\"%E6%BB%91%E6%9D%BF\",\"%E7%A9%BF%E6%90%AD\",\"%E9%98%85%E8%AF%BB\",\"%E6%AD%A3%E8%83%BD%E9%87%8F\",\"%E4%B9%90%E5%A4%A9%E6%B4%BE\",\"%E6%B2%99%E9%9B%95\",\"%E6%84%9F%E6%80%A7\",\"%E5%8F%8C%E7%9C%BC%E7%9A%AE\",\"%E6%89%BE%E9%99%AA%E4%BC%B4\"],\"matchingType\":null,\"matchingPurpose\":\"%E8%81%8A%E6%BB%A115%E5%88%86%E9%92%9F%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%81%9A%E4%B8%80%E5%91%A8CP%E5%90%A7\",\"matchingSex\":0,\"tcCloudUserSig\":\"eJw9jl0LgjAYhf-LrkM2nfsQugqxwIhQiS7d9ipDk6EWVvTfE40uz8dzOG*Up5kHk7M9oIhhKjDeLN4DehQh38No1YNpSuesQRGhGAdchixYE2ugG21lFyCsQDIhiCZcAOPGMMVBVf8VW8*ltjgWPs3qq5Zu6OLDc3IquZ8gf7XlLjkPGpq0idVlb-T2B472Nh8kDEsS*ISRzxep0zbg\",\"birthday\":697737600000,\"sex\":2,\"matchingTime\":1609132462094}");
        LogUtils.i("getQuery=" + uri.getQuery());
        LogUtils.i("getEncodedQuery=" + uri.getEncodedQuery());
        String userData = uri.getQueryParameter("userData");
        LogUtils.i("userData=" + userData);

        String queryStr = uri.getQuery();
        String[] strs = queryStr.split("=");
        LogUtils.i(strs);


        if (uri.toString().contains("&")) {
            LogUtils.i("uri contains &");
        }

        String subStr = queryStr.substring(queryStr.indexOf("{"));
        LogUtils.i("subStr=" + subStr);
    }
}