package com.example.two.contract;

import com.example.two.baseApi.BaseVeiw;
import com.example.two.bean.Bean;
import com.example.two.http.api.NetCallBack;

public interface Contract {
    interface View extends BaseVeiw {
        void onSSon(Bean bean);
    }
    interface Presenter{
        void getBean(String url);
    }
    interface Model{
        void getBean(String url, NetCallBack<Bean> callBack);
    }
}
