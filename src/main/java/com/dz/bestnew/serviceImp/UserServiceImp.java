package com.dz.bestnew.serviceImp;

import com.dz.bestnew.mapper.RoleMapper;
import com.dz.bestnew.mapper.myMapper.MyUserExtentMapper;
import com.dz.bestnew.po.Extent;
import com.dz.bestnew.po.Role;
import com.dz.bestnew.po.User;
import com.dz.bestnew.po.myPOJO.UserExtent;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 *  这个类中相关用户的操作都是通过认证后的用户
 * @Author Hasee
 * @Date 2019/3/29 18:34
 */

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MyUserExtentMapper userExtentMapper;


    @Override
    public User findUserByEmail(String email) {
        return loginService.getUserByEmail(email);
    }

    @Override
    public String findRolesByUser(User user) {
        Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
        return role.getRoleName();
    }

    @Override
    public UserExtent findExtentByUser(User user) {
        List<Extent> extents = userExtentMapper.selectExtentByRoleId(user.getRoleId());
        UserExtent userExtent = new UserExtent();
        userExtent.setExtents(extents);
        userExtent.setUser(user);
        return userExtent;
    }
}