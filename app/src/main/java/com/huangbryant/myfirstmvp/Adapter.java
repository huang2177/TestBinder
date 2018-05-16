package com.huangbryant.myfirstmvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huangbryant.myfirstmvp.ui.IProductView;

import java.util.List;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public class Adapter extends BaseAdapter implements IProductView {
    private List<Movies.NewsBean> list;

    private TextView textViewTitle, textViewNum;
    private Context context;

    public Adapter(List<Movies.NewsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
        textViewNum = (TextView) convertView.findViewById(R.id.tv_num);
        textViewTitle = (TextView) convertView.findViewById(R.id.tv_title);

        textViewTitle.setText(list.get(position).getTitle());
        textViewNum.setText(list.get(position).getPhysical_label());

        return convertView;
    }

    @Override
    public void showProduct(List<Movies.NewsBean> list) {

    }
}
