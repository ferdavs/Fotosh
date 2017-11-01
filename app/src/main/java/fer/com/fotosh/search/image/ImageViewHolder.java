package fer.com.fotosh.search.image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fer.com.fotosh.R;
import fer.com.fotosh.data.model.ImageItem;

/**
 * Created by f on 7/18/17.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {
    public ImageView image;
    public TextView tags;
    public ImageItem item;
    public Context context;

    public ImageViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        tags = itemView.findViewById(R.id.tags);
        image = itemView.findViewById(R.id.image);


    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(view.getContext(),
//                "Clicked Position = " + getAdapterPosition(), Toast.LENGTH_SHORT)
//             .show();

        ImageDialog.show(context, item);
    }

}
