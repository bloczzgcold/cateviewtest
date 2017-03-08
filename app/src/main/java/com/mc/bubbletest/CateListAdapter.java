package com.mc.bubbletest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhenguo on 2017/3/8.
 */

public class CateListAdapter extends BaseAdapter {

    Context context;

    private List<Cate> mData = new ArrayList<>();

    public CateListAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Cate> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CateViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cate_layout,null);
            holder = new CateViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (CateViewHolder) convertView.getTag();
        }
        holder.tvCate.setText(mData.get(position).getName());

        return convertView;
    }

    class CateViewHolder{
        TextView tvCate;

        public CateViewHolder(View view){
            tvCate = (TextView) view.findViewById(R.id.tv_item_cate);
        }
    }
}
