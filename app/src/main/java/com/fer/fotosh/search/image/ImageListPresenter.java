package com.fer.fotosh.search.image;

import android.support.annotation.NonNull;
import com.fer.fotosh.data.DataSource;
import com.fer.fotosh.data.annotation.Repository;
import com.fer.fotosh.data.model.ImageItem;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

import javax.inject.Inject;

/**
 * Created by f on 11/2/17.
 */

public class ImageListPresenter extends ImageListContract.Presenter {

    private DataSource dataSource;

    @Inject
    public ImageListPresenter(@NonNull @Repository DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void showImageDetail(ImageItem image) {
        getView().showImageDetails(image);
    }

    @Override
    public void searchImage(String query) {
        Disposable subscribe = dataSource.searchImage(query)
                                         .observeOn(AndroidSchedulers.mainThread())
                                         .subscribe(imageItems -> getView().showImages(imageItems),
                                                 this::onError);
        addSubscriptions(subscribe);
    }

    @Override
    public void onError(Throwable e) {
        Timber.e(e);
        getView().showError(e);
    }
}
