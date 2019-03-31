package com.dz.bestnew.po.myPOJO;

import com.dz.bestnew.po.Extent;
import com.dz.bestnew.po.User;

import java.util.List;

/**
 * @ClassName UserExtent
 * @Description TODO
 *  用户和用户对应的权限
 * @Author Hasee
 * @Date 2019/3/29 20:24
 */
public class UserExtent {
    private List<Extent> extents;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Extent> getExtents() {
        return extents;
    }

    public void setExtents(List<Extent> extents) {
        this.extents = extents;
    }
}