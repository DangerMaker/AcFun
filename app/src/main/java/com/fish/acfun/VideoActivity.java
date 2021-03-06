package com.fish.acfun;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fish.acfun.api.CmsApi;
import com.fish.acfun.api.RestService;
import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.base.Config;
import com.fish.acfun.model.VideoItem;
import com.fish.acfun.model.VideoPlays;
import com.fish.acfun.player.ImaPlayer;
import com.fish.acfun.widget.ProgressAnimBar;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.libraries.mediaframework.exoplayerextensions.ExoplayerWrapper;
import com.google.android.libraries.mediaframework.exoplayerextensions.Video;

import butterknife.Bind;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by lyjq on 2015/12/15.
 */
public class VideoActivity extends BaseActivity {

    @Bind(R.id.video_frame)
    FrameLayout videoPlayerContainer;
    @Bind(R.id.loading)
    FrameLayout loading;
    private ImaPlayer imaPlayer;
    @Bind(R.id.progressbar)
    ProgressAnimBar progressAnimBar;

    VideoPlays videoPlays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final String videoId = getIntent().getStringExtra("videoId");
        Call<VideoPlays> call = RestService.getRestAPI(Config.CMS_URL).create(CmsApi.class).getVideoPlays(videoId);
        call.enqueue(new Callback<VideoPlays>() {
            @Override
            public void onResponse(Response<VideoPlays> response, Retrofit retrofit) {
                Log.e("VideoPlays","onResponse");
                videoPlays = response.body();
                if(videoPlays != null) {
                    Video video = new Video(videoPlays.getData().getFiles().get(0).getUrl().get(0),
                            Video.VideoType.MP4);
                    VideoItem videoItem = new VideoItem(videoPlays.getData().getTitle(), video, null);
                    if (videoItem != null)
                        createImaPlayer(videoItem);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("VideoPlays","onFailure");
            }
        });
    }

    public void createImaPlayer(VideoItem videoItem) {
        if (imaPlayer != null) {
            imaPlayer.release();
        }
        // If there was previously a video player in the container, remove it.
        videoPlayerContainer.removeAllViews();

        String adTagUrl = videoItem.adUrl;
        String videoTitle = videoItem.title;

        imaPlayer = new ImaPlayer(this,
                videoPlayerContainer,
                videoItem.video,
                videoTitle,
                playbackListener,
                adTagUrl);
        // Now that the player is set up, let's start playing.
        imaPlayer.play();
    }

    private ExoplayerWrapper.PlaybackListener playbackListener
            = new ExoplayerWrapper.PlaybackListener() {
        @Override
        public void onStateChanged(boolean playWhenReady, int playbackState) {
            // Do nothing. VideoSurfaceLayer doesn't care about state changes.
            Log.e("Exo", playbackState + "");
            if (playbackState == ExoPlayer.STATE_BUFFERING) {
                progressAnimBar.setVisibility(View.VISIBLE);
                handler.sendEmptyMessageDelayed(0, 150);
            }

            if (playWhenReady && playbackState == ExoPlayer.STATE_READY) {
                loading.setVisibility(View.GONE);
                progressAnimBar.setVisibility(View.GONE);
                handler.removeMessages(0);
            }
        }

        @Override
        public void onError(Exception e) {
            // Do nothing. VideoSurfaceLayer doesn't care about errors here.
            Log.e("Exo", "onError");
        }

        @Override
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthAspectRatio) {
            Log.e("Exo", "onVideoSizeChanged");
        }
    };

    @Override
    protected void onDestroy() {
        if (imaPlayer != null) {
            imaPlayer.release();
        }
        handler.removeMessages(0);
        super.onDestroy();
    }

    int i = 0;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (imaPlayer != null) {
                        i = imaPlayer.getContentPlayer().getPlaybackControlLayer().getLayerManager().getExoplayerWrapper().getBufferedPercentage();
                        progressAnimBar.setProgress(i);
                        Log.e("percent",i + "");
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
