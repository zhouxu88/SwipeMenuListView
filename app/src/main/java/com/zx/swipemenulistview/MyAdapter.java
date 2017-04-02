package com.zx.swipemenulistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 周旭 on 2017/4/2.
 */

public class MyAdapter extends BaseAdapter {

    private List<UserBean> mList;
    private LayoutInflater inflater;

    public MyAdapter(Context context,List<UserBean> mList) {
        this.mList = mList;
        inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_list_app,null,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //设置相关数据
        UserBean userBean = mList.get(position);
        holder.portraitIv.setImageResource(R.mipmap.ic_launcher);
        holder.nameTv.setText(userBean.getUsername());
        return convertView;
    }

    class ViewHolder {
        ImageView portraitIv;
        TextView nameTv;

        public ViewHolder(View view) {
            portraitIv = (ImageView) view.findViewById(R.id.iv_icon);
            nameTv = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
