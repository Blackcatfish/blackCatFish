package com.blackfish.rabbitMQ.config;

import java.util.Arrays;
 
import org.springframework.amqp.rabbit.listener.ListenerContainerConsumerFailedEvent;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
 
import lombok.extern.slf4j.Slf4j;
 
/**
 * MQ消费者失败事件监听器
 * @author wxyh
 * @date 2018/04/02
 */
@Slf4j
@Component
public class ListenerContainerConsumerFailedEventListener implements ApplicationListener<ListenerContainerConsumerFailedEvent> {
 
    @Override
    public void onApplicationEvent(ListenerContainerConsumerFailedEvent event) {
        log.error("消费者失败事件发生：{}", event);
 
        if (event.isFatal()) {
            log.error(String.format("Stopping container from aborted consumer. Reason::%s.",
                    event.getReason()), event.getThrowable());
            SimpleMessageListenerContainer container = (SimpleMessageListenerContainer) event.getSource();
            String queueNames = Arrays.toString(container.getQueueNames());
            // 重启
            try {
                restart(container);
                log.info("重启队列%s的监听成功！", queueNames);
            } catch (Exception e) {
                log.error(String.format("重启队列%s的监听失败！", queueNames), e);
            }
        }
    }
 
    /**
     * 重启监听
     * @param container
     * @return
     */
    private void restart(SimpleMessageListenerContainer container) {
        // 暂停30s
        try {
            Thread.sleep(30000);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
 
        Assert.state(!container.isRunning(), String.format("监听容器%s正在运行！", container));
        container.start();
    }
 
}