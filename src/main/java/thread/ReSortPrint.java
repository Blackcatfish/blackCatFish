package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/29
 */
public class ReSortPrint {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        for (int j = 0; j < 9; j++) {
            new Thread(() -> {
                lock.lock();
                try {
                    a.await();
                    System.out.print("a");
                    //通知另外一个线程执行
                    b.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }).start();
            new Thread(() -> {
                lock.lock();
                try {
                    b.await();
                    System.out.print("b");
                    c.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
            new Thread(() -> {
                lock.lock();
                try {
                    c.await();
                    System.out.print("c");
                    a.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        Thread.sleep(1000);
        lock.lock();
        try {
            a.signal();
        } finally {
            lock.unlock();
        }
    }
}
