package com.fish.acfun;

import android.app.Application;

import com.fish.acfun.model.VideoItem;

/**
 * Created by lyjq on 2015/12/15.
 */
public class FishApplication extends Application {
    static VideoItem videoItem;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
