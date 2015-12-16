package com.fish.acfun;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.fish.acfun.model.VideoItem;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by lyjq on 2015/12/15.
 */
public class FishApplication extends Application {
    static VideoItem videoItem;
    @Override
    public void onCreate() {
        super.onCreate();
        //config for fresco
        ImagePipelineConfig imagePipelineConfig = OkHttpImagePipelineConfigFactory.newBuilder(this,new OkHttpClient()).build();
        Fresco.initialize(this,imagePipelineConfig);
    }
}
