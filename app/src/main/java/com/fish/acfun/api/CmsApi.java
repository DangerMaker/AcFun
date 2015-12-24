package com.fish.acfun.api;;

import com.fish.acfun.model.HomeData;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by lyjq on 2015/12/18.
 */
public interface CmsApi {
    @GET("/regions")
    Call<HomeData> getHomePage();
}
