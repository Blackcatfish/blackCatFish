package thread;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/29
 */
public class SortPrint {
    private static int i = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int j = 0; j < 9; j++) {
            new Thread(() -> {
                synchronized (lock) {
                    while (i != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("a");
                    i = 2;
                    lock.notifyAll();
                }
            }).start();
            new Thread(() -> {
                synchronized (lock) {
                    while (i != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.print("b");
                    i = 3;
                    lock.notifyAll();

                }
            }).start();
            new Thread(() -> {
                synchronized (lock) {
                    while (i != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.print("c");
                    i = 1;
                    lock.notifyAll();
                }
            }).start();
        }
    }

}
