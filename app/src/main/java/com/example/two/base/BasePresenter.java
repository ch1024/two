package com.example.two.base;

import com.example.two.baseApi.BaseVeiw;

public abstract class BasePresenter<V extends BaseVeiw> {
    protected V view;
    protected void onAtton(V view){
        this.view=view;
    }
}
