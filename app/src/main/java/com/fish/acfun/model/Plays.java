package com.fish.acfun.model;

import java.util.List;

/**
 * Created by lyjq on 2015/12/25.
 */
public class Plays {
    private String source;
    private String title;
    private int totalseconds;
    /**
     * code : 1
     * description : 标清
     * url : ["http://vplay.aixifan.com/des/20151224/3012439_wmv/3012439_360p.mp4?k=b8eb54c4b4b0429be43e454daff80e43&t=1451027344"]
     */

    private List<Files> files;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalseconds() {
        return totalseconds;
    }

    public void setTotalseconds(int totalseconds) {
        this.totalseconds = totalseconds;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }
}
