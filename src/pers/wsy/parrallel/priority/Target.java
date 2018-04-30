package pers.wsy.parrallel.priority;

/**
 * Created by WSY on 2018/4/30.
 */
public class Target implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
