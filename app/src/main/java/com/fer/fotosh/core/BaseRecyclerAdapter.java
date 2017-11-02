package com.fer.fotosh.core;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by f on 11/2/17.
 */

public abstract class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<T> {

    protected List<D> itemList;


    public BaseRecyclerAdapter(List<D> mDataSet) {
        this.itemList = mDataSet;
        setHasStableIds(true);
    }

    public abstract T createView(ViewGroup view, int viewType);

    public abstract void bindView(T view, int position);

    @Override
    public long getItemId(int position) {
        return itemList.get(position)
                       .hashCode();
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return createView(parent, viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        bindView(holder, position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void swapDataSet(List<D> newData) {
        itemList = newData;
        notifyDataSetChanged();
    }

    public D getItem(int position) {
        return itemList.get(position);
    }

    public int getPosition(D item) {
        return itemList.indexOf(item);
    }

    public void removeItem(int position, D item) {
        itemList.remove(position);
        itemList.add(0, item);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        itemList.remove(position);
        notifyDataSetChanged();
    }

    public void removeAll() {
        itemList.clear();
        notifyDataSetChanged();
    }

    public void replaceItem(D item, int position) {
        itemList.set(position, item);
        notifyItemChanged(position);
    }

    public void addItem(D item) {
        itemList.add(item);
        notifyDataSetChanged();
    }

    public void addItem(int position, D item) {
        itemList.add(position, item);
        notifyDataSetChanged();
    }

    public void addItems(List<D> item) {
        itemList.addAll(item);
        notifyDataSetChanged();
    }


    public List<D> getDataSet() {
        return itemList;
    }
}
