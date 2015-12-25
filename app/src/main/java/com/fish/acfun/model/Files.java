package com.fish.acfun.model;

import java.util.List;

/**
 * Created by lyjq on 2015/12/25.
 */
public class Files {
    private int code;
    private String description;
    private List<String> url;

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getUrl() {
        return url;
    }
}
