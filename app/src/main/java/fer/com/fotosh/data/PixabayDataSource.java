package fer.com.fotosh.data;

import android.support.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import fer.com.fotosh.api.PixabayApi;
import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.data.model.ImageItemList;
import fer.com.fotosh.data.model.VideoItem;
import io.reactivex.Observable;

/**
 * Created by f on 7/19/17.
 */
public class PixabayDataSource implements DataSource {
    private static final String API_KEY = "5932369-98914f23226be434a04032bff";

//    private static final String rootApi = "https://pixabay.com/api/?" +
//            "key=" + API_KEY +
//            "&image_type=photo" +
//            "&per_page=50";

    @NonNull
    private PixabayApi api;

    @Inject
    public PixabayDataSource(PixabayApi api) {
        this.api = api;
    }

    @Override
    public Observable<ImageItem> searchImage(String term) throws ExecutionException, InterruptedException {
        Map<String, String> param = ImmutableMap.of("image_type", "photo", "per_page", "50");
        return api.searchImage(API_KEY, term, param).flatMapIterable(ImageItemList::hits);
    }

    @Override
    public Observable<VideoItem> searchVideo(String term) throws ExecutionException, InterruptedException {
        return Observable.empty();
    }
}
