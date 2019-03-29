package com.dz.bestnew.serviceImp;

import com.dz.bestnew.po.EmailInfo;
import com.dz.bestnew.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 描述:
 * 邮箱服务实现类
 *
 * @author 秃头的安娜
 * @create 2019-03-25 18:23
 */

@Service
public class EmailServiceImp implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    //读取文件中的发件人
    @Value("${spring.mail.username}")
    private String Sender;

    /*@Value("${spring.mail.username}")
    public void setSender(String sender) {
        Sender = sender;
    }*/

    /*
     * @Title: sendSimpleMail
     * @Description:
     *  发送简单文本
     * @date: 2019/3/25 18:28
     * @param: [emailModel]
     * @return: int 验证码
     *
     */
    @Override
    public HashMap sendSimpleMail(EmailInfo emailModel) {
        HashMap<String,Object> hashMap = new HashMap<>();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(emailModel.getTo());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getContent());
        mailSender.send(message);
        hashMap.put("email",emailModel.getTo());
        hashMap.put("security",emailModel.getSecurity());
        return hashMap;
    }

    @Override
    public void sendHtmlMail(EmailInfo emailModel) {

    }
}