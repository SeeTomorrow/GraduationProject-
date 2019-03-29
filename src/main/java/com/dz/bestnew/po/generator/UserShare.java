package com.dz.bestnew.po.generator;

import java.util.Date;

public class UserShare extends UserShareKey {
    private Integer shareWay;

    private Date shareTime;

    public Integer getShareWay() {
        return shareWay;
    }

    public void setShareWay(Integer shareWay) {
        this.shareWay = shareWay;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }
}