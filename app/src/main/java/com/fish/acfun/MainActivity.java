package com.fish.acfun;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.model.VideoItem;
import com.fish.acfun.player.ImaPlayer;
import com.google.android.libraries.mediaframework.exoplayerextensions.Video;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by lyjq on 2015/12/14.
 */
public class MainActivity extends BaseActivity{

    @Bind(R.id.video_frame)
    FrameLayout videoPlayerContainer;
    @Bind(R.id.video_small_screen)
    ImageView imageView;
    @Bind(R.id.video_bottom)
    View bottom;
    private ImaPlayer imaPlayer;

    String title;
    String videoUrl;
    String videoType;

    @OnClick(R.id.video_small_screen)
    void enterFullScreen(){
        Video video = new Video("http://cmcc.ips.cnlive.com/content/movie?contentId=610715507&productid=2028593910&ratelevel=3",
                Video.VideoType.HLS);
        VideoItem videoItem = new VideoItem("acfun",video,null);
        FishApplication.videoItem = videoItem;
        Intent intent = new Intent();
        intent.setClass(this, VideoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


}
