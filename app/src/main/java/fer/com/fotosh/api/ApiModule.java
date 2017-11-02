package fer.com.fotosh.api;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import fer.com.fotosh.BuildConfig;
import fer.com.fotosh.data.json.EntityTypeAdapterFactory;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

/**
 * Created by f on 11/1/17.
 *
 *
 */

@Module
public class ApiModule {
    public static final HttpUrl API_URL = HttpUrl.parse("https://pixabay.com/");

    @Provides
    @Singleton
    HttpUrl provideBaseUrl() {
        return API_URL;
    }


    @Singleton
    @Provides
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Singleton
    @Provides
    @Named("Api")
    OkHttpClient provideApiClient(Cache cache, Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.connectTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        return builder.build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(HttpUrl httpUrl, @Named("Api") OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(httpUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    PixabayApi provideApi(Retrofit retrofit) {
        return retrofit.create(PixabayApi.class);
    }

    @Provides
    @NonNull
    @Singleton
    public TypeAdapterFactory provideTypeAdapterFactory() {
        return EntityTypeAdapterFactory.create();
    }

    @Provides
    @NonNull
    @Singleton
    public Gson provideGson(TypeAdapterFactory typeAdapterFactory) {
        return new GsonBuilder()
                .setLenient()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .create();
    }
}
