package com.wangxingxing.homepageanim;

import android.Manifest;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;

/**
 * author : 王星星
 * date : 2020/11/16 10:14
 * email : 1099420259@qq.com
 * description :
 */
public class PerUtils {

    private static String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    public static void checkPermission() {
        if (!PermissionUtils.isGranted(permissions)) {
            PermissionUtils.permission(permissions).request();
        } else {
            LogUtils.e("已获取权限");
        }
    }
}
