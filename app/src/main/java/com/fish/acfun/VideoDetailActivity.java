package com.fish.acfun;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fish.acfun.api.CmsApi;
import com.fish.acfun.api.RestService;
import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.base.Config;
import com.fish.acfun.model.VideoDetail;

import butterknife.Bind;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by lyjq on 2015/12/24.
 */
public class VideoDetailActivity extends BaseActivity{
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.image)
    SimpleDraweeView draweeView;

    String cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLayout.setTitleEnabled(false);

        cid = getIntent().getStringExtra("cid");
        if(cid == null || cid.trim().equals("")){
            return;
        }
        Call<VideoDetail> call = RestService.getRestAPI(Config.CMS_URL).create(CmsApi.class).getVideoDetail(cid);
        call.enqueue(new Callback<VideoDetail>() {
            @Override
            public void onResponse(Response<VideoDetail> response, Retrofit retrofit) {
                VideoDetail videoDetail = response.body();
                String imgUrl = videoDetail.getData().getCover();
                draweeView.setImageURI(Uri.parse(imgUrl));
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("VideoDetail","onFailure");
            }
        });
    }
}
