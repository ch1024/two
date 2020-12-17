package com.example.two.model;

import com.example.two.bean.Bean;
import com.example.two.contract.Contract;
import com.example.two.http.RetrofitUtils;
import com.example.two.http.api.NetCallBack;

public class MainModel implements Contract.Model {

    @Override
    public void getBean(String url, NetCallBack<Bean> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
