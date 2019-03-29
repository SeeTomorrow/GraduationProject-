package com.dz.bestnew.config.shiro;

import com.dz.bestnew.mapper.generator.RoleExtentMapper;
import com.dz.bestnew.mapper.generator.UserRoleMapper;
import com.dz.bestnew.mapper.myMapper.MyUserExtentMapper;
import com.dz.bestnew.mapper.myMapper.MyUserRoleMapper;
import com.dz.bestnew.po.generator.User;
import com.dz.bestnew.po.generator.UserRoleKey;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.service.UserService;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 * 数据源，通过realm存取认证、授权相关数据
 *
 * @author 秃头的安娜
 * @create 2019-02-26 16:12
 */
public abstract class AbstractUserRealm extends AuthorizingRealm {

    private static Logger logger=LoggerFactory.getLogger(AbstractUserRealm.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    //获取用户组的权限信息
    public abstract UserRolesAndPermissions doGetGroupAuthorizationInfo(User userInfo);
    //获取用户角色的权限信息
    public abstract UserRolesAndPermissions doGetRoleAuthorizationInfo(User userInfo);


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

        UserRoleKey userRole = userService.findRolesByEmail(username);
        Set<String> role = new HashSet<>();
        role.add(userRole)

        /*//获取当前验证的用户名
        String currentLoginName = (String)principalCollection.getPrimaryPrincipal();

        Set<String> userRoles=new HashSet<>();
        Set<String> userPermissions = new HashSet<>();

        //从数据库中获取当前登录用户的信息
        User userInfo = loginService.getUserByEmail(currentLoginName);

        if(null!=userInfo){
            UserRolesAndPermissions roleContainer = doGetRoleAuthorizationInfo(userInfo);
            UserRolesAndPermissions groupContainer = doGetGroupAuthorizationInfo(userInfo);

            //角色添加容器中
            userRoles.addAll(roleContainer.getUserRoles());
            userRoles.addAll(groupContainer.getUserRoles());

            //权限添加容器中
            userPermissions.addAll(roleContainer.getUserPermissions());
            userPermissions.addAll(groupContainer.getUserPermissions());
        }else{
            throw new AuthenticationException();
        }*/
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(userRoles);
        simpleAuthorizationInfo.addStringPermissions(userPermissions);
        logger.info("#####【获取角色成功】[SessionId]==>",SecurityUtils.getSubject().getSession().getId());
        return simpleAuthorizationInfo;
    }

    protected class UserRolesAndPermissions {
        //用户角色
        Set<String> userRoles;

        public void setUserRoles(Set<String> userRoles) {
            this.userRoles = userRoles;
        }

        public Set<String> getUserRoles() {
            return userRoles;
        }

        public Set<String> getUserPermissions() {
            return userPermissions;
        }

        public void setUserPermissions(Set<String> userPermissions) {
            this.userPermissions = userPermissions;
        }

        public UserRolesAndPermissions(Set<String> userRoles, Set<String> userPermissions) {

            this.userRoles = userRoles;
            this.userPermissions = userPermissions;
        }

        //用户权限
        Set<String> userPermissions;
    }
}