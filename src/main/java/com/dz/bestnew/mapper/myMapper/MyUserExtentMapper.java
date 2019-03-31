package com.dz.bestnew.mapper.myMapper;

import com.dz.bestnew.po.Extent;

import java.util.List;

/**
 * @ClassName MyUserExtentMapper
 * @Description TODO
 *
 * @Author Hasee
 * @Date 2019/3/29 20:28
 */
public interface MyUserExtentMapper {
    //根据角色id查询权限
    List<Extent> selectExtentByRoleId(Integer roleId);
}