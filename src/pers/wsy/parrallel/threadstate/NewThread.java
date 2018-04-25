package pers.wsy.parrallel.threadstate;

/**
 * Created by WSY on 2018/4/24.
 */
public class NewThread implements Runnable{

    @Override
    public synchronized void run() {
        while(true){
            try {
                wait();
                System.out.println("自定义线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        //创建线程，并指定线程任务
        Thread thread = new Thread(newThread);
        //启动线程
        thread.start();

        while(true){
            synchronized (newThread){
                newThread.notifyAll();
            }
            System.out.println("主线程");
        }
    }
}
