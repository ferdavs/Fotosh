package fer.com.fotosh.data;

import android.support.annotation.NonNull;
import com.google.common.collect.ImmutableMap;
import fer.com.fotosh.api.PixabayApi;
import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.data.model.ImageItemList;
import fer.com.fotosh.data.model.VideoItem;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by f on 7/19/17.
 */
public class PixabayDataSource implements DataSource {
    private static final String API_KEY = "5932369-98914f23226be434a04032bff";

    @NonNull
    private PixabayApi api;

    @Inject
    public PixabayDataSource(@NonNull PixabayApi api) {
        this.api = api;
    }

    @Override
    public Observable<ImageItem> searchImage(String term) throws ExecutionException, InterruptedException {
        //TODO convert into advanced search
        Map<String, String> param = ImmutableMap.of(
                "image_type", "all",
                "per_page", "50",
                "editors_choice", "true",
                "lang", "en"
        );
        return api.searchImage(API_KEY, term, param)
                  .subscribeOn(Schedulers.io())
                  .flatMapIterable(ImageItemList::hits);
    }

    @Override
    public Observable<VideoItem> searchVideo(String term) throws ExecutionException, InterruptedException {
        return Observable.empty();
    }
}
