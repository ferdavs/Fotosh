package com.fer.fotosh.data;

import com.fer.fotosh.data.annotation.Local;
import com.fer.fotosh.data.annotation.Remote;
import com.fer.fotosh.data.annotation.Repository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by f on 11/1/17.
 */

@Module
public class DataModule {

    @Singleton
    @Provides
    @Repository
    DataSource providesDataRepository(DataRepository repo) {
        return repo;
    }

    @Singleton
    @Provides
    @Remote
    DataSource providesPixabayDataSource(PixabayDataSource dataSource) {
        return dataSource;
    }

    @Singleton
    @Provides
    @Local
    DataSource providesLocalDataSource(LocalDataSource dataSource) {
        return dataSource;
    }
}
