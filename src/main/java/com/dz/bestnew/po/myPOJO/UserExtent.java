package com.dz.bestnew.po.myPOJO;

import com.dz.bestnew.po.generator.User;

import java.util.Set;

/**
 * @ClassName UserExtent
 * @Description TODO
 *  用户和用户对应的权限
 * @Author Hasee
 * @Date 2019/3/29 20:24
 */
public class UserExtent extends User {
    private String role;
    private Set<String> extents;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<String> getExtents() {
        return extents;
    }

    public void setExtents(Set<String> extents) {
        this.extents = extents;
    }
}