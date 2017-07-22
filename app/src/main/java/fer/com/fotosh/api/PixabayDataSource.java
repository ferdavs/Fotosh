package fer.com.fotosh.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import fer.com.fotosh.model.ImageItem;
import fer.com.fotosh.model.ImageItemList;

/**
 * Created by f on 7/19/17.
 */
public class PixabayDataSource implements DataSource {
    //TODO secure api key
    private static final String rootApi = "https://pixabay.com/api/?" +
            "key=5932369-98914f23226be434a04032bff" +
            "&image_type=photo" +
            "&per_page=50";

    @Override
    public List<ImageItem> search(String term) throws ExecutionException, InterruptedException {
        String url = rootApi + "&q=" + term;
        ImageItemList list = ApiRequest.run().execute(url).get();
        return list.hits;
    }
}
