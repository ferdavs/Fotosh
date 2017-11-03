package com.fer.fotosh.api;

import com.fer.fotosh.data.model.ImageItemList;
import com.fer.fotosh.data.model.VideoItemList;
import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * Created by f on 10/31/17.
 */

public interface PixabayApi {

    @GET("api")
    Maybe<ImageItemList> searchImage(@Query("key") String key, @Query("q") String q, @QueryMap Map<String, String> options);

    @GET("api/videos")
    Maybe<VideoItemList> searchVideo(@Query("key") String key, @Query("q") String q, @QueryMap Map<String, String> options);
}
