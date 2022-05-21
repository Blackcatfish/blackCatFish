package com.blackfish.designPattern;

/**
 * @Description: 饿汉式
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/4/17
 */
public class Singleton {
    //对象私有化使对象无法实例化
    private Singleton() {
    }

    ;
    private static final Singleton singleton = new Singleton();

    private static Singleton getInstance() {
        return singleton;
    }

}
