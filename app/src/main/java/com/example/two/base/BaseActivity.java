package com.example.two.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P> extends AppCompatActivity {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        if (presenter==null){
            presenter=getPresenter();
        }
        initView();
        initData();
    }

    protected abstract int setViewId();
    protected abstract P getPresenter();
    protected abstract void initView();
    protected abstract void initData();
}
