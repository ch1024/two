package com.example.two.http.contract;

import com.example.two.http.api.NetCallBack;

import java.util.HashMap;

public interface ContractUtils {
    public <T> void get(String url, NetCallBack<T> callBack);
    public <T> void post(String url,NetCallBack<T> callBack);
    public <T> void post(String url, HashMap<String,String> map, NetCallBack<T> callBack);
}
