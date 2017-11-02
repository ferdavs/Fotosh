package com.fer.fotosh.data.model.base;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by f on 10/31/17.
 */
public abstract class BaseItem implements Parcelable {

    @Nullable
    public abstract Integer id();

    @SerializedName("user_id")
    @Nullable
    public abstract Integer userId();

    @Nullable
    public abstract Integer views();

    @Nullable
    public abstract Integer likes();

    @Nullable
    public abstract String type();

    @Nullable
    public abstract String user();

    @Nullable
    public abstract String tags();
}
