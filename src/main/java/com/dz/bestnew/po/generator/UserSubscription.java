package com.dz.bestnew.po.generator;

import java.util.Date;

public class UserSubscription extends UserSubscriptionKey {
    private Date sendtime;

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}