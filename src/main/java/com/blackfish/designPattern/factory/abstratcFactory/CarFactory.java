package com.blackfish.designPattern.factory.abstratcFactory;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
public class CarFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Car getCar(String name) {
        if ("比亚迪".equals(name)) {
            return new BydT();
        } else if ("五菱星辰".equals(name)) {
            return new Wlxc();
        }
        return null;
    }
}
