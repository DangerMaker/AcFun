package com.fish.acfun.api;

import android.util.Log;

import com.fish.acfun.FishApplication;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by lyjq on 2015/12/18.
 */
public class RestService {
    private static Retrofit.Builder sInstance;

    private static Retrofit.Builder getInstance() {
        if (sInstance == null) {
            synchronized (RestService.class) {
                if (sInstance == null) {
                    sInstance = new Retrofit.Builder();
                }
            }
        }
        return sInstance;
    }


    public static Retrofit getRestAPI(String url){

        Retrofit retrofit = RestService.getInstance()
                .client(OkHttpManager.getInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .build();

        return retrofit;
    }
}
