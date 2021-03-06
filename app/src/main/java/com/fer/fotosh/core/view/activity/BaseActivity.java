package com.fer.fotosh.core.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by f on 10/31/17.
 *
 *
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutId();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }
}
