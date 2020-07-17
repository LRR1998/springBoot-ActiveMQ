package com.yaspeed.demo716;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@MapperScan("com.yaspeed.demo716.dao")
@EnableJms
public class Demo716Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo716Application.class, args);
    }

}
