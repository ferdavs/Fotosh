package com.fer.fotosh.search.image;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import com.fer.fotosh.MainActivity;
import com.fer.fotosh.PixabayApplication;
import com.fer.fotosh.core.view.fragment.BaseFragment;
import com.fer.fotosh.data.model.ImageItem;
import com.jakewharton.rxbinding2.widget.RxTextView;
import fer.com.fotosh.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageListingFragment extends BaseFragment implements ImageListContract.View {

    public static final String TAG = "ImageListingFragment";
    @Inject
    ImageListContract.Presenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    ImageListRecyclerAdapter rcAdapter;
    private MainActivity mainActivity;
    private EditText searchEditText;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_listing;
    }

    public ImageListingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        PixabayApplication.get(getContext())
                          .getApplicationComponent()
                          .inject(this);
        presenter.onViewAttached(this);
//        presenter.searchImage("cat");
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initializeToolbar();

        Disposable subscribe = RxTextView.textChanges(searchEditText)
                                         .debounce(1000, TimeUnit.MILLISECONDS)
                                         .compose(bindToLifecycle())
                                         .subscribeOn(Schedulers.io())
                                         .observeOn(AndroidSchedulers.mainThread())
                                         .subscribe(query -> presenter.searchImage(query.toString()),
                                                 Timber::e);

        if (savedInstanceState == null) {
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(manager);
//            recyclerView.setHasFixedSize(true);
            List<ImageItem> sList = new ArrayList<>();

            rcAdapter = new ImageListRecyclerAdapter(getContext(), sList);
            recyclerView.setAdapter(rcAdapter);
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onViewDetached();
    }

    @Override
    public void showImages(List<ImageItem> images) {
        rcAdapter.swapDataSet(images);
    }

    @Override
    public void showError(Throwable error) {

    }

    private void initializeToolbar() {
        mainActivity.title.setText(R.string.app_name);
        mainActivity.searchIcon.setSelected(false);
        searchEditText = mainActivity.searchEditText;
        searchEditText.setVisibility(View.GONE);
        mainActivity.searchIcon.setOnClickListener(v -> {
            mainActivity.searchIcon.setSelected(!mainActivity.searchIcon.isSelected());
            if (mainActivity.searchIcon.isSelected()) {
                searchEditText.setVisibility(View.VISIBLE);
                mainActivity.title.setVisibility(View.GONE);
            }
            else {
                searchEditText.setVisibility(View.GONE);
                mainActivity.title.setVisibility(View.VISIBLE);
            }
        });
    }
}
