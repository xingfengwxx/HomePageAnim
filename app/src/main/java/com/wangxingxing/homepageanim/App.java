package com.wangxingxing.homepageanim;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.ycbjie.webviewlib.X5WebUtils;

/**
 * author : 王星星
 * date : 2020/8/5 19:50
 * email : 1099420259@qq.com
 * description :
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        X5WebUtils.init(this);

        initLog();

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        xcrash.XCrash.init(this);
    }

    private void initLog() {
        LogUtils.getConfig()
                .setLogSwitch(true)
                .setGlobalTag("wxx")
                .setBorderSwitch(true);
    }
}
