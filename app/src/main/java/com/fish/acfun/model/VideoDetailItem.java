package com.fish.acfun.model;

import java.util.List;

/**
 * Created by lyjq on 2015/12/24.
 */
public class VideoDetailItem {
    /**
     * channelId : 106
     * contentId : 2398691
     * cover : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/18164606y5ru8ezg.jpg
     * description : 视频来自YouTube。视频地址https://www.youtube.com/watch?v=wQytq8y7l_w。
     * display : 0
     * isArticle : 0
     * isRecommend : 1
     * owner : {"avatar":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/030948126rme7zxr.jpg","id":2426674,"name":"会飞的前任"}
     * releaseDate : 1450420045000
     * status : 2
     * tags : ["动漫","一拳超人"]
     * title : 一拳超人里的八大真相！
     * topLevel : 0
     * updatedAt : 1450937999000
     * videoCount : 1
     * videos : [{"allowDanmaku":1,"commentId":2995494,"danmakuId":2995494,"sourceId":"2995494","sourceType":"zhuzhan","startTime":0,"time":230,"title":"Part 1","url":"","videoId":2995494}]
     * viewOnly : 0
     * visit : {"comments":99,"danmakuSize":155,"goldBanana":157,"score":0,"stows":83,"ups":0,"views":111606}
     */
    private int channelId;
    private int contentId;
    private String cover;
    private String description;
    private int display;
    private int isArticle;
    private int isRecommend;
    private Owner owner;
    private long releaseDate;
    private int status;
    private String title;
    private int topLevel;
    private long updatedAt;
    private int videoCount;
    private int viewOnly;
    private VisitEntity visit;
    private List<String> tags;
    private List<Videos> videos;

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getIsArticle() {
        return isArticle;
    }

    public void setIsArticle(int isArticle) {
        this.isArticle = isArticle;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(int topLevel) {
        this.topLevel = topLevel;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getViewOnly() {
        return viewOnly;
    }

    public void setViewOnly(int viewOnly) {
        this.viewOnly = viewOnly;
    }

    public VisitEntity getVisit() {
        return visit;
    }

    public void setVisit(VisitEntity visit) {
        this.visit = visit;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Videos> getVideos() {
        return videos;
    }

    public void setVideos(List<Videos> videos) {
        this.videos = videos;
    }
}
