package com.fer.fotosh.data;

import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Maybe;

import java.util.ArrayList;

/**
 * Created by f on 7/19/17.
 */

public interface DataSource {

    Maybe<ArrayList<ImageItem>> searchImage(String term);

    Maybe<ArrayList<VideoItem>> searchVideo(String term);

    boolean containsImages(String term);

    boolean containsVideos(String term);

    void saveVideos(String term, ArrayList<VideoItem> videoItems);

    void saveImages(String term, ArrayList<ImageItem> imageItems);
}
