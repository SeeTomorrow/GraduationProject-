package com.dz.bestnew.po.generator;

import java.util.Date;

public class NewsTitle {
    private Integer newsTitleId;

    private String title;

    private Integer userId;

    private Date putTime;

    private String newsTitleImg;

    public Integer getNewsTitleId() {
        return newsTitleId;
    }

    public void setNewsTitleId(Integer newsTitleId) {
        this.newsTitleId = newsTitleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public String getNewsTitleImg() {
        return newsTitleImg;
    }

    public void setNewsTitleImg(String newsTitleImg) {
        this.newsTitleImg = newsTitleImg == null ? null : newsTitleImg.trim();
    }
}