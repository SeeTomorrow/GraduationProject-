package com.dz.bestnew.config.mvc;

import com.dz.bestnew.utils.validator.UserValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 描述:
 * SpringMvc配置
 *
 * @author 秃头的安娜
 * @create 2019-02-22 17:24*/


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private UserValidatorUtil userValidator;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //将浏览器请求映射到哪个页面，页面由模板引擎视图解析器来解析
        registry.addViewController("").setViewName("home/home-1");
        registry.addViewController("home.html").setViewName("home/home-1");
        registry.addViewController("login.html").setViewName("login/login");
        registry.addViewController("singleNews1.html").setViewName("news/singleNews1");
        registry.addViewController("world.html").setViewName("news/world");
        registry.addViewController("national.html").setViewName("news/national");
        registry.addViewController("financial.html").setViewName("news/financial");
        registry.addViewController("entertainment.html").setViewName("news/entertainment");
        registry.addViewController("lifestyle.html").setViewName("news/lifestyle");
        registry.addViewController("technology.html").setViewName("news/technology");
        registry.addViewController("travel.html").setViewName("news/travel");
        registry.addViewController("sports.html").setViewName("news/sports");
        registry.addViewController("author.html").setViewName("author/author");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    静态文件默认路径虽然是在static下，但并没有包含static 下的各个文件夹，因此需要添加路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public Validator getValidator() {
        return userValidator;
    }
}
