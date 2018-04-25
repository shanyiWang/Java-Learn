package pers.wsy.parrallel.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by WSY on 2018/4/24.
 */
public class Demo3 implements Callable<Integer>{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Demo3());
        Integer number;
        Thread t = new Thread(task);
        t.start();

        number=task.get();
        System.out.println(number );

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread 3");
        return 3;
    }
}
