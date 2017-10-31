package fer.com.fotosh.core;

import java.lang.ref.WeakReference;

import io.reactivex.annotations.Nullable;

/**
 * Created by f on 10/31/17.
 */

public abstract class AbstractPresenter<V> implements Presenter<V> {
    private WeakReference<V> view;


    @Override
    public void onViewAttached(V view) {
        this.view = new WeakReference<V>(view);
    }

    @Override
    public void onViewDetached() {
        this.view.clear();
    }

    @Override
    public void onDestroyed() {
        view = null;
    }

    @Nullable
    @Override
    public V getView() {
        return view == null ? null : view.get();
    }

    @Override
    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }
}
