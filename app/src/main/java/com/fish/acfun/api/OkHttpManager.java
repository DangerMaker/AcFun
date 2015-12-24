package com.fish.acfun.api;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

/**
 * Created by lyjq on 2015/12/18.
 */
public class OkHttpManager {

    private static OkHttpClient sInstance;

    public static OkHttpClient getInstance() {
        if (sInstance == null) {
            synchronized (OkHttpManager.class) {
                if (sInstance == null) {
                    sInstance = new com.squareup.okhttp.OkHttpClient();
                    //cookie enabled
                    sInstance.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
                    //从主机读取数据超时
                    sInstance.setReadTimeout(15, TimeUnit.SECONDS);
                    //连接主机超时
                    sInstance.setConnectTimeout(20, TimeUnit.SECONDS);
                    sInstance.interceptors().add(interceptor);
                }
            }
        }
        return sInstance;
    }

    static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("deviceType","1")
                    .addHeader("appVersion","4.0.5")
                    .addHeader("udid","17755e47-14ac-3fd3-a1b9-f38f3c5e0754")
                    .addHeader("market","xiaomi")
                    .addHeader("User-Agent", "hello muggle").build();
            return chain.proceed(newRequest);
        }
    };

}
