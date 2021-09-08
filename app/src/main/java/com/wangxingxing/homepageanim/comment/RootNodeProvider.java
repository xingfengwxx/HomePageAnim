package com.wangxingxing.homepageanim.comment;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.wangxingxing.homepageanim.R;

import org.jetbrains.annotations.NotNull;

/**
 * author : 王星星
 * date : 2021/9/6 18:04
 * email : 1099420259@qq.com
 * description :
 */
public class RootNodeProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_comment_parent;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, BaseNode data) {
        RootNode entity = (RootNode) data;
        helper.setText(R.id.tv_parent, entity.getTitle());
    }
}
