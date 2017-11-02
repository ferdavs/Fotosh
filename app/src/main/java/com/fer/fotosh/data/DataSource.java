package com.fer.fotosh.data;

import com.fer.fotosh.data.model.ImageItem;
import com.fer.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

import java.util.List;

/**
 * Created by f on 7/19/17.
 */

public interface DataSource {

    Observable<List<ImageItem>> searchImage(String term);

    Observable<List<VideoItem>> searchVideo(String term);

}
