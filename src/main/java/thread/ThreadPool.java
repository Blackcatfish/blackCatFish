package thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/5
 */
@Slf4j
public class ThreadPool {
    static final Object lock = new Object();
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = new ArrayList<>();
        List<String> string2 = new ArrayList<>();

        ThreadFactory factory = new ThreadFactoryBuilder().setNamePrefix("线程")
                .setUncaughtExceptionHandler((t, e) -> log.error(t.getName() + "出现异常", e)).build();
        int corePoolSize = 3;
        int maxPoolSize = 4;
        long keepAliveTime = 5;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    strings.add("1");
                    counter--;
                }
            }
        }, "1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                synchronized (lock) {
                    strings.add("2");
                    counter++;
                }
            }
        }, "2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("集合大小{}", strings.size());

        log.info("counter={}", counter);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            Future<?> submit = executorService.submit(() -> {
                for (int i = 0; i < 100000; i++) {
                    string2.add("1");
                    int p = 1 / 0;
                }
            });
            submit.get();
        } catch (Exception e) {
            log.error("===={}", e.getMessage());
            e.printStackTrace();
        }
        try {
            executorService.execute(() -> {
                for (int i = 0; i < 100000; i++) {
                    string2.add("1");
                    int k=1/0;
                }
            });
        } catch (Exception e) {
            log.error("===={}",e.getMessage());
        }
        executorService.execute(() -> {
            for (int i = 0; i < 100000; i++) {
                string2.add("1");
            }
        });
        executorService.shutdown();
        log.info("集合大小{}", string2.size());
    }

    public class ThreadExceptionRunner implements Runnable {
        @Override
        public void run() {
            throw new RuntimeException("error !!!!");
        }
    }
}
