package com.blackfish.designPattern.factory.simple;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
public class CarFactory {
    public static Car getCar(String name) {
        if ("比亚迪".equals(name)) {
            return new BydT();
        } else if ("五菱星辰".equals(name)) {
            return new Wlxc();
        }
        return null;
    }
}
