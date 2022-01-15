package com.blackfish.rabbitMQ.service.impl;

import com.blackfish.rabbitMQ.service.MQService;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2021/11/7
 */
@Service
public class MQServiceImpl implements MQService {
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;
    @Override
    public String testDirectExchange(String msg) {
        rabbitMessagingTemplate.convertAndSend("testDirectExchange","testDirectRouting",msg);
        return null;
    }
}
