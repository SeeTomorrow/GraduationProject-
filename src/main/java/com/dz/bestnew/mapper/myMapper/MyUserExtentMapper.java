package com.dz.bestnew.mapper.myMapper;

import com.dz.bestnew.po.generator.UserRoleKey;
import com.dz.bestnew.po.myPOJO.UserExtent;

import java.util.List;
import java.util.Set;

/**
 * @ClassName MyUserExtentMapper
 * @Description TODO
 *
 * @Author Hasee
 * @Date 2019/3/29 20:28
 */
public interface MyUserExtentMapper {
    Set<String> selectExtentByRole(Integer roleId);

}