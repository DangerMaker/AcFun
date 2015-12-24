package com.fish.acfun.model;

/**
 * Created by lyjq on 2015/12/18.
 */
public class HomeContent {


    /**
     * actionId : 1
     * channelId : 90
     * hide : 0
     * id : 10382
     * image : http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/16224211dmcgzsz7.jpg
     * intro : 《Kara by Quantic Dream》一部讲述机器人伦理的科幻短片 <br/>微信搜索：极客船长，关注好玩的黑科技产品！
     * regionId : 3
     * releasedAt : 1450404969000
     * status : 2
     * subTitle :
     * title : 我的机器人老婆.avi
     * url : 2395332
     * visit : {"comments":193,"danmakuSize":190,"goldBanana":415,"score":0,"stows":612,"ups":0,"views":105947}
     */

    private int actionId;
    private int channelId;
    private int hide;
    private int id;
    private String image;
    private String intro;
    private int regionId;
    private long releasedAt;
    private int status;
    private String subTitle;
    private String title;
    private String url;
    /**
     * comments : 193
     * danmakuSize : 190
     * goldBanana : 415
     * score : 0
     * stows : 612
     * ups : 0
     * views : 105947
     */

    private VisitEntity visit;
    private BangumiEntity latestBangumiVideo;

    public BangumiEntity getLatestBangumiVideo() {
        return latestBangumiVideo;
    }

    public void setLatestBangumiVideo(BangumiEntity latestBangumiVideo) {
        this.latestBangumiVideo = latestBangumiVideo;
    }

    public void setActionId(int actionId) {

        this.actionId = actionId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public void setReleasedAt(long releasedAt) {
        this.releasedAt = releasedAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVisit(VisitEntity visit) {
        this.visit = visit;
    }

    public int getActionId() {
        return actionId;
    }

    public int getChannelId() {
        return channelId;
    }

    public int getHide() {
        return hide;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getIntro() {
        return intro;
    }

    public int getRegionId() {
        return regionId;
    }

    public long getReleasedAt() {
        return releasedAt;
    }

    public int getStatus() {
        return status;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public VisitEntity getVisit() {
        return visit;
    }
}
