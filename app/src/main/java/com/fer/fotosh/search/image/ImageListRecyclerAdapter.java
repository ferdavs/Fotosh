package com.fer.fotosh.search.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.fer.fotosh.core.BaseRecyclerAdapter;
import com.fer.fotosh.data.model.ImageItem;
import fer.com.fotosh.R;

import java.util.List;

public class ImageListRecyclerAdapter extends BaseRecyclerAdapter<ImageViewHolder, ImageItem> {
    private Context context;

    public ImageListRecyclerAdapter(Context context,
                                    List<ImageItem> itemList) {
        super(itemList);
        this.context = context;
    }

    public void addItem(ImageItem item) {
        itemList.add(item);
        notifyItemInserted(itemList.size() - 1);
    }

    @Override
    public ImageViewHolder createView(ViewGroup view, int viewType) {
        View v = LayoutInflater.from(view.getContext())
                               .inflate(R.layout.image_card, view, false);
        return new ImageViewHolder(v, view.getContext());
    }

    @Override
    public void bindView(ImageViewHolder holder, int position) {
        ImageItem item = getItem(position);
        holder.tags.setText(item.tags());
        holder.image.invalidate();
        holder.item = item;
        holder.context = context;

        Glide.with(context)
             .load(item.previewURL())
//                .thumbnail(0.1f)
             .into(holder.image);

    }
}
