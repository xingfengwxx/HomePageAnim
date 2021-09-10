package com.wangxingxing.homepageanim.comment;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/9/6 18:10
 * email : 1099420259@qq.com
 * description :
 */
public class RootNode extends BaseNode implements NodeFooterImp {

    private List<BaseNode> childNode;
    private String title;

    private int firstNodeIndex;

    public RootNode(List<BaseNode> childNode, String title, int firstNodeIndex) {
        this.childNode = childNode;
        this.title = title;
        this.firstNodeIndex = firstNodeIndex;
    }

    public String getTitle() {
        return title;
    }

    /**
     * {@link BaseNode}
     * 重写此方法，获取子节点。如果没有子节点，返回 null 或者 空数组
     * @return child nodes
     */
    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }

    /**
     * {@link NodeFooterImp}
     * （可选实现）
     * 重写此方法，获取脚部节点
     * @return
     */
    @Nullable
    @Override
    public BaseNode getFooterNode() {
        return new RootFooterNode("显示更多...", firstNodeIndex);
    }

    public void addNode(List<BaseNode> childNode) {
        this.childNode.addAll(childNode);
    }
}
