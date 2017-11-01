package fer.com.fotosh;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import fer.com.fotosh.api.ApiModule;
import fer.com.fotosh.data.DataModule;
import timber.log.Timber;

/**
 * Created by f on 10/31/17.
 */

public class PixabayApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static PixabayApplication get(@NonNull Context context) {
        return (PixabayApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .dataModule(new DataModule())
                .build();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
