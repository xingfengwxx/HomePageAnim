package com.wangxingxing.homepageanim.comment;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RootFooterNode extends BaseNode {

    private String title;
    private int firstNodeIndex;

    public RootFooterNode(String title, int firstNodeIndex) {
        this.title = title;
        this.firstNodeIndex = firstNodeIndex;
    }

    public String getTitle() {
        return title;
    }

    public int getFirstNodeIndex() {
        return firstNodeIndex;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
