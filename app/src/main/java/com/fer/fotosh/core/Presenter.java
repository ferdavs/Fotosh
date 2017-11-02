package com.fer.fotosh.core;

import io.reactivex.annotations.Nullable;

/**
 * Created by f on 10/31/17.
 */

public interface Presenter<V> {
    
    void onViewAttached(V view);

    void onViewDetached();

    void onDestroyed();

    boolean isViewAttached();

    @Nullable
    V getView();
}
