package com.fish.acfun.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fish.acfun.R;
import com.fish.acfun.adapter.HomeAdapter;
import com.fish.acfun.api.CmsApi;
import com.fish.acfun.api.RestService;
import com.fish.acfun.base.Config;
import com.fish.acfun.model.HomeData;
import com.fish.acfun.model.HomeDataItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit.Call;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by lyjq on 2015/12/18.
 */
public class HomeFragment extends BaseLoadFragment<HomeData> {

    @Nullable @Bind(R.id.list)
    RecyclerView recyclerView;
    HomeAdapter adapter;
    HomeFragmentHandler handler;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler = new HomeFragmentHandler();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if(recyclerView!=null) {
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter == null ? adapter = new HomeAdapter(getActivity()) : adapter);
            recyclerView.setItemViewCacheSize(7);
//            adapter.setListener(this);
        }

    }

    @Override
    protected void onLoadData() {
        showLoad();
        Call<HomeData> call = RestService.getRestAPI(Config.CMS_URL).create(CmsApi.class).getHomePage();
        call.enqueue(this);
    }

    @Override
    protected void onInitLoadData(HomeData pageData) {
        hideEmptyView();
        if (pageData == null )
            return;

        List<HomeDataItem> list=new ArrayList<HomeDataItem>();
        list.add(pageData.getData().get(0));
        list.add(pageData.getData().get(1));
        list.add(pageData.getData().get(2));
        if(adapter!=null)adapter.updateItems(list);

    }


    @Override
    public void onResponse(Response<HomeData> response, Retrofit retrofit) {
        HomeData home = response.body();
        hideEmptyView();
        stopRefresh();
        if (home != null && "200".equals(home.getCode())) {
            setPageData(home);
        } else {
            showConnectionRetry();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        hideEmptyView();
        stopRefresh();
        showConnectionRetry();
    }

    public class HomeFragmentHandler extends Handler {

        public static final int SCROLL_VIEWPAGER = 0;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCROLL_VIEWPAGER:
                    onPagerChange();
                    sendEmptyMessageDelayed(SCROLL_VIEWPAGER, Config.BANNER_INTERVAL);
                    break;
            }
        }
    }

    private void onPagerChange(){
        if(adapter != null)
        adapter.onPagerChange();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeMessages(HomeFragmentHandler.SCROLL_VIEWPAGER);
    }


    @Override
    public void onResume() {
        super.onResume();
        handler.sendEmptyMessageDelayed(HomeFragmentHandler.SCROLL_VIEWPAGER, Config.BANNER_INTERVAL);
    }

}
