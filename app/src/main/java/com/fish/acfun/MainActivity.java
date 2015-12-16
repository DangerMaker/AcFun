package com.fish.acfun;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.model.VideoItem;
import com.fish.acfun.player.ImaPlayer;
import com.fish.acfun.widget.ProgressAnimBar;
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
//    @Nullable
//    @Bind(R.id.image_loading)
//    SimpleDraweeView simpleDraweeView;
    @Bind(R.id.progressbar)
    ProgressAnimBar progressAnimBar;

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
//        initView();
        start();
    }

//    private void initView(){
//        ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.image_loading_holder).build();
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setAutoPlayAnimations(true)
//                .build();
//        simpleDraweeView.setController(controller);
//    }

    private void start(){
        progressAnimBar.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }).start();
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           progressAnimBar.stop();
        }
    };
}
