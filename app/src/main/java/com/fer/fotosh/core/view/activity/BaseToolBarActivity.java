package com.fer.fotosh.core.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import fer.com.fotosh.R;

/**
 * Created by f on 10/31/17.
 */

public abstract class BaseToolBarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.toolbar_title)
    public TextView title;

    @BindView(R.id.search_icon)
    public View searchIcon;

    @BindView(R.id.search_edit_text)
    public EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
