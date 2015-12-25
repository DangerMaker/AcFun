package com.fish.acfun.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fish.acfun.R;
import com.fish.acfun.VideoDetailActivity;
import com.fish.acfun.model.HomeContent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lyjq on 2015/12/19.
 */
public class HomeVieo extends RelativeLayout implements View.OnClickListener{
    @Bind(R.id.home_video_image)
    SimpleDraweeView draweeView;
    @Bind(R.id.home_video_title)
    TextView title;
    @Bind(R.id.home_video_count)
    TextView count;
    @Bind(R.id.home_video_comment)
    TextView comment;

    HomeContent homeContent;
    public HomeVieo(Context context) {
        super(context);
        init(context);
    }

    public HomeVieo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HomeVieo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.home_video_view,this);
        ButterKnife.bind(view, this);
    }

    public void addData(HomeContent homeContent){
        this.homeContent = homeContent;
        draweeView.setImageURI(Uri.parse(homeContent.getImage()));
        title.setText(homeContent.getTitle());
        count.setText(homeContent.getVisit().getViews() + "");
        comment.setText(homeContent.getVisit().getComments() + "");
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e("enter", "detail");
        Intent intent = new Intent(v.getContext(),VideoDetailActivity.class);
        String cid = homeContent != null ? homeContent.getUrl(): "";
        intent.putExtra("cid",cid);
        v.getContext().startActivity(intent);
    }
}
