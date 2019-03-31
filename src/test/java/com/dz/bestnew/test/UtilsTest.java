package com.dz.bestnew.test;

import com.dz.bestnew.utils.user.UserUtils;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void encrypt() {
        String encrypt = UserUtils.encrypt("199608190833+1", "2975993378@qq.com");

    }
}