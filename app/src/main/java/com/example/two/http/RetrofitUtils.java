package com.example.two.http;

import android.util.Log;

import com.example.two.http.api.ApiService;
import com.example.two.http.api.BaseUrl;
import com.example.two.http.api.NetCallBack;
import com.example.two.http.contract.ContractUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements ContractUtils {
    private static RetrofitUtils instance;
    private final ApiService apiService;

    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    @Override
    public <T> void get(String url, NetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                    @Override
                    public void onComplete() { }
                });
    }

    @Override
    public <T> void post(String url, NetCallBack<T> callBack) {
        apiService.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) { }
                    @Override
                    public void onComplete() { }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, NetCallBack<T> callBack) {
        apiService.post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) { }
                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) { }
                    @Override
                    public void onComplete() { }
                });
    }
}
