package com.wangxingxing.homepageanim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wangxingxing.homepageanim.bean.ItemBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author : 王星星
 * date : 2021/6/2 12:07
 * email : 1099420259@qq.com
 * description :
 */
public class CheckboxAdapter extends RecyclerView.Adapter<CheckboxAdapter.ViewHolder> {

    private List<ItemBean> mData;
    private ItemCheckListener mItemCheckListener;

    public CheckboxAdapter(List<ItemBean> data, ItemCheckListener itemCheckListener) {
        mData = data;
        mItemCheckListener = itemCheckListener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkbox, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        //在初始化checkBox状态和设置状态变化监听事件之前先把状态变化监听事件设置为null
        holder.mCheckBox.setOnCheckedChangeListener(null);

        holder.mCheckBox.setChecked(mData.get(position).isCheck());
        holder.mTvContent.setText(mData.get(position).getContent());

        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mItemCheckListener.onItemCheck(position, isChecked);
                mData.get(position).setCheck(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox mCheckBox;
        private TextView mTvContent;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mCheckBox = itemView.findViewById(R.id.checkbox);
            mTvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    public interface ItemCheckListener {
        void onItemCheck(int position, boolean isChecked);
    }
}
