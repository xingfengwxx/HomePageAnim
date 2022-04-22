package com.wangxingxing.homepageanim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : 王星星
 * date : 2022/4/18 15:14
 * email : 1099420259@qq.com
 * description :
 */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_ONE) {
            holder = new OneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one, parent, false));
        } else if (viewType == TYPE_TWO) {
            holder = new TwoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two, parent, false));
        } else {
            holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_default, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            ((OneViewHolder)holder).mTvContent.setText("TYPE_ONE_" + position);
        } else if (holder instanceof TwoViewHolder) {
            ((TwoViewHolder)holder).mTvContent.setText("TYPE_TWO_" + position);
        } else {
            ((ViewHolder)holder).mTvContent.setText("TYPE_DEFAULT_" + position);
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == TYPE_ONE) {
            return TYPE_ONE;
        } else if (position == TYPE_TWO) {
            return TYPE_TWO;
        }
        return TYPE_DEFAULT;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    static class OneViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContent;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    static class TwoViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvContent;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }


}
