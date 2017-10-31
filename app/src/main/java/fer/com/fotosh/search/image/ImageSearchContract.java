package fer.com.fotosh.search.image;

import java.util.List;

import fer.com.fotosh.core.RxPresenter;
import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 10/31/17.
 */

public interface ImageSearchContract {

    interface View {
        void showImages(List<ImageItem> images);

        void showImageDetails(ImageItem image);

        void showError(Throwable error);

        void showLoading();
    }

    abstract class Presenter extends RxPresenter<View> {
        public abstract void onImageDetailRequest(ImageItem image);

        public abstract void onSearchImage(String query);

    }
}
