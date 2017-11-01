package fer.com.fotosh.data.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by f on 10/31/17.
 */

@AutoValue
public abstract class VideoObject implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract Integer width();

    @Nullable
    public abstract Integer height();

    @Nullable
    public abstract Integer size();

    public static TypeAdapter<VideoObject> typeAdapter(Gson gson) {
        return new AutoValue_VideoObject.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_VideoObject.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(@Nullable String url);

        public abstract Builder width(@Nullable Integer width);

        public abstract Builder height(@Nullable Integer height);

        public abstract Builder size(@Nullable Integer size);

        public abstract VideoObject build();
    }
}
