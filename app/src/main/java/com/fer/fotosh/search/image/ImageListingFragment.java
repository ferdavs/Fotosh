package com.fer.fotosh.search.image;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.fer.fotosh.PixabayApplication;
import com.fer.fotosh.core.view.fragment.BaseFragment;
import com.fer.fotosh.data.model.ImageItem;
import fer.com.fotosh.R;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_listing;
    }

    //    @Inject
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
        presenter.searchImage("cat");
    }

//    private void search(String query) {
//        try {
//            rcAdapter.removeAll();
//            Disposable subscribe = dataSource.searchImage(query)
//                                             .observeOn(AndroidSchedulers.mainThread())
//                                             .subscribe(this::showImages, Timber::e);
//        } catch (Exception e) {
//            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT)
//                 .show();
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState == null) {
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(manager);
            recyclerView.setHasFixedSize(true);
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

    @Override
    public void showLoading() {

    }

//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        if (!startedFlag) {
//            startedFlag = true;
//            search("cat");
//        }
//    }


}
