package com.wangxingxing.homepageanim.recycleview;

import androidx.annotation.IdRes;

/**
 * author : 王星星
 * date : 2021/7/13 11:19
 * email : 1099420259@qq.com
 * description :
 */
public class LikeInfo {

    public String title;

    @IdRes
    public int resId;

    public int likeType;

    public LikeInfo(String title, int resId, int likeType) {
        this.title = title;
        this.resId = resId;
        this.likeType = likeType;
    }
}
