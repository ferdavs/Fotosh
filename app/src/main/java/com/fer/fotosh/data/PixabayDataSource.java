package com.fer.fotosh.data;

import android.support.annotation.NonNull;
import com.fer.fotosh.api.PixabayApi;
import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.ImageItemList;
import com.fer.fotosh.data.model.VideoItem;
import com.google.common.collect.ImmutableMap;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 7/19/17.
 */
public class PixabayDataSource implements DataSource {
    private static final String API_KEY = "5932369-98914f23226be434a04032bff";

    @NonNull
    private PixabayApi api;

    @Inject
    public PixabayDataSource(@NonNull PixabayApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<ImageItem>> searchImage(String term) {
        //TODO convert into advanced search
        Map<String, String> param = ImmutableMap.of(
                "image_type", "all",
                "per_page", "50",
                "editors_choice", "true",
                "lang", "en"
        );
        return api.searchImage(API_KEY, term, param)
                  .subscribeOn(Schedulers.io())
                  .map(ImageItemList::hits);
    }

    @Override
    public Observable<List<VideoItem>> searchVideo(String term) {
        return Observable.empty();
    }
}
