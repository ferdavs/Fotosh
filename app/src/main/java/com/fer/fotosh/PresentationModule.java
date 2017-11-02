package com.fer.fotosh;

import com.fer.fotosh.search.image.ImageListContract;
import com.fer.fotosh.search.image.ImageListPresenter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by f on 11/2/17.
 */

@Module
public class PresentationModule {

    @Singleton
    @Provides
    ImageListContract.Presenter providesImageListPresenter(ImageListPresenter presenter) {
        return presenter;
    }
}
