package com.fer.fotosh.data;

import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Maybe;

import java.util.ArrayList;

/**
 * Created by f on 7/19/17.
 */

public class MockDataSource implements DataSource {
    @Override
    public Maybe<ArrayList<ImageItem>> searchImage(String term) {
        return Maybe.empty();
    }

    @Override
    public Maybe<ArrayList<VideoItem>> searchVideo(String term) {
        return Maybe.empty();
    }

    @Override
    public boolean containsImages(String term) {
        return false;
    }

    @Override
    public boolean containsVideos(String term) {
        return false;
    }

    @Override
    public void saveVideos(String term, ArrayList<VideoItem> videoItems) {

    }

    @Override
    public void saveImages(String term, ArrayList<ImageItem> imageItems) {

    }

}
