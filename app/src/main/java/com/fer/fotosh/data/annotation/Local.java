package com.fer.fotosh.data.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by f on 11/1/17.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Local {
}
