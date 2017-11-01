package fer.com.fotosh.data.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONException;

import java.util.Map;

import fer.com.fotosh.data.model.base.BaseItem;

/**
 * Created by f on 10/31/17.
 */
@AutoValue
public abstract class VideoItem extends BaseItem {


    @Nullable
    public abstract String pageURL();

    @Nullable
    public abstract String userImageURL();

    @Nullable
    public abstract Map<String, VideoObject> videos();

    public enum VideoSize {
        large, medium, small, tiny
    }

    public String getUrlForSize(VideoSize size) throws JSONException {
        if (videos() == null) throw new NullPointerException("videos list is empty");

        return videos().get(size.name()).url();
    }

    public String getUrlForLarge() throws JSONException {
        return getUrlForSize(VideoSize.large);
    }

    public String getUrlForMedium() throws JSONException {
        return getUrlForSize(VideoSize.medium);
    }

    public String getUrlForSmall() throws JSONException {
        return getUrlForSize(VideoSize.small);
    }

    public String getUrlForTiny() throws JSONException {
        return getUrlForSize(VideoSize.tiny);
    }

    public static TypeAdapter<VideoItem> typeAdapter(Gson gson) {
        return new AutoValue_VideoItem.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_VideoItem.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(@Nullable Integer id);

        public abstract Builder userId(@Nullable Integer userId);

        public abstract Builder views(@Nullable Integer views);

        public abstract Builder likes(@Nullable Integer likes);

        public abstract Builder type(@Nullable String type);

        public abstract Builder user(@Nullable String user);

        public abstract Builder tags(@Nullable String tags);

        public abstract Builder pageURL(@Nullable String pageURL);

        public abstract Builder userImageURL(@Nullable String userImageURL);

        public abstract Builder videos(@Nullable Map<String, VideoObject> videos);

        public abstract VideoItem build();
    }
}
