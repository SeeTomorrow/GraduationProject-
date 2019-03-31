package com.dz.bestnew.config.shiro;

import com.dz.bestnew.po.User;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.service.UserService;
import com.dz.bestnew.utils.user.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 描述:
 * 数据源，通过realm存取认证、授权相关数据
 *
 * @author 秃头的安娜
 * @create 2019-02-26 16:12
 */
public class UserRealm extends AuthorizingRealm {

    private static Logger logger=LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;


    //验证当前登录的用户,当调用login(token)时会调用此方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //UsernamePasswordToken对象用来存放提交的登陆信息
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;

        //查询是否拥有此用户
        User user= loginService.getUserByEmail(token.getUsername());

        if(user!=null){
            //若存在，将此用户放到登陆认证info中，Shiro会进行密码的校验
            //将邮箱作为盐值
            ByteSource credentialsSalt=ByteSource.Util.bytes(token.getUsername());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getUsername(), user.getPassword(), credentialsSalt, getName());
            return info;
        }else {
            throw new UnknownAccountException("未知账户，请先注册");
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String username = user.getEmail();
        System.out.println("用户" + username + "获取权限-----ShiroRealm.doGetAuthorizationInfo");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取角色集
        String role = userService.findRolesByUser(user);
        simpleAuthorizationInfo.addRole(role);

        //获取权限集
        Set<String> extents = UserUtils.getExtents(userService.findExtentByUser(user));
        simpleAuthorizationInfo.addStringPermissions(extents);


      return simpleAuthorizationInfo;
    }
}