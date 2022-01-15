package com.blackfish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/6/14
 */
@SpringBootApplication
@MapperScan("com.blackfish.shiro.mapper")
@EnableRabbit
public class BlackCatFishApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackCatFishApplication.class);
    }
}
