package fer.com.fotosh.data;

import dagger.Module;
import dagger.Provides;
import fer.com.fotosh.data.annotation.Local;
import fer.com.fotosh.data.annotation.Remote;
import fer.com.fotosh.data.annotation.Repository;

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
