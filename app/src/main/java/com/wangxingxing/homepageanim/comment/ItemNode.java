package com.wangxingxing.homepageanim.comment;

import com.chad.library.adapter.base.entity.node.BaseNode;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/9/6 18:22
 * email : 1099420259@qq.com
 * description :
 */
public class ItemNode extends BaseNode {

    private String text;

    public ItemNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
