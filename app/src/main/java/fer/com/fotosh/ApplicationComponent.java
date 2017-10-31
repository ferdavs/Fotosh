package fer.com.fotosh;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by f on 10/31/17.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class
})
public interface ApplicationComponent {
}
