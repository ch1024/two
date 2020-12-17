package com.example.two.http.api;

public interface NetCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
