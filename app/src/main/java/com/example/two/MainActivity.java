package com.example.two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.two.base.BaseActivity;
import com.example.two.bean.Bean;
import com.example.two.contract.Contract;
import com.example.two.http.api.BaseUrl;
import com.example.two.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements Contract.View {

    @Override
    protected int setViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getBean(BaseUrl.BASE);
    }

    @Override
    public void onSSon(Bean bean) {
        Log.i("1111", "onSSon: "+bean.toString());
    }
}