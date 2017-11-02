package com.fer.fotosh.data;

import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by f on 7/19/17.
 */

public class LocalDataSource implements DataSource {
    @Inject
    public LocalDataSource() {

    }

    @Override
    public Observable<List<ImageItem>> searchImage(String term) {
        return Observable.empty();
    }

    @Override
    public Observable<List<VideoItem>> searchVideo(String term) {
        return Observable.empty();
    }

}
