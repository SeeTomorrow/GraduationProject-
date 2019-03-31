package com.dz.bestnew.serviceImp;

import com.dz.bestnew.mapper.UserMapper;
import com.dz.bestnew.po.User;
import com.dz.bestnew.po.UserExample;
import com.dz.bestnew.po.myPOJO.RegisterUser;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.utils.user.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 * 登陆注册实现类
 *
 * @author 秃头的安娜
 * @create 2019-03-24 19:20
 */

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(RegisterUser user) {
        user.setPassword(UserUtils.encrypt(user.getPassword(),user.getEmail()));
        user.setUserId(UserUtils.getUUID(user.getEmail()));
        user.setEmail(UserUtils.encrypt(user.getEmail(),user.getEmail()));
        user.setRegisterTime(new Date());
        user.setRoleId(2);
        if(userMapper.insertSelective(user)!=-1)
            return true;
        return false;
    }

    @Override
    public User getUserByEmail(String email) {

        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andEmailEqualTo(UserUtils.encrypt(email,email));

        List<User> users = userMapper.selectByExample(example);

        return users.size()>0?users.get(0):null;
    }

    @Override
    public Set<String> findRoles(String email) {
        return null;
    }
}