package pers.wsy.parrallel.deadlock;

/**
 * Created by WSY on 2018/5/8.
 */
public class DeadLock {
    private final Object obj1 = new Object();
    private final Object obj2 = new Object();

    private void method1(){
        synchronized (obj1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println("No Dead");
            }
        }
    }

    private void method2(){
        synchronized (obj2){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){
                System.out.println("NO Dead");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.method1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.method2();
            }
        });
        thread1.start();
        thread2.start();
    }
}
