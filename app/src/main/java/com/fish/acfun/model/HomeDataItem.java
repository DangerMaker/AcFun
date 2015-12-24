package com.fish.acfun.model;

import java.util.List;

/**
 * Created by lyjq on 2015/12/18.
 */
public class HomeDataItem {
    /**
     * belong : 0
     * channelId : 0
     * contentCount : 5
     * contents : [{"actionId":1,"hide":0,"id":10506,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/181809341f8dbshg.jpg","regionId":1,"releasedAt":1450433381000,"subTitle":"","title":"银魂MAD(角标)          我这把肮脏的剑，有必须要保护的东西！","url":"2393853"},{"actionId":1,"hide":0,"id":10466,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/18165232t6dc204z.jpg","regionId":1,"releasedAt":1450424457000,"subTitle":"","subUrl":"","title":"那年那兔那些事儿 第二季 第4集","url":"2398399"},{"actionId":1,"hide":0,"id":10464,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/18150339c85mdoqr.jpg","regionId":1,"releasedAt":1450422225000,"subTitle":"","title":"暴走大事件第四季  霾瘾少年的不归路","url":"2397462"},{"actionId":1,"hide":0,"id":10395,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/18104719tkl5cmqu.jpg","regionId":1,"releasedAt":1450406844000,"subTitle":"","title":"IGN全球游戏预告排行榜  12月上","url":"2396282"},{"actionId":1,"hide":0,"id":10376,"image":"http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201512/17191914aqw14ebb.jpg","regionId":1,"releasedAt":1450351173000,"subTitle":"","title":"超进化！二次元乌镇峰会","url":"2396980"}]
     * goText :
     * hide : 0
     * id : 1
     * image :
     * menuCount : 0
     * name : 轮播图
     * platformId : 1
     * showMore : 0
     * showName : 0
     * sort : 200
     * type : {"id":5,"name":"轮播","value":"carousels"}
     * url :
     */

    private int belong;
    private int channelId;
    private int contentCount;
    private String goText;
    private int hide;
    private int id;
    private String image;
    private int menuCount;
    private String name;
    private int platformId;
    private int showMore;
    private int showName;
    private int sort;
    private HomeType type;
    private String url;
    private List<HomeContent> contents;

    public int getBelong() {
        return belong;
    }

    public void setBelong(int belong) {
        this.belong = belong;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getContentCount() {
        return contentCount;
    }

    public void setContentCount(int contentCount) {
        this.contentCount = contentCount;
    }

    public String getGoText() {
        return goText;
    }

    public void setGoText(String goText) {
        this.goText = goText;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(int menuCount) {
        this.menuCount = menuCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getShowMore() {
        return showMore;
    }

    public void setShowMore(int showMore) {
        this.showMore = showMore;
    }

    public int getShowName() {
        return showName;
    }

    public void setShowName(int showName) {
        this.showName = showName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public HomeType getType() {
        return type;
    }

    public void setType(HomeType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<HomeContent> getContents() {
        return contents;
    }

    public void setContents(List<HomeContent> contents) {
        this.contents = contents;
    }
}
