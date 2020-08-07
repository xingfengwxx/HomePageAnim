package com.wangxingxing.homepageanim.recycleview;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 *  author : 王星星
 *  date : 2020/7/27 19:15
 *  email : 1099420259@qq.com
 *  description : 
 */
public interface ItemViewMode {
    void applyToView(View v, RecyclerView parent);
}
