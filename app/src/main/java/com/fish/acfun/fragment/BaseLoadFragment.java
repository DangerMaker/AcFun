package com.fish.acfun.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.fish.acfun.R;

import butterknife.Bind;
import retrofit.Call;
import retrofit.Callback;

/**
 * Created by lyjq on 2015/12/17.
 */
public abstract class BaseLoadFragment<T> extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, Callback<T> {

    protected T mPageData ;
    protected boolean isLoading;
    @Nullable
    @Bind(R.id.swipe_refresh)SwipeRefreshLayout mSwipeRefreshLayout;
    @Nullable @Bind(android.R.id.empty)
    protected View mEmptyView;
    @Nullable @Bind(R.id.image_loading)
    protected SimpleDraweeView mEmptyProgressbar;
    @Nullable @Bind(R.id.empty_button)
    protected Button mEmptyBtn;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mPageData == null) {
            onLoadData();
        }else{
            onInitLoadData(mPageData);
        }
        if(mSwipeRefreshLayout!=null) mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {//刷新数据
        onLoadData();
    }

    protected abstract void onLoadData();

    protected abstract void onInitLoadData(T pageData);

    protected void stopRefresh(){
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);//停止刷新
        }
    }

    protected void setPageData(T page_data){
        this.mPageData = page_data;
        onInitLoadData(page_data);
    }

    protected void showLoad() {
        if(getActivity() == null) return ;
        showLoad("loading");
    }

    protected void showLoad(String str) {
        if(getActivity() == null) return ;
        if(mPageData != null) return ;
        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.VISIBLE);
        if(mEmptyBtn != null) mEmptyBtn.setVisibility(View.GONE);
        loadImage();
    }

    protected void showConnectionRetry() {
        if(getActivity() == null) return ;
        showConnectionRetry("retry");
    }

    protected void showConnectionRetry(String str) {
        if (getActivity() == null) return ;
        if (mPageData != null) return ;
        if (mEmptyBtn != null) {
            mEmptyBtn.setText(str);
            mEmptyBtn.setVisibility(View.VISIBLE);
            mEmptyBtn.setOnClickListener(mOnClickListener);
        }
        mEmptyProgressbar.setVisibility(View.GONE);
    }

    protected void hideEmptyView(){
        if (mEmptyBtn != null) mEmptyBtn.setVisibility(View.GONE);
        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.GONE);
    }

    protected View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showLoad();
            onLoadData();
        }
    };

//    protected void showImage(int res) {
//        if (mPageData != null) return ;
//        if (mEmptyView != null) mEmptyView.setVisibility(View.VISIBLE);
//        if (mEmptyProgressbar != null) mEmptyProgressbar.setVisibility(View.GONE);
//    }
    ImageRequest request = null;
    DraweeController controller = null;
    private void loadImage(){
        if(request == null || controller == null){
            request = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.image_loading_holder).build();
            controller = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setAutoPlayAnimations(true)
                    .build();
        }
        if(mEmptyProgressbar != null)
        mEmptyProgressbar.setController(controller);
    }
}
