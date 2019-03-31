package com.dz.bestnew.utils.validator;

import com.dz.bestnew.controller.login.LoginController;
import com.dz.bestnew.po.User;
import com.dz.bestnew.po.myPOJO.RegisterUser;
import com.dz.bestnew.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashMap;

/**
 * 描述:
 * 用户信息校验器
 *
 * @author 秃头的安娜
 * @create 2019-02-27 17:36
 */

@Component
public class UserValidatorUtil implements Validator {

    private static final int MINIMUM_PASSWORD_LENGTH = 6;

    @Autowired
    private LoginService loginService;

    /*
     * @Title: supports
     * @Description:
     *  判断支持的JavaBean类型
     * @date: 2019/2/28 13:51
     * @param: [aClass]
     * @return: boolean
     *
     */
    @Override
    public boolean supports(Class<?> aClass) {


        return RegisterUser.class.equals(aClass) || User.class.equals(aClass);


    }

    /*
     * @Title: validate
     * @Description:
     *  校验规则
     * @date: 2019/2/28 13:52
     * @param: [o, errors]
     * @return: void
     *
     */
    @Override
    public void validate(Object o, Errors errors) {
        //邮箱格式正则表达式
        String checkEmail = "\\w{2,15}[@][a-z0-9]{2,}[.]\\p{Lower}{2,}";

        //登陆数据校验
        if (o.getClass() == User.class) {
            User user = (User) o;
            String password = user.getPassword();
            String email = user.getEmail();
            if (emailValidator(errors, checkEmail, email)) return;
            if (passwordValidator(errors, password)) return;
        }





        //注册数据校验
        if (o.getClass() == RegisterUser.class) {

            HashMap<String,Object> hashMap=LoginController.getHashMap();
            int localSecurity;
            String localEmail;

            RegisterUser user = (RegisterUser) o;
            String password = user.getPassword();
            String email = user.getEmail();
            String confirm = user.getConfirm();
            String security = user.getSecurity();


            if (emailValidator(errors, checkEmail, email)) return;
            if (passwordValidator(errors, password)) return;

            //确认密码校验
            if (confirm == null || confirm .equals("")) {
                errors.rejectValue("confirm", null, "确认密码不能为空");
                return;
            } else if (!password.equals(confirm)) {
                errors.rejectValue("confirm", null, "密码输入不一致");
                return;
            }

            //验证码校验，除了校验验证码还需多加一层注册邮箱验证，以防止不同邮箱使用同一验证码
            if (security == null || security.equals("")){
                errors.rejectValue("security", null, "验证码不能为空");
                return;
            }else if(hashMap==null){
                errors.rejectValue("security", null, "验证码不正确");
                return;
            }else if ((localSecurity=(int)hashMap.get("security"))==0 ||
                        !(localEmail=(String)hashMap.get("email")).equals(email) ||
                    localSecurity!=Integer.valueOf(security)){
                errors.rejectValue("security", null, "验证码不正确");
                return;
            }
        }
    }




    //密码校验
    private boolean passwordValidator(Errors errors, String password) {
        if(password==null||password==""){
            errors.rejectValue("password",null,"密码不能为空");
            return true;
        }
        else if(password.trim().length()<MINIMUM_PASSWORD_LENGTH){
            errors.rejectValue("password",null,"密码长度必须至少为["+ MINIMUM_PASSWORD_LENGTH +"]个字符");
            return true;
        }
        return false;
    }


    //邮箱校验
    private boolean emailValidator(Errors errors, String checkEmail, String email) {
        if(email==null||email==""){
            errors.rejectValue("email",null,"邮箱不能为空");
            return true;
        }
        else if(!email.matches(checkEmail)){
            errors.rejectValue("email",null,"邮箱格式有误");
            return true;
        }
        return false;
    }
}