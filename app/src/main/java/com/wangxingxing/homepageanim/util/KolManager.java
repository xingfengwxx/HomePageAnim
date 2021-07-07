package com.wangxingxing.homepageanim.util;

/**
 * author : 王星星
 * date : 2021/6/17 19:28
 * email : 1099420259@qq.com
 * description : 身份标识
 */
public class KolManager {
    private static KolManager instance;

    private KolManager() {
    }

    public static KolManager getInstance() {
        if (instance == null) {
            synchronized (KolManager.class) {
                instance = new KolManager();
            }
        }
        return instance;
    }
}
