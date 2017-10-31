package fer.com.fotosh.search.image;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import fer.com.fotosh.R;
import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 7/19/17.
 */

public class ImageDialog extends View {
    private ImageView largeImage;
    private TextView largeTags;
    private AlertDialog dialog;
    //    private ImageDialog inst;
    private ImageItem item;

    private ImageDialog(Context context, ImageItem item) {
        super(context);
        this.item = item;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());
        dialog = builder.create();
        View dialogLayout = LayoutInflater.from(context).inflate(R.layout.image_large, null);
        largeImage = dialogLayout.findViewById(R.id.largeImage);
        largeTags = dialogLayout.findViewById(R.id.tagsLarge);
        dialog.setView(dialogLayout);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void show() {

        Glide.with(getContext())
                .load(item.getWebformatURL())
//             .diskCacheStrategy(DiskCacheStrategy.ALL)
//             .placeholder(R.drawable.loader)
//             .skipMemoryCache(false)
                .into(largeImage);
        largeTags.setText(item.getTags());
        dialog.show();
    }

    public static void show(Context context, ImageItem item) {
//        if (inst == null)
        ImageDialog inst = new ImageDialog(context, item);
//        inst.setOnShowListener(listener);
        inst.show();
    }
}
