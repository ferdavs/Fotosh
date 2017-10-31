package fer.com.fotosh.search.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import fer.com.fotosh.R;
import fer.com.fotosh.model.ImageItem;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private List<ImageItem> itemList;
    private Context context;

    public ImageViewAdapter(Context context,
                            List<ImageItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public void addItem(ImageItem item) {
        itemList.add(item);
        notifyItemInserted(itemList.size() - 1);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.image_card, null);
        return new ImageViewHolder(layoutView,context);
    }

    @Override
    public void onViewRecycled(ImageViewHolder holder) {

        super.onViewRecycled(holder);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageItem item = itemList.get(position);
        holder.tags.setText(item.getTags());
        holder.image.invalidate();
        holder.item = item;
        holder.context = context;

        Glide.with(context)
             .load(item.getPreviewURL())
//             .diskCacheStrategy(DiskCacheStrategy.RESULT)
//             .centerCrop()
//             .crossFade()
//             .skipMemoryCache(true)
             .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void addItems(List<ImageItem> search) {
//        int prev = itemList.size();
        itemList.addAll(search);
//        notifyItemRangeInserted(prev, search.size());
        notifyDataSetChanged();

    }

    public void removeAll() {
        itemList.clear();
        notifyDataSetChanged();
    }
}
