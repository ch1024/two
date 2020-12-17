package com.example.two.contract;

import com.example.two.baseApi.BaseVeiw;
import com.example.two.bean.Bean;

public interface Contract {
    interface View extends BaseVeiw {
        void onSSon(Bean bean);
    }
    interface Presenter{
        void getBean();
    }
    interface Model{
        void getBean();
    }
}
