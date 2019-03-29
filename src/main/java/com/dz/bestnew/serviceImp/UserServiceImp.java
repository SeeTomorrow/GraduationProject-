package com.dz.bestnew.serviceImp;

import com.dz.bestnew.mapper.generator.RoleExtentMapper;
import com.dz.bestnew.mapper.generator.UserMapper;
import com.dz.bestnew.mapper.myMapper.MyUserExtentMapper;
import com.dz.bestnew.mapper.myMapper.MyUserRoleMapper;
import com.dz.bestnew.po.generator.*;
import com.dz.bestnew.po.myPOJO.UserExtent;
import com.dz.bestnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private UserMapper userMapper;
    @Autowired
    private MyUserRoleMapper userRoleMapper;
    @Autowired
    private MyUserExtentMapper userExtentMapper;


    @Override
    public User getUserByEmail(String email) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(example);

        return users.size()>0?users.get(0):null;
    }

    @Override
    public ArrayList<String> findRolesByEmail(String email) {
        ArrayList<String> role = userRoleMapper.selectRoleByUser(email);
        return role;
    }

    @Override
    public UserExtent findExtentByEmail(String email) {

        ArrayList<String> userRole = findRolesByEmail(email);
        userExtentMapper.selectExtentByRole(userRole.get(0));
        return userExtents.size()>0?userExtents:null;
    }
}