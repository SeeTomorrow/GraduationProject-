package com.dz.bestnew.service;

import com.dz.bestnew.po.User;

import java.util.Set;

/**
 * @Title: 登陆业务逻辑接口
 * @Description:
 *
 * @date: 2019/2/26 15:00
 * @param:
 * @return:
 *
 */

public interface LoginService {
    User getUserByEmail(String email);
    Set<String> findRoles(String email);
    boolean register(User user);
}
