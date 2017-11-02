package com.fer.fotosh.data.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by f on 10/31/17.
 */
@AutoValue
public abstract class VideoItemList implements Parcelable {

    @Nullable
    public abstract Integer total();

    @Nullable
    public abstract Integer totalHits();

    @Nullable
    public abstract List<VideoItem> hits();

    public static TypeAdapter<VideoItemList> typeAdapter(Gson gson) {
        return new AutoValue_VideoItemList.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_VideoItemList.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder total(@Nullable Integer total);

        public abstract Builder totalHits(@Nullable Integer totalHits);

        public abstract Builder hits(@Nullable List<VideoItem> hits);

        public abstract VideoItemList build();
    }
}
