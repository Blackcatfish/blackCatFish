package com.blackfish.designPattern.factory.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
@Slf4j
public class BydT implements Car {
    @Override
    public void run() {
        log.info("比亚迪-唐启动");
    }
}
