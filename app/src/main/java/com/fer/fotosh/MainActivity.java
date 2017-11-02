package com.fer.fotosh;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.fer.fotosh.core.view.activity.BaseActivity;
import com.fer.fotosh.core.view.fragment.BaseFragment;
import com.fer.fotosh.search.image.ImageListContract;
import com.fer.fotosh.search.image.ImageListingFragment;
import fer.com.fotosh.R;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

    private static boolean startedFlag;//TODO get rid of this

    @Inject
    ImageListContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PixabayApplication.get(this)
                          .getApplicationComponent()
                          .inject(this);

        if (savedInstanceState == null) {
            replaceFragment(new ImageListingFragment(), ImageListingFragment.TAG);
        }

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY)
                                 .replace(' ', ',');
            presenter.searchImage(query);
        }
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (isFinishing()) {
//            startedFlag = false;
//        }
//    }
//
//    @Override
//    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        if (!startedFlag) {
//            startedFlag = true;
//        }
//    }

    public void clicked(View view) {
        onSearchRequested();
    }

    public void replaceFragment(BaseFragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.main_fragment_container, fragment, tag)
                                   .addToBackStack(BACK_STACK_ROOT_TAG)
                                   .commit();
    }


    public void addFragment(BaseFragment fragment, String fragmentTag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_fragment_container, fragment);
        ft.addToBackStack(fragmentTag);
        ft.commit();
    }
}
