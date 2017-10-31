package fer.com.fotosh.core;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by f on 10/31/17.
 */

public class RxPresenter<V> extends AbstractPresenter<V> {
    private CompositeDisposable subscriptions = new CompositeDisposable();

    @Override
    public void onDestroyed() {
        super.onDestroyed();
        subscriptions.dispose();
        subscriptions = new CompositeDisposable();
    }

    public void addSubscriptions(Disposable subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscriber(Disposable subscription) {
        subscriptions.remove(subscription);
    }
}
