package com.dz.bestnew.po;

import org.springframework.stereotype.Component;

/**
 * 描述:
 * 注册用户扩展于User类
 *
 * @author 秃头的安娜
 * @create 2019-03-24 15:36
 */

@Component
public class RegisterUser extends User{
    private String Security;
    private String confirm;

    public String getSecurity() {
        return Security;
    }

    public void setSecurity(String security) {
        Security = security;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
}