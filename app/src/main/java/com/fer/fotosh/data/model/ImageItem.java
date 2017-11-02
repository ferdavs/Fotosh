package com.fer.fotosh.data.model;

import android.support.annotation.Nullable;
import com.fer.fotosh.data.model.base.BaseItem;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by f on 7/18/17.
 */

@AutoValue
public abstract class ImageItem extends BaseItem {

    @Nullable
    public abstract String previewURL();

    @Nullable
    public abstract String webformatURL();

    public static TypeAdapter<ImageItem> typeAdapter(Gson gson) {
        return new AutoValue_ImageItem.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_ImageItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder  {
        public abstract Builder id(@Nullable Integer id);

        public abstract Builder userId(@Nullable Integer userId);

        public abstract Builder views(@Nullable Integer views);

        public abstract Builder likes(@Nullable Integer likes);

        public abstract Builder type(@Nullable String type);

        public abstract Builder user(@Nullable String user);

        public abstract Builder tags(@Nullable String tags);

        public abstract Builder previewURL(@Nullable String previewURL);

        public abstract Builder webformatURL(@Nullable String webformatURL);

        public abstract ImageItem build();
    }
}
