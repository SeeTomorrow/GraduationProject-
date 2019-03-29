package com.dz.bestnew.config.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述:
 * Shiro配置类
 *
 * @author 秃头的安娜
 * @create 2019-02-26 18:26
 */
@Configuration
public class ShiroConfiguration {

    private static final Logger logger=LoggerFactory.getLogger(ShiroConfiguration.class);


    /*
     * @Title: userRealm
     * @Description:
     *  自定义Realm
     * @date: 2019/3/28 13:04
     * @param: [credentialsMatcher]
     * @return: com.dz.bestnew.config.shiro.UserRealm
     *
     */


    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        //将自定义令牌注入到Realm
        userRealm.setCredentialsMatcher(credentialsMatcher());
        return userRealm;
    }






    /*
     * @Title: shiroFilterFactoryBean
     * @Description:
     * Shiro的Web过滤器Factory
     * @date: 2019/2/26 18:57
     * @param: [request, securityManager]
     * @return: org.apache.shiro.spring.web.ShiroFilterFactoryBean
     *
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        logger.info("注入Shiro的Web过滤器-->shiroFilter",ShiroFilterFactoryBean.class);
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //Shiro的核心安全接口，必须属性
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //登陆链接
        shiroFilterFactoryBean.setLoginUrl("/login.html");

        //登陆成功后重定向到请求的上一个页面
//        shiroFilterFactoryBean.setSuccessUrl(WebUtils.getSavedRequest(request).getRequestUrl());

        //用户访问未对其授权的资源时，所显示的链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");

        //Shiro过滤链 Map结构
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        //用户退出登陆，其中具体的退出代码Shiro已经实现了
        filterChainDefinitionMap.put("/user/logout","logout");

        /*
        *过滤链从上向下顺序执行，一般将/**放在最下边
        *authc:所有url都必须认证通过后才可以访问;
        * anon:所有url都可以匿名访问
        */

        //对静态资源放行
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/icon/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/webjars/**","anon");


        filterChainDefinitionMap.put("/login.html","anon");
//        filterChainDefinitionMap.put("/user/login","anon");
        filterChainDefinitionMap.put("/","user");
        filterChainDefinitionMap.put("/home.html","user");
//        filterChainDefinitionMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //不指定名字的话，自动创建一个方法名第一个字母小写的bean
    @Bean
    public EhCacheManager ehcacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:shiro/shiro-ehcache.xml");
        return cacheManager;
    }


    @Bean(name = "securityManager")
    @DependsOn("credentialsMatcher")
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());

        //注入缓存管理器
        securityManager.setCacheManager(ehcacheManager());

        //注入cookie管理对象
        securityManager.setRememberMeManager(rememberMeManager());

        return securityManager;
    }
    
    
    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(ehcacheManager());
        //加密方式
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密迭代次数
        credentialsMatcher.setHashIterations(1024);
        //true加密用的hex编码，false用的base64编码
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        //重新尝试的次数（自己定义的）
        credentialsMatcher.setRetryMax(5);
        return credentialsMatcher;
    }

    /*
     * @Title: lifecycleBeanPostProcessor
     * @Description:
     *  Shiro生命周期处理器
     * @date: 2019/2/26 19:28
     * @param: []
     * @return: org.apache.shiro.spring.LifecycleBeanPostProcessor
     *
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /*
     * @Title: advisorAutoProxyCreator
     * @Description:
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),
     *  需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     *  配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @date: 2019/2/26 19:31
     * @param: []
     * @return: org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
     *
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * cookie对象
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
//        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}