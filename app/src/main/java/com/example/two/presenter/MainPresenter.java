package com.example.two.presenter;

import com.example.two.base.BasePresenter;
import com.example.two.bean.Bean;
import com.example.two.contract.Contract;
import com.example.two.http.api.NetCallBack;
import com.example.two.model.MainModel;

public class MainPresenter<V extends Contract.View> extends BasePresenter<V> implements Contract.Presenter {

    private  Contract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void getBean(String url) {
        model.getBean(url, new NetCallBack<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                view.onSSon(bean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
