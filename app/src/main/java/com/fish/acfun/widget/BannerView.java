package com.fish.acfun.widget;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.fish.acfun.R;
import com.fish.acfun.base.SimplePagerAdapter;
import com.fish.acfun.model.HomeContent;

import java.util.List;


public class BannerView extends RelativeLayout {

    private static final long click_timeout = 110;
    private static long click_time = 0;
    private ViewPager mViewPager;
    private LinearLayout group;
    private BannerAdapter bannerAdapter;
//    private TextView title;
    private List<HomeContent> view_data;
    private ImageView[] indicators;
    private float click_x = 0;
    private boolean onTouch = false, onShowNext = true;
    int border = 18;

    private ViewPager.SimpleOnPageChangeListener pagerChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < indicators.length; i++) {
//                indicators[i].setBackgroundColor(getResources().getColor((position % view_data.size() != i)
//                        ? android.R.color.white : R.color.banner_icon));
                indicators[i].setBackgroundResource((position % view_data.size() != i) ? R.drawable.ic_slide_banner_unselect :R.drawable.ic_slide_banner_select);
            }
            HomeContent item = view_data.get(position % view_data.size());
//            title.setText(item.getTitle());
        }
    };

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void showNextPage() {
        if (!onShowNext) {
            if (!onTouch) onShowNext = true;
        } else if (null != mViewPager && null != bannerAdapter && bannerAdapter.getList().size() > 1) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                click_time = System.currentTimeMillis();
                click_x = ev.getX();
                onTouch = true;
                onShowNext = false;
                break;
            case MotionEvent.ACTION_UP:
                onTouch = false;
                if (bannerAdapter != null && mViewPager != null && bannerAdapter.getCount() > mViewPager.getCurrentItem()
                        && click_time + click_timeout >= System.currentTimeMillis() && Math.abs(ev.getX() - click_x) < 50) {

                    int position = (mViewPager.getCurrentItem() % view_data.size());
                    //TODO 跳转 Type 类型

//                    ActivityJumper.JumpToProgramDetail(getContext(), view_data.get(position));
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void init() {
        int width = Math.min(
                getResources().getDisplayMetrics().widthPixels,
                getResources().getDisplayMetrics().heightPixels);
        LayoutInflater.from(getContext()).inflate(R.layout.banner_home, this);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.getLayoutParams().width = width;
        mViewPager.getLayoutParams().height = (int)(width / 1.9);
        group = (LinearLayout) findViewById(R.id.viewGroup);
//        title = (TextView) findViewById(R.id.title);
    }

    public void setData(List<HomeContent> list) {
        if (list != null && list.size() > 0) {
            view_data = list;
//            title.setText(view_data.get(0).getTitle());
            addIndicator(view_data.size());
            mViewPager.setAdapter(bannerAdapter = new BannerAdapter(view_data));
            mViewPager.setOnPageChangeListener(pagerChangeListener);
            mViewPager.setCurrentItem(500 - 500 % view_data.size());
        } else {
            mViewPager.getLayoutParams().height = 1;
        }
    }

    private void addIndicator(int count) {
        indicators = new ImageView[count];
        group.removeAllViews();
        int margin = 18;
        for (int i = 0; i < count; i++) {
            ImageView textView = new ImageView(getContext());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(border, border);
            lp.setMargins(margin, 0, margin, 0);
            textView.setLayoutParams(lp);

            indicators[i] = textView;

//            indicators[i].setBackgroundColor(getResources().getColor((i == 0) ?
//                    R.color.banner_icon : android.R.color.white));
            indicators[i].setBackgroundResource((i == 0) ?R.drawable.ic_slide_banner_select :R.drawable.ic_slide_banner_unselect);
            group.addView(textView);
        }
    }

    private class BannerAdapter extends SimplePagerAdapter<HomeContent> {

        public BannerAdapter(List<HomeContent> list) {
            super(list);
        }

        @Override
        public int getCount() {
            if (getList() != null && getList().size() > 0) {
                return Integer.MAX_VALUE;
            } else {
                return 0;
            }
        }

        @Override
        public View getItemView(ViewGroup container, int position) {
            position = position % getList().size();
            HomeContent item = view_data.get(position);
            SimpleDraweeView imageview = new SimpleDraweeView(getContext());

            GenericDraweeHierarchy hierarchy = imageview.getHierarchy();
            hierarchy.setPlaceholderImage(R.drawable.loading_bg);

            imageview.setLayoutParams(
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
            imageview.setBackgroundResource(R.drawable.loading_bg);
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            if (!TextUtils.isEmpty(item.getImage()))
                imageview.setImageURI(Uri.parse(item.getImage()));
            return imageview;
        }

    }

}
