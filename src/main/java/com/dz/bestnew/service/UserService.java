package com.dz.bestnew.service;

import com.dz.bestnew.po.User;
import com.dz.bestnew.po.myPOJO.UserExtent;


/**
 * @Title: 用户相关操作接口
 * @Description:
 *
 * @date: 2019/2/26 15:00
 * @param:
 * @return:
 *
 */


public interface UserService {
    User findUserByEmail(String email);

    //通过用户查询用户对应的角色，该系统每个用户仅仅对应一个角色
    String findRolesByUser(User user);

    //通过用户查询用户对应的权限
    UserExtent findExtentByUser(User user);
}
