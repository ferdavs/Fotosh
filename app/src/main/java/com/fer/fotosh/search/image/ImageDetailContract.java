package com.fer.fotosh.search.image;

import com.fer.fotosh.core.RxPresenter;
import com.fer.fotosh.data.model.ImageItem;

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
