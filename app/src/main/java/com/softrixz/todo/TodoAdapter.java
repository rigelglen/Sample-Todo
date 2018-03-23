package com.softrixz.todo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class TodoAdapter extends BaseAdapter {

    private Context ctx;
    private List<String> list;
    private LayoutInflater inflater;

    TodoAdapter(Context ctx, List<String> list) {
        this.ctx = ctx;
        this.list = list;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.todo_item, parent, false);
        TextView itemText = view.findViewById(R.id.itemText);

        itemText.setText(list.get(position));

        return view;

    }

}
