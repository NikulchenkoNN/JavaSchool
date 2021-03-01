package HomeWork11;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TaskTest {
    @Test
    public void test() throws Exception {
        Task<String> task = new Task<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new String("Do something " + Thread.currentThread().getName());
            }
        });
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(task.get());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//
//        Thread.sleep(1500);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(task.get() + Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }));
            threadList.get(i).start();
        }
        Thread.sleep(10000);
    }
}