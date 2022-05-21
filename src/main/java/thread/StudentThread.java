package thread;

import thread.entity.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/17
 */
public class StudentThread {
    public static void main(String[] args) {
        Student student = new Student();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()->{
            student.setAge("11");
        });
        executorService.submit(()->{
            student.setName("22");
        });
        executorService.shutdown();
        System.out.println(student);
    }
}
