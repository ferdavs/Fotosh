package com.fer.fotosh;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by f on 10/31/17.
 */

@Module
class ApplicationModule {

    @NonNull
    private final Application application;

    public ApplicationModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides
    @NonNull
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}