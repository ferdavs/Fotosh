package com.fer.fotosh;

import com.fer.fotosh.api.ApiModule;
import com.fer.fotosh.data.DataModule;
import com.fer.fotosh.search.image.ImageListFragment;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by f on 10/31/17.
 *
 *
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class,
        DataModule.class,
        PresentationModule.class
})
public interface ApplicationComponent {
    void inject(ImageListFragment fragment);

    void inject(MainActivity activity);
}
