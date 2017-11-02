package fer.com.fotosh.data;

import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

/**
 * Created by f on 7/19/17.
 */

public class LocalDataSource implements DataSource {
    @Inject
    public LocalDataSource() {

    }

    @Override
    public Observable<ImageItem> searchImage(String term) throws ExecutionException, InterruptedException {
        return Observable.empty();
    }

    @Override
    public Observable<VideoItem> searchVideo(String term) throws ExecutionException, InterruptedException {
        return Observable.empty();
    }

}
