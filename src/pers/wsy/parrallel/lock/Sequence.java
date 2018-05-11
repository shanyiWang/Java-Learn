package pers.wsy.parrallel.lock;

/**
 * Created by WSY on 2018/5/10.
 */
public class Sequence {
    private MyLock lock = new MyLock();

    private int value = 0;

    public int getNext(){
        lock.lock();
        value ++;
        lock.unlock();
        return value;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s.getNext());
                }
            }
        }).start();
    }

}
