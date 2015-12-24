package com.fish.acfun.model;

import java.io.Serializable;

/**
 * Created by zuoxian on 2015/9/21.
 */
public class HomeProgramItem implements Serializable {

    private String isbigimg;
    private String contid;
    private String img;
    private String title;
    private String subtitle;
    private String subicon;
    private String url;
    private String uv;
    private String lback;
    private String islive;
    private String num;
    private String time;

    //评论
    private String good;
    private String middle;
    private String bad;

    private String icon;
    private String livename;

    private String desc;
    private String type;

    private String extend1;//0为直播  1为点播 2为按次广播

    public String getIsbigimg() {
        return isbigimg;
    }

    public void setIsbigimg(String isbigimg) {
        this.isbigimg = isbigimg;
    }

    public HomeProgramItem() {
        }


    public String getSubicon() {
        return subicon;
    }

    public void setSubicon(String subicon) {
        this.subicon = subicon;
    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContid() {
            return contid;
        }

        public void setContid(String contid) {
            this.contid = contid;
        }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getLback() {
        return lback;
    }

    public void setLback(String lback) {
        this.lback = lback;
    }

    public String getIslive() {
        return islive;
    }

    public void setIslive(String islive) {
        this.islive = islive;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getLivename() {
        return livename;
    }

    public void setLivename(String livename) {
        this.livename = livename;
    }

    @Override
    public String toString() {
        return "HomeProgramItem{" +
                "isbigimg='" + isbigimg + '\'' +
                ", contid='" + contid + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", subicon='" + subicon + '\'' +
                ", url='" + url + '\'' +
                ", uv='" + uv + '\'' +
                ", lback='" + lback + '\'' +
                ", islive='" + islive + '\'' +
                ", num='" + num + '\'' +
                ", time='" + time + '\'' +
                ", good='" + good + '\'' +
                ", middle='" + middle + '\'' +
                ", bad='" + bad + '\'' +
                ", icon='" + icon + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", extend1='" + extend1 + '\'' +
                '}';
    }
}
