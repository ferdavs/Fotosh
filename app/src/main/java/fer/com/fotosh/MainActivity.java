package fer.com.fotosh;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import fer.com.fotosh.core.view.activity.BaseActivity;
import fer.com.fotosh.data.DataSource;
import fer.com.fotosh.data.annotation.Repository;
import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.search.image.ImageViewAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    ImageViewAdapter rcAdapter;

    @Repository
    @Inject
    DataSource dataSource;

    private static boolean startedFlag;//TODO get rid of this

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO
        ((PixabayApplication) getApplication()).getApplicationComponent()
                                               .inject(this);

//        recyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);

        List<ImageItem> sList = new ArrayList<>();

        rcAdapter = new ImageViewAdapter(MainActivity.this, sList);
        recyclerView.setAdapter(rcAdapter);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY)
                                 .replace(' ', ',');
            search(query);
        }
    }

    private void search(String query) {
        try {
            rcAdapter.removeAll();
            Disposable subscribe = dataSource.searchImage(query)
                                             .observeOn(AndroidSchedulers.mainThread())
                                             .subscribe(imageItems -> rcAdapter.addItem(imageItems), Timber::e);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
                 .show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            startedFlag = false;
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (!startedFlag) {
            startedFlag = true;
            search("cat");
        }

    }

    public void clicked(View view) {
        onSearchRequested();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
