package com.fish.acfun;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fish.acfun.api.CmsApi;
import com.fish.acfun.api.RestService;
import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.base.Config;
import com.fish.acfun.fragment.EmptyFragment;
import com.fish.acfun.fragment.HomeFragment;
import com.fish.acfun.model.VideoDetail;
import com.fish.acfun.model.VideoItem;
import com.fish.acfun.util.GifUtil;
import com.google.android.libraries.mediaframework.exoplayerextensions.Video;

import butterknife.Bind;
import butterknife.OnClick;
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
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.main_viewpager)
    ViewPager viewPager;

    ViewPagerAdapter adapter;
    String cid;
    VideoDetail videoDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLayout.setTitleEnabled(false);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);

        cid = getIntent().getStringExtra("cid");
        if(cid == null || cid.trim().equals("")){
            return;
        }
        Call<VideoDetail> call = RestService.getRestAPI(Config.CMS_URL).create(CmsApi.class).getVideoDetail(cid);
        call.enqueue(new Callback<VideoDetail>() {
            @Override
            public void onResponse(Response<VideoDetail> response, Retrofit retrofit) {
                videoDetail = response.body();
                if(videoDetail != null) {
                    String imgUrl = videoDetail.getData().getCover();
                    GifUtil.loadImage(imgUrl, draweeView);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("VideoDetail","onFailure");
            }
        });
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private String[] title = {"视频","评论"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new EmptyFragment();
                default:
                    return new EmptyFragment();
            }

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    @OnClick(R.id.toolbar_layout)
    void enterVideo(){
        if(videoDetail != null) {
            Intent intent = new Intent();
            intent.putExtra("videoId",videoDetail.getData().getVideos().get(0).getSourceId()+"");
            intent.setClass(this, VideoActivity.class);
            startActivity(intent);
        }
    }
}
