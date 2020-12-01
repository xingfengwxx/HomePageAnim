package com.wangxingxing.homepageanim.flex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.blankj.utilcode.util.LogUtils;
import com.wangxingxing.homepageanim.R;

import java.util.List;

/**
 * author : 王星星
 * date : 2020/11/30 15:44
 * email : 1099420259@qq.com
 * description :
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<String> mData;

    public DataAdapter(List<String> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tag = mData.get(position % mData.size());
        holder.mTextView.setText(tag);

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.i("tag=" + tag);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_tag);
        }
    }
}
