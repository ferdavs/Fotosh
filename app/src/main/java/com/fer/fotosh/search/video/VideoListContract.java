package com.fer.fotosh.search.video;

import com.fer.fotosh.core.RxPresenter;
import com.fer.fotosh.data.model.VideoItem;
import com.fer.fotosh.search.image.ImageListContract;

import java.util.List;

/**
 * Created by f on 10/31/17.
 *
 *
 */

public interface VideoListContract {
    interface View {
        void showVideoThumbnails(List<VideoItem> videos);

        void playVideo(VideoItem video);

        void showError(Throwable error);

        void showLoading();
    }

    abstract class Presenter extends RxPresenter<ImageListContract.View> {
        public abstract void onPlayVideo(VideoItem video);

        public abstract void onSearchVideo(String query);

    }
}
