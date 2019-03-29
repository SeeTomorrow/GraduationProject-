package com.dz.bestnew.mapper.myMapper;

import com.dz.bestnew.mapper.generator.UserRoleMapper;
import com.dz.bestnew.po.generator.UserRoleKey;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyUserRoleMapper
 * @Description TODO
 * @Author Hasee
 * @Date 2019/3/29 19:37
 */
public interface MyUserRoleMapper  extends UserRoleMapper {
    //通过邮箱查询对应的角色，该系统每个用户仅仅对应一个角色
    ArrayList<String> selectRoleByUser(String email);
}