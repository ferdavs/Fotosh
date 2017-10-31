package fer.com.fotosh;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import fer.com.fotosh.api.DataSource;
import fer.com.fotosh.api.PixabayDataSource;
import fer.com.fotosh.model.ImageItem;
import fer.com.fotosh.search.image.ImageViewAdapter;

public class MainActivity extends AppCompatActivity {
    ImageViewAdapter rcAdapter;
    //TODO use DI
    DataSource dataSource = new PixabayDataSource();
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
                rcAdapter.addItems(dataSource.search(query));
            } catch (ExecutionException | InterruptedException e) {
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
                rcAdapter.addItems(dataSource.search("cat"));
            } catch (ExecutionException | InterruptedException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }

    public void clicked(View view) {
        onSearchRequested();
    }
}
