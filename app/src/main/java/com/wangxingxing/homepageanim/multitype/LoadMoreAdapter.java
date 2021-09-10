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
 * date : 2021/9/8 11:38
 * email : 1099420259@qq.com
 * description :
 */
public class LoadMoreAdapter extends ItemViewBinder<LoadMoreBean, LoadMoreAdapter.ViewHolder> {

    private LoadMoreListener mLoadMoreListener;

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        mLoadMoreListener = loadMoreListener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_comment_footer, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, LoadMoreBean loadMoreBean) {

        viewHolder.mTvFooter.setText(loadMoreBean.getTitle());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoadMoreListener != null) {
                    mLoadMoreListener.onLoadMore(viewHolder.getAbsoluteAdapterPosition());
                }
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvFooter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvFooter = itemView.findViewById(R.id.tv_footer);
        }
    }

    public interface LoadMoreListener {
        void onLoadMore(int position);
    }

}
