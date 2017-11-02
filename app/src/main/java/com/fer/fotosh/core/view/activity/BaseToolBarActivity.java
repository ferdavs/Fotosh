package com.fer.fotosh.core.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.BindView;
import fer.com.fotosh.R;

/**
 * Created by f on 10/31/17.
 */

public abstract class BaseToolBarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;


    @BindView(R.id.toolbar_title)
    protected TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
