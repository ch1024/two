package com.example.two.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.two.baseApi.BaseVeiw;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseVeiw {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        if (presenter==null){
            presenter=getPresenter();
            presenter.onAtton(this);
        }
        initView();
        initData();
    }

    protected abstract int setViewId();
    protected abstract P getPresenter();
    protected abstract void initView();
    protected abstract void initData();
}
