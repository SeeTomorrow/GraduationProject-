package com.dz.bestnew.service;

import com.dz.bestnew.po.generator.Extent;
import com.dz.bestnew.po.generator.Role;
import com.dz.bestnew.po.generator.User;
import com.dz.bestnew.po.generator.UserRoleKey;
import com.dz.bestnew.po.myPOJO.UserExtent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    User getUserByEmail(String email);


    //通过用户邮箱查询用户对应的角色
    ArrayList<String> findRolesByEmail(String email);

    //通过用户邮箱查询用户对应的权限
    UserExtent findExtentByEmail(String email);



}
