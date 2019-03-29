package com.dz.bestnew.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * 描述:
 * 自定义shiro校验密码的方法
 *
 * @author 秃头的安娜
 * @create 2019-03-28 12:49
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, Integer> cache;

    //密码错误上限
    private Integer retryMax;

    public void setRetryMax(Integer retryMax) {
        this.retryMax = retryMax;
    }

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        cache = cacheManager.getCache("passwordRetryCache");
    }


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        Integer retryCount = cache.get(username);
        if(retryCount == null) {
            retryCount = new Integer(0);
            cache.put(username, retryCount);
        }


        if(retryCount >= retryMax) {
            throw new ExcessiveAttemptsException("您已连续错误达" + retryMax + "次！请N分钟后再试");
        }else {
            cache.put(username, ++retryCount);
        }

        //调用父类的校验方法
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            cache.remove(username);
        }else {
            throw new IncorrectCredentialsException("密码错误，已错误" + retryCount + "次，最多错误" + retryMax + "次");
        }
        return true;
    }
}