package com.relucks.helpers.base;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {

    public BaseRecyclerAdapter(List<T> items) {
        this.items = items;
    }

    protected static final String TAG = "myLog";
    protected List<T> items;

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    protected T getItem(int position) {
        return items.get(position);
    }
}
