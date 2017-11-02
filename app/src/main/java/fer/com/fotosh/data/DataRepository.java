package fer.com.fotosh.data;

import android.support.annotation.NonNull;
import fer.com.fotosh.data.annotation.Local;
import fer.com.fotosh.data.annotation.Remote;
import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

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
    public Observable<ImageItem> searchImage(String term) throws ExecutionException, InterruptedException {
        //TODO use local data source as a cache
        return remote.searchImage(term);
    }

    @Override
    public Observable<VideoItem> searchVideo(String term) throws ExecutionException, InterruptedException {
        return Observable.empty();
    }
}
