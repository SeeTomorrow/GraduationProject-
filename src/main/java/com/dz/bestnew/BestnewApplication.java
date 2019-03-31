package com.dz.bestnew;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude = {DataSourceAutoConfiguration.class})*/
@MapperScan("com.dz.bestnew.mapper")
public class BestnewApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestnewApplication.class, args);
    }

}
