package com.blackfish.designPattern.factory.abstratcFactory;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
public class TestFactory {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("比亚迪");
        car.run();
        Car wul = carFactory.getCar("五菱星辰");
        wul.run();

    }
}
