package pers.wsy.parrallel.createThread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by WSY on 2018/4/25.
 */
public class Demo5 {
    //线程池的实现方式
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executor.shutdown();


    }
}
