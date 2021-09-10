package com.wangxingxing.homepageanim.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.wangxingxing.homepageanim.R;

import org.jetbrains.annotations.NotNull;

/**
 * author : 王星星
 * date : 2021/9/8 14:23
 * email : 1099420259@qq.com
 * description :
 */
public class SecondCommentAdapter extends ItemViewBinder<SecondCommentBean, SecondCommentAdapter.ViewHolder> {

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_comment_child, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, SecondCommentBean secondCommentBean) {
        viewHolder.mTvChild.setText(secondCommentBean.getComment());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvChild = itemView.findViewById(R.id.tv_child);
        }
    }
}
