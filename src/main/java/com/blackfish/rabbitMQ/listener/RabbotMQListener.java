package com.blackfish.rabbitMQ.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/1/15
 */
@Component
@Slf4j
public class RabbotMQListener {

    @RabbitListener(queues = "topic.woman")
    public void test(String msg){
        log.info(msg);
    }
}
