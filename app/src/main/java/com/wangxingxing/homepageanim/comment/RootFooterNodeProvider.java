package com.wangxingxing.homepageanim.comment;

import android.util.TimeUtils;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.wangxingxing.homepageanim.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RootFooterNodeProvider extends BaseNodeProvider {

    public RootFooterNodeProvider() {
        addChildClickViewIds(R.id.tv_footer);
    }

    @Override
    public int getItemViewType() {
        return 2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_comment_footer;
    }

    @Override
    public void convert(@NotNull BaseViewHolder helper, @Nullable BaseNode data) {
        RootFooterNode entity = (RootFooterNode) data;
        helper.setText(R.id.tv_footer, entity.getTitle());
    }

    @Override
    public void onChildClick(@NotNull BaseViewHolder helper, @NotNull View view, BaseNode data, int position) {
        if (view.getId() == R.id.tv_footer) {
            ToastUtils.showShort("Footer Node Click : " + position);
        }
    }

}
