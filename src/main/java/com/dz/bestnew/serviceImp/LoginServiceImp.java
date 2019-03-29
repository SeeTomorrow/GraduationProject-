package com.dz.bestnew.serviceImp;

import com.dz.bestnew.mapper.generator.UserMapper;
import com.dz.bestnew.po.generator.User;
import com.dz.bestnew.po.generator.UserExample;
import com.dz.bestnew.po.myPOJO.RegisterUser;
import com.dz.bestnew.service.LoginService;
import com.dz.bestnew.utils.Utils;
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
        user.setPassword(Utils.encrypt(user.getPassword(),user.getEmail()));
        user.setUserId(Utils.getUUID(user.getEmail()));
        user.setEmail(Utils.encrypt(user.getEmail(),user.getEmail()));
        user.setRegisterTime(new Date());
        if(userMapper.insertSelective(user)!=-1)
            return true;
        return false;
    }

    @Override
    public User getUserByEmail(String email) {

        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andEmailEqualTo(Utils.encrypt(email,email));

        List<User> users = userMapper.selectByExample(example);

        if(users!=null && users.size()!=0)
        return users.get(0);
        return null;
    }

    @Override
    public Set<String> findRoles(String email) {
        return null;
    }
}