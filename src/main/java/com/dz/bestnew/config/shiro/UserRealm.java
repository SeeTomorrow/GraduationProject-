package com.dz.bestnew.config.shiro;

import com.dz.bestnew.po.generator.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 *
 *  获取用户角色和权限
 * @author 秃头的安娜
 * @create 2019-02-26 18:10
 */


public class UserRealm extends AbstractUserRealm {



    @Override
    public UserRolesAndPermissions doGetGroupAuthorizationInfo(User userInfo) {
        Set<String> userRoles=new HashSet<>();
        Set<String> userPermissions=new HashSet<>();

        //获取当前用户组拥有的所有角色列表及权限
        return new UserRolesAndPermissions(userRoles,userPermissions);
    }

    @Override
    public UserRolesAndPermissions doGetRoleAuthorizationInfo(User userInfo) {
        Set<String> userRoles=new HashSet<>();
        Set<String> userPermissions=new HashSet<>();

        //获取当前用户拥有的所有角色列表及权限
        return new UserRolesAndPermissions(userRoles,userPermissions);
    }
}