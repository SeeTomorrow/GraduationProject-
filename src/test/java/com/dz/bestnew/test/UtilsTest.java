package com.dz.bestnew.test;

import com.dz.bestnew.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void encrypt() {
        String encrypt = Utils.encrypt("199608190833+1", "2975993378@qq.com");

    }
}