package com.blackfish.designPattern;

/**
 * @Description: 懒汉式双重锁
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/4/17
 */
public class Lazy {
    private volatile static Lazy lazy;

    private Lazy() {
    }

    private static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }
}
