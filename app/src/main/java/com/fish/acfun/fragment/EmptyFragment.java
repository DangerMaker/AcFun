package com.fish.acfun.fragment;

import com.fish.acfun.R;

import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by lyjq on 2015/12/25.
 */
public class EmptyFragment extends BaseLoadFragment {

    @Override
    protected void onLoadData() {

    }

    @Override
    protected void onInitLoadData(Object pageData) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_empty;
    }

    @Override
    public void onResponse(Response response, Retrofit retrofit) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
