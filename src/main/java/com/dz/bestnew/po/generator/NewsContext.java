package com.dz.bestnew.po.generator;

public class NewsContext {
    private Integer newsContextId;

    private Integer newsTitleId;

    private String context;

    public Integer getNewsContextId() {
        return newsContextId;
    }

    public void setNewsContextId(Integer newsContextId) {
        this.newsContextId = newsContextId;
    }

    public Integer getNewsTitleId() {
        return newsTitleId;
    }

    public void setNewsTitleId(Integer newsTitleId) {
        this.newsTitleId = newsTitleId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}