package com.dz.bestnew.service;

import com.dz.bestnew.po.User;
import org.springframework.stereotype.Service;

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
    public User getUserByEmail(String email);
    public Set<String> findRoles(String email);
}
