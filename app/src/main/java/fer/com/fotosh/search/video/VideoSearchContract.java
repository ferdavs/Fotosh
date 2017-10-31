package fer.com.fotosh.search.video;

import java.util.List;

import fer.com.fotosh.core.RxPresenter;
import fer.com.fotosh.model.ImageItem;
import fer.com.fotosh.model.VideoItem;
import fer.com.fotosh.search.image.ImageSearchContract;

/**
 * Created by f on 10/31/17.
 */

public interface VideoSearchContract {
    interface View {
        void showVideoThumbnails(List<VideoItem> videos);

        void playVideo(VideoItem video);

        void showError(Throwable error);

        void showLoading();
    }

    abstract class Presenter extends RxPresenter<ImageSearchContract.View> {
        public abstract void onPlayVideo(VideoItem video);

        public abstract void onSearchVideo(String query);

    }
}
