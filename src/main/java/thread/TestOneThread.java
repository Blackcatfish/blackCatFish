package thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/5
 */
@Slf4j
public class TestOneThread {
    private static int sum;
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            log.info("jjjj");
            sum+=i;
        }
        for (int i = 0; i < 10000000; i++) {
            log.info("222");
            sum+=i;
        }
        for (int i = 0; i < 10000000; i++) {
            log.info("333");
            sum+=i;
        }
        long end = System.currentTimeMillis() - l;
        System.out.println(end);
        System.out.println(sum);
    }
}
