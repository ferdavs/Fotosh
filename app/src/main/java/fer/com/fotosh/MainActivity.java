package fer.com.fotosh;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import fer.com.fotosh.core.view.activity.BaseActivity;
import fer.com.fotosh.data.DataRepository;
import fer.com.fotosh.data.annotation.Remote;
import fer.com.fotosh.data.annotation.Repository;
import fer.com.fotosh.data.model.ImageItem;
import fer.com.fotosh.search.image.ImageViewAdapter;
import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class MainActivity extends BaseActivity {
    ImageViewAdapter rcAdapter;

//    @Remote
    @Repository
    @Inject
    DataRepository dataSource;
    @Inject
    OkHttpClient mOkHttpClient;

    private static boolean startedFlag;//TODO get rid of this

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);

        List<ImageItem> sList = new ArrayList<>();

        rcAdapter = new ImageViewAdapter(MainActivity.this, sList);
        recyclerView.setAdapter(rcAdapter);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY).replace(' ', ',');
            try {
                rcAdapter.removeAll();
                Disposable subscribe = dataSource.searchImage(query)
                        .subscribe(imageItems -> rcAdapter.addItem(imageItems), Timber::e);

            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
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
            try {
                Disposable cat = dataSource.searchImage("cat")
                        .subscribe(imageItems -> rcAdapter.addItem(imageItems), Timber::e);

            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }

    public void clicked(View view) {
        onSearchRequested();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
