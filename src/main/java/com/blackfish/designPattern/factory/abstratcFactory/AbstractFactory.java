package com.blackfish.designPattern.factory.abstratcFactory;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Car getCar(String carType);
}
