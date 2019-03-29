package com.dz.bestnew.service;

import com.dz.bestnew.po.myPOJO.EmailInfo;

import java.util.HashMap;

/**
 * 描述:
 * 邮箱服务类
 *
 * @author 秃头的安娜
 * @create 2019-03-25 18:20
 */
public interface EmailService {
    HashMap sendSimpleMail(EmailInfo emailModel);
    void sendHtmlMail(EmailInfo emailModel);
}