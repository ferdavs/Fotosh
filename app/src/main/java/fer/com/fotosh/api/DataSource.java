package fer.com.fotosh.api;

import java.util.List;
import java.util.concurrent.ExecutionException;

import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 7/19/17.
 */

public interface DataSource {

    List<ImageItem> search(String term) throws ExecutionException, InterruptedException;
}
