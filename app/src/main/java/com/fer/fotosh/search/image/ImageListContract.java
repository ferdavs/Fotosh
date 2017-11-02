package com.fer.fotosh.search.image;

import com.fer.fotosh.core.RxPresenter;
import com.fer.fotosh.data.model.ImageItem;

import java.util.List;

/**
 * Created by f on 10/31/17.
 */

public interface ImageListContract {

    interface View {
        void showImages(List<ImageItem> images);

        void showError(Throwable error);
    }

    abstract class Presenter extends RxPresenter<View> {

        public abstract void searchImage(String query);

        public abstract void onError(Throwable e);
    }
}
