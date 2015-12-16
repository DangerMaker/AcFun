package com.fish.acfun;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fish.acfun.base.BaseActivity;
import com.fish.acfun.model.VideoItem;
import com.fish.acfun.player.ImaPlayer;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.libraries.mediaframework.exoplayerextensions.ExoplayerWrapper;

import butterknife.Bind;

/**
 * Created by lyjq on 2015/12/15.
 */
public class VideoActivity extends BaseActivity {

    @Bind(R.id.video_frame)
    FrameLayout videoPlayerContainer;
    @Bind(R.id.loading)
    FrameLayout loading;
    private ImaPlayer imaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        if (FishApplication.videoItem != null)
            createImaPlayer(FishApplication.videoItem);
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
            Log.e("Exo",playbackState+"");
            if(playWhenReady && playbackState== ExoPlayer.STATE_READY) {
                loading.setVisibility(View.GONE);
            }
        }

        @Override
        public void onError(Exception e) {
            // Do nothing. VideoSurfaceLayer doesn't care about errors here.
            Log.e("Exo","onError");
        }

        @Override
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthAspectRatio) {
            Log.e("Exo","onVideoSizeChanged");
        }
    };

    @Override
    protected void onDestroy() {
        if (imaPlayer != null) {
            imaPlayer.release();
        }
        super.onDestroy();
    }
}
