package fer.com.fotosh.api;

import java.util.List;

import io.reactivex.Observable;

import java.util.concurrent.ExecutionException;

import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.data.model.VideoItem;

/**
 * Created by f on 7/19/17.
 */

public interface DataSource {

    Observable<ImageItem> searchImage(String term) throws ExecutionException, InterruptedException;

    Observable<VideoItem> searchVideo(String term) throws ExecutionException, InterruptedException;

}
