package com.fish.acfun.model;

/**
 * Created by lyjq on 2015/12/25.
 */
public class Videos {
    /**
     * allowDanmaku : 1
     * commentId : 2995494
     * danmakuId : 2995494
     * sourceId : 2995494
     * sourceType : zhuzhan
     * startTime : 0
     * time : 230
     * title : Part 1
     * url :
     * videoId : 2995494
     */
    private int allowDanmaku;
    private int commentId;
    private int danmakuId;
    private String sourceId;
    private String sourceType;
    private int startTime;
    private int time;
    private String title;
    private String url;
    private int videoId;

    public int getAllowDanmaku() {
        return allowDanmaku;
    }

    public void setAllowDanmaku(int allowDanmaku) {
        this.allowDanmaku = allowDanmaku;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getDanmakuId() {
        return danmakuId;
    }

    public void setDanmakuId(int danmakuId) {
        this.danmakuId = danmakuId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
