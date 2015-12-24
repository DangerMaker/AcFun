package com.fish.acfun.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fish.acfun.R;
import com.fish.acfun.base.BaseRecyclerAdapter;
import com.fish.acfun.fragment.BaseLoadFragment;
import com.fish.acfun.model.HomeDataItem;
import com.fish.acfun.widget.BannerView;
import com.fish.acfun.widget.HomeVieo;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lyjq on 2015/12/18.
 */
public class HomeAdapter extends BaseRecyclerAdapter<HomeDataItem> {

    private static final int HOME_TYPE_VIDEO = 1;
    private static final int HOME_TYPE_CAROUSELS = 5; //轮播
    private static final int HOME_TYPE_BANNERS = 6;     //横幅
    private static final int HOME_TYPE_BANGUMIS = 3; //番剧
    private BannerView mBannerView;
    private Context mContext;

    public HomeAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case HOME_TYPE_CAROUSELS:
                viewHolder = new HomeBannerHodler(mBannerView = new BannerView(mContext));
                break;
            case HOME_TYPE_VIDEO:
                viewHolder = new HomeVideoHolder(LayoutInflater.from(mContext).inflate(R.layout.home_video,parent,false));
                break;
            case HOME_TYPE_BANNERS:
                viewHolder = new HomeRankHolder(LayoutInflater.from(mContext).inflate(R.layout.home_rank,parent,false));
                break;
            case HOME_TYPE_BANGUMIS:

                break;
            default:
                break;
        }
        return viewHolder;
    }

    public void onPagerChange() {
        if (mBannerView != null) mBannerView.showNextPage();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final HomeDataItem item = getItem(position);

        switch (getItemViewType(position)) {
            case HOME_TYPE_CAROUSELS:
                HomeBannerHodler banner_hodler = (HomeBannerHodler) holder;
                banner_hodler.view.setData(item.getContents());
                break;
            case HOME_TYPE_VIDEO:
                HomeVideoHolder videoHolder = (HomeVideoHolder) holder;
                videoHolder.draweeView.setImageURI(Uri.parse(item.getImage()));
                videoHolder.title.setText(item.getName());
                videoHolder.homeVieo1.addData(item.getContents().get(0));
                videoHolder.homeVieo2.addData(item.getContents().get(1));
                videoHolder.homeVieo3.addData(item.getContents().get(2));
                videoHolder.homeVieo4.addData(item.getContents().get(3));
                break;
            case HOME_TYPE_BANNERS:
                HomeRankHolder homeRankHolder = (HomeRankHolder) holder;
                homeRankHolder.simpleDraweeView.setImageURI(Uri.parse(item.getContents().get(0).getImage()));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int id = getItem(position).getType().getId();
        return id;
    }

    public class HomeBannerHodler extends RecyclerView.ViewHolder {
        public BannerView view;
        public HomeBannerHodler(BannerView bannerView) {
            super(bannerView);
            view = bannerView;
        }
    }

    public class HomeVideoHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.home_item_image)
        public SimpleDraweeView draweeView;
        @Bind(R.id.home_item_name)
        public TextView title;
        @Bind(R.id.home_video1)
        public HomeVieo homeVieo1;
        @Bind(R.id.home_video2)
        public HomeVieo homeVieo2;
        @Bind(R.id.home_video3)
        public HomeVieo homeVieo3;
        @Bind(R.id.home_video4)
        public HomeVieo homeVieo4;
        public HomeVideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class HomeRankHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.home_rank)
        SimpleDraweeView simpleDraweeView;

        public HomeRankHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
