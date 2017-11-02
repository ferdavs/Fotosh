package com.fer.fotosh.data.json;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;


/**
 * Created by f on 11/1/17.
 * <p>
 * Create Gson type adapter factory example
 * <p>
 * <pre>
 *     Gson gson = new GsonBuilder()
 *          .setLenient()
 *          .registerTypeAdapterFactory(EntityTypeAdapterFactory.create())
 *          .create();
 * </pre>
 */

@GsonTypeAdapterFactory
public abstract class EntityTypeAdapterFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_EntityTypeAdapterFactory();
    }
}
