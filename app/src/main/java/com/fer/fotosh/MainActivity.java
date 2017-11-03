package com.fer.fotosh;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.fer.fotosh.core.view.activity.BaseToolBarActivity;
import com.fer.fotosh.core.view.fragment.BaseFragment;
import com.fer.fotosh.search.image.ImageListContract;
import com.fer.fotosh.search.image.ImageListFragment;
import fer.com.fotosh.R;

import javax.inject.Inject;

public class MainActivity extends BaseToolBarActivity {
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";

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
            replaceFragment(new ImageListFragment(), ImageListFragment.TAG);
            title.setText(R.string.app_name);
        }

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY)
                                 .replace(' ', ',');
            presenter.searchImage(query);
        }
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
