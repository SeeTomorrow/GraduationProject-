package com.dz.bestnew.po.myPOJO;

import com.dz.bestnew.utils.user.UserUtils;

import java.util.List;

/**
 * 描述:
 * 邮箱信息
 *
 * @author 秃头的安娜
 * @create 2019-03-25 18:11
 */
public class EmailInfo {
    private String from;              //发件人（获取配置文件中的发送人信息）
    private String to;                //收件人
    private String subject;          //邮件主题
    private String content;          //邮件内容，（包括html）
    private int security;            //验证码
    private List<String> attachPath; //附件路径

    public EmailInfo() {
        security= UserUtils.getSecurity();
    }

    public int getSecurity() {
        return security;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(List<String> attachPath) {
        this.attachPath = attachPath;
    }
}