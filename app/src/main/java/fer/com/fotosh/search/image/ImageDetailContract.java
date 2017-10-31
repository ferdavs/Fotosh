package fer.com.fotosh.search.image;

import fer.com.fotosh.core.RxPresenter;
import fer.com.fotosh.model.ImageItem;

/**
 * Created by f on 10/31/17.
 */

public interface ImageDetailContract {

    interface View {
        void renderImageDetail(ImageItem image);

        void showError(Throwable error);

        void showLoading();
    }

    abstract class Presenter extends RxPresenter<View> {
        public abstract void subscribe(ImageItem image);
    }
}
