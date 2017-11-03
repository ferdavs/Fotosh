package com.fer.fotosh.data;

import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Maybe;
import io.reactivex.Observable;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 7/19/17.
 */

public class LocalDataSource implements DataSource {

    private Map<String, List<ImageItem>> images;
    private Map<String, List<VideoItem>> videos;

    @Inject
    public LocalDataSource() {
        images = new HashMap<>();
        videos = new HashMap<>();
    }

    @Override
    public Maybe<ArrayList<ImageItem>> searchImage(String term) {
        if (images.containsKey(term)) {

            return Observable.fromIterable(images.get(term))
                             .reduce(new ArrayList<ImageItem>(),
                                     (list, item) -> {
                                         list.add(item);
                                         return list;
                                     })
                             .toMaybe();
        }
        else return Maybe.empty();
    }

    @Override
    public Maybe<ArrayList<VideoItem>> searchVideo(String term) {
        if (videos.containsKey(term))
            return Observable.fromIterable(videos.get(term))
                             .reduce(new ArrayList<VideoItem>(),
                                     (list, item) -> {
                                         list.add(item);
                                         return list;
                                     })
                             .toMaybe();
        else return Maybe.empty();
    }

    @Override
    public boolean containsImages(String term) {
        return images.containsKey(term);
    }

    @Override
    public boolean containsVideos(String term) {
        return videos.containsKey(term);
    }

    @Override
    public void saveVideos(String term, ArrayList<VideoItem> videoItems) {
        videos.put(term, videoItems);
    }

    @Override
    public void saveImages(String term, ArrayList<ImageItem> imageItems) {
        images.put(term, imageItems);
    }

}
