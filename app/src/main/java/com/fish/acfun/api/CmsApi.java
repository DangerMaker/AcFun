package com.fish.acfun.api;;

import com.fish.acfun.model.HomeData;
import com.fish.acfun.model.VideoDetail;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lyjq on 2015/12/18.
 */
public interface CmsApi {
    @GET("/regions")
    Call<HomeData> getHomePage();

    @GET("/videos/{cid}")
    Call<VideoDetail> getVideoDetail(@Path("cid") String cid);
}
