package com.example.jimmo__.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter{
    LayoutInflater inflater;
    Context con;
    ArrayList<item> itemList;

    MyListAdapter(Context con, ArrayList<item> itemList){
        this.con = con;
        this.itemList = itemList;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position
                ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item, null, false);

        item item = itemList.get(position);

        TextView type = (TextView) convertView.findViewById(R.id.name);
        TextView contents = (TextView) convertView.findViewById(R.id.content);

        type.setText(item.getName());
        contents.setText(item.getContents());


        return convertView;
    }
}