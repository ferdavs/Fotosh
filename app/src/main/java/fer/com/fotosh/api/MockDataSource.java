package fer.com.fotosh.api;

import java.util.ArrayList;
import java.util.List;

import fer.com.fotosh.model.VideoItem;
import io.reactivex.Observable;

import java.util.concurrent.ExecutionException;

import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 7/19/17.
 */

public class MockDataSource implements DataSource {
    @Override
    public Observable<List<ImageItem>> searchImage(String term) throws ExecutionException, InterruptedException {
        return Observable.amb(new ArrayList<>());
    }

    @Override
    public Observable<List<VideoItem>> searchVideo(String term) throws ExecutionException, InterruptedException {
        return Observable.amb(new ArrayList<>());
    }

}
