package fer.com.fotosh;

import javax.inject.Singleton;

import dagger.Component;
import fer.com.fotosh.api.ApiModule;

/**
 * Created by f on 10/31/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ApiModule.class
})
public interface ApplicationComponent {
}
