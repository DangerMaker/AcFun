package com.fish.acfun.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mItems ;
    protected Context mContext;

    public BaseRecyclerAdapter(Context context){
        this.mContext = context;
        mItems = new ArrayList<>();
    }

    public List<T> getList() {
        return mItems;
    }

    public void addItem(T item) {
        if(item == null) return ;
        mItems.add(mItems.size(), item);
        notifyItemInserted(mItems.size());
    }

    public void addItems(List<T> items){
        if(items == null) return ;
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    public boolean containsAll(List<T> items){
        return mItems.containsAll(items);
    }

    public void updateItem(T tasks, int position) {
        if(tasks == null) return ;
        mItems.set(position, tasks);
        notifyItemChanged(position);
    }

    public void updateItems(List<T> items){
        if(items == null) return;
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void removeItem(int index) {
        mItems.remove(index);
        notifyItemRemoved(index);
    }

    public void getView(int position ,RecyclerView.ViewHolder viewHolder, int type, T item){}

    public T getItem(int location) {
        return mItems.get(location);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void clear(){
        mItems.clear();
        notifyDataSetChanged();
    }
}
