package fer.com.fotosh.search.video;

import fer.com.fotosh.core.RxPresenter;
import fer.com.fotosh.model.VideoItem;

/**
 * Created by f on 10/31/17.
 */

public interface PlayVideoContract {

    interface View {
        void playVideo(VideoItem video);

        void showError(Throwable error);

        void showLoading();
    }

    abstract class Presenter extends RxPresenter<View> {
        public abstract void subscribe(VideoItem image);
    }
}
