package com.wangxingxing.homepageanim.banner;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.wangxingxing.homepageanim.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/10/5 11:11
 * email : 1099420259@qq.com
 * description :
 */
public class ItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ItemAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.tv_content, s);
    }
}
