package com.fish.acfun.model;

/**
 * Created by lyjq on 2015/12/20.
 */
public class BangumiEntity {

    /**
     * bangumiId : 1470361
     * sort : 120
     * title : 第12话
     * updateTime : 1450425570000
     * videoId : 2995659
     */

    private int bangumiId;
    private int sort;
    private String title;
    private long updateTime;
    private int videoId;

    public int getBangumiId() {
        return bangumiId;
    }

    public void setBangumiId(int bangumiId) {
        this.bangumiId = bangumiId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
