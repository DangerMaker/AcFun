package com.fish.acfun.model;

import com.google.android.libraries.mediaframework.exoplayerextensions.Video;

/**
 * Created by lyjq on 2015/12/15.
 */
public class VideoItem {
    /**
     * The title of the video.
     */
    public final String title;

    /**
     * The actual content video (contains its URL, media type - either DASH or mp4,
     * and an optional media type).
     */
    public final Video video;

    /**
     * The URL of the VAST document which represents the ad.
     */
    public final String adUrl;

    /**
     * @param title The title of the video.
     * @param video The actual content video (contains its URL, media type - either DASH or mp4,
     *                  and an optional media type).
     * @param adUrl The URL of the VAST document which represents the ad.
     */
    public VideoItem(String title, Video video, String adUrl) {
        this.title = title;
        this.video = video;
        this.adUrl = adUrl;
    }
}
