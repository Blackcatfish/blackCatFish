package thread;

import lombok.extern.slf4j.Slf4j;
import sun.misc.VM;
import thread.entity.WindowsSellTicket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/5
 */
@Slf4j
public class TestThread {
    private static int sum;
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        WindowsSellTicket windowsSellTicket = new WindowsSellTicket(100000);
        log.info("售票之前余票{}",windowsSellTicket.getCount());
        List<Integer> integerList=new ArrayList<>();
        List<Thread> threads=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread test1 = new Thread(()-> {
                int ticket = windowsSellTicket.sellTicket(1);
                integerList.add(ticket);
            }, "test"+i);
            test1.start();
            threads.add(test1);
        }
       threads.forEach(thread -> {
           try {
               thread.join();
           } catch (InterruptedException e) {

           }
       });
        log.info("余票{}",windowsSellTicket.getCount());
        int finalRefCount = VM.getFinalRefCount();
        
    }
}
