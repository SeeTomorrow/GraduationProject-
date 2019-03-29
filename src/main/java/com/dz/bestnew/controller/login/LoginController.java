package com.dz.bestnew.controller.login;

import com.dz.bestnew.po.RegisterUser;
import com.dz.bestnew.po.User;
import com.dz.bestnew.service.EmailService;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.utils.Utils;
import com.dz.bestnew.utils.mail.MailUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;

/**
 * 描述:
 * 用户登录处理
 *
 * @author 秃头的安娜
 * @create 2019-02-26 10:58
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private EmailService emailService;


    //存储进行注册操作的邮箱和该邮箱生成的验证码
    private static HashMap<String,Object> hashMap;

    public static HashMap<String, Object> getHashMap() {

        return hashMap;
    }


    private static final Logger logger=LoggerFactory.getLogger(LoginController.class);

    /*
     * @Title: login
     * @Description:
     *  必须使用@Valid标注我们需要校验的参数user，否则Spring不会对它进行校验
     *  BindingResult参数是必须紧挨着@Valid参数的，即必须紧挨着需要校验的参数，这就意味着我们有多少个@Valid参数就需要有多少个对应的Errors参数，它们是一一对应的
     * @date: 2019/2/27 17:48
     * @param: [user, request, response, result]
     * @return: void
     *
     */
    @PostMapping("/user/login")
    public void login(@Valid User user, BindingResult result, HttpServletRequest request, HttpServletResponse response){
        System.out.println(user);
        logger.info("请求Url:"+request.getRequestURL()+"=="+request.getMethod());
        logger.info("准备登录用户...正在验证用户输入合法性");

        response.setContentType("text/html;charset=UTF-8");
        JSONObject messageJson=Utils.getJson();
        boolean successValue = false;

        //校验数据合法性
        if(result.hasFieldErrors()) {
            logger.info("用户输入不合法");
            for (FieldError fieldError : result.getFieldErrors()) {
                messageJson.put("message", fieldError.getDefaultMessage());
            }
        }else {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());

            //获取当前Subject
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.getSession();
            /*
             *在调用了login()后，SecurityManager会收到AuthenticationToken
             *并将其发送给配置好的Realm执行必须的认证操作
             *调用login(token)时，会执行到UserReam.doGetAuthenticationInfo()
             */

            try {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证开始");

                currentUser.login(token);

                if (currentUser.isAuthenticated()) {
                    successValue = true;
                }

                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证通过");
            } catch (UnknownAccountException uae) {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证未通过，未知账户");
                messageJson.put("message", uae.getMessage());
            } catch (IncorrectCredentialsException ice) {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证未通过，错误的凭证");
                messageJson.put("message", ice.getMessage());
            } catch (LockedAccountException lae) {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证未通过，账户已锁定");
                messageJson.put("message", "账户已锁定，请联系管理员");
            } catch (ExcessiveAttemptsException eae) {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证未通过，错误次数过多");
                messageJson.put("message", eae.getMessage());
            } catch (AuthenticationException ae) {
                logger.info("对用户[" + user.getEmail() + "]进行登陆验证...验证未通过");
                ae.printStackTrace();
            }


        }
            try {
                messageJson.put("success",successValue);
                System.out.println(messageJson.toString());
                response.getWriter().print(messageJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    

    
    @PostMapping("/user/register")
    public void register(@Valid RegisterUser user, BindingResult result,HttpServletRequest request, HttpServletResponse response){
        logger.info("请求Url:"+request.getRequestURL()+"=="+request.getMethod());
        logger.info("准备注册用户...正在验证用户输入合法性");

        response.setContentType("text/html;charset=UTF-8");
        JSONObject messageJson=Utils.getJson();
        boolean successValue = false;

        //校验数据合法性
        if(result.hasFieldErrors()) {
            logger.info("用户输入不合法");
            for (FieldError fieldError : result.getFieldErrors()) {
                messageJson.put("message", fieldError.getDefaultMessage());
            }
        }else{
            successValue=loginService.register(user);
        }

        messageJson.put("success",successValue);
        try {
            System.out.println(messageJson.toString());
            response.getWriter().print(messageJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * @Title: getSecurity
     * @Description:
     *  发送验证码至注册用户邮箱
     * @date: 2019/3/25 20:06
     * @param: [user]
     * @return: void
     *
     */

    @GetMapping("/email/getSecurity")
    public void getSecurity(String email,
                            HttpServletRequest request, HttpServletResponse response){

        logger.info("请求Url:"+request.getRequestURL()+"=="+request.getParameter("email")+"=="+request.getMethod()+"=="+request.getRequestURI());
        response.setContentType("text/html;charset=UTF-8");
        JSONObject messageJson=Utils.getJson();
        boolean successValue = false;


        //校验数据合法性

        if(email==null||email.equals("")){
            messageJson.put("message","邮箱不能为空");
        }else if(!email.matches("\\w{2,15}[@][a-z0-9]{2,}[.]\\p{Lower}{2,}")){
            messageJson.put("message","邮箱格式有误");
        }else {
            if (loginService.getUserByEmail(email) != null) {
                messageJson.put("message", "邮箱已注册过");
            } else {
                hashMap = emailService.sendSimpleMail(MailUtil.getMailModel(email));
            }
        }
        try {
            if(hashMap!=null)
                successValue=true;
            messageJson.put("success",successValue);
            System.out.println(messageJson.toString());
            response.getWriter().print(messageJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @GetMapping("/user/logout")
    public void logout(){
        //使用权限管理工具进行用户的退出
        SecurityUtils.getSubject().logout();
        return ;
    }




}