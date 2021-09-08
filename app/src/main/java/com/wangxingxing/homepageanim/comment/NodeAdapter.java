package com.wangxingxing.homepageanim.comment;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/9/6 18:02
 * email : 1099420259@qq.com
 * description :
 */
public class NodeAdapter extends BaseNodeAdapter {

    public NodeAdapter() {
        super();

        // 注册Provider，总共有如下三种方式

        // 需要占满一行的，使用此方法（例如section）
        addFullSpanNodeProvider(new RootNodeProvider());

        // 普通的item provider
        addNodeProvider(new SecondNodeProvider());

        // 脚布局的 provider
        addFooterNodeProvider(new RootFooterNodeProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends BaseNode> data, int i) {
        BaseNode node = data.get(i);
        if (node instanceof RootNode) {
            return 0;
        } else if (node instanceof ItemNode) {
            return 1;
        } else if (node instanceof RootFooterNode) {
            return 2;
        }
        return -1;
    }
}
