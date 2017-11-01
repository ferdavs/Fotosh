package fer.com.fotosh;

import javax.inject.Singleton;

import dagger.Component;
import fer.com.fotosh.api.ApiModule;
import fer.com.fotosh.data.DataModule;

/**
 * Created by f on 10/31/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class,
        DataModule.class
})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
