package com.blackfish.designPattern.factory.abstratcFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/6/18
 */
@Slf4j
public class Green implements Color{
    @Override
    public void fill() {
        log.info("绿色");
    }
}
