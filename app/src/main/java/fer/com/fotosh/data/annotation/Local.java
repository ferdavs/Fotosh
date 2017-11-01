package fer.com.fotosh.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by f on 11/1/17.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Local {
}
