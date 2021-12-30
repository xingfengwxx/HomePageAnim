package com.wangxingxing.homepageanim;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

/**
 * author : 王星星
 * date : 2021/11/26 16:13
 * email : 1099420259@qq.com
 * description :
 */
public class HelperAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HelperAdapter() {
        super(R.layout.item_helper);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder viewHolder, String s) {
        viewHolder.setText(R.id.tv_content, s);
    }
}
