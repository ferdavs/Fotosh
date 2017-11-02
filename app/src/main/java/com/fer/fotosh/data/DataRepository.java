package com.fer.fotosh.data;

import android.support.annotation.NonNull;
import com.fer.fotosh.data.annotation.Local;
import com.fer.fotosh.data.annotation.Remote;
import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by f on 11/1/17.
 */

public class DataRepository implements DataSource {

    @NonNull
    @Remote
    private final DataSource remote;

    @NonNull
    @Local
    private final DataSource local;

    @Inject
    public DataRepository(@NonNull @Remote DataSource remote, @NonNull @Local DataSource local) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public Observable<List<ImageItem>> searchImage(String term) {
        //TODO use local data source as a cache
        return remote.searchImage(term);
    }

    @Override
    public Observable<List<VideoItem>> searchVideo(String term) {
        return Observable.empty();
    }
}
