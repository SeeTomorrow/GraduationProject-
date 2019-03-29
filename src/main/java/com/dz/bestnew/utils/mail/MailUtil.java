package com.dz.bestnew.utils.mail;

import com.dz.bestnew.po.EmailInfo;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 邮件工具类
 *
 * @author 秃头的安娜
 * @create 2019-03-25 19:25
 */

@Component
public class MailUtil {

    /*
     * @Title: getMailModel
     * @Description:
     *  通过传入的用户邮箱返回一个邮箱模型
     * @date: 2019/3/25 19:55
     * @param: [user]
     * @return: com.dz.bestnew.po.EmailInfo
     *
     */
    public static EmailInfo getMailModel (String email){
        EmailInfo mailModel=new EmailInfo();
        fillMailModel(email,mailModel);
        return mailModel;
    }


    private static void fillMailModel(String email,EmailInfo mailModel){
        mailModel.setTo(email);
        mailModel.setSubject("验证码");
        mailModel.setContent("您的验证码为"+mailModel.getSecurity());
    }
}


