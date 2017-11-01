package fer.com.fotosh.api;

import java.util.Map;

import fer.com.fotosh.data.model.ImageItemList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by f on 10/31/17.
 */

public interface PixabayApi {

    @GET("api")
    Call<ImageItemList> searchImage(@Query("key") String key, @Query("q") String q, @QueryMap Map<String, String> options);

    @GET("api/videos")
    Call<ImageItemList> searchVideo(@Query("key") String key, @Query("q") String q, @QueryMap Map<String, String> options);
}
