package com.fer.fotosh.data;

import android.support.annotation.NonNull;
import com.fer.fotosh.data.annotation.Local;
import com.fer.fotosh.data.annotation.Remote;
import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Maybe;

import javax.inject.Inject;
import java.util.ArrayList;

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
    public Maybe<ArrayList<ImageItem>> searchImage(String term) {
        if (local.containsImages(term)) return local.searchImage(term);
        Maybe<ArrayList<ImageItem>> arrayListMaybe = remote.searchImage(term);
        saveImages(term, arrayListMaybe.blockingGet());
        return arrayListMaybe;
    }

    @Override
    public Maybe<ArrayList<VideoItem>> searchVideo(String term) {
        if (local.containsVideos(term)) return local.searchVideo(term);
        Maybe<ArrayList<VideoItem>> arrayListMaybe = remote.searchVideo(term);
        saveVideos(term, arrayListMaybe.blockingGet());
        return arrayListMaybe;
    }


    @Override
    public boolean containsImages(String term) {
        return local.containsImages(term);
    }

    @Override
    public boolean containsVideos(String term) {
        return local.containsVideos(term);
    }

    @Override
    public void saveVideos(String term, ArrayList<VideoItem> videoItems) {
        local.saveVideos(term, videoItems);
    }

    @Override
    public void saveImages(String term, ArrayList<ImageItem> imageItems) {
        local.saveImages(term, imageItems);
    }
}
