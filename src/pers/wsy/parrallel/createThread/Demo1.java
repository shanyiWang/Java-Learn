package pers.wsy.parrallel.createThread;

/**
 * Created by WSY on 2018/4/24.
 */
public class Demo1 extends Thread{
    public Demo1(String name){
        super(name);
    }

    @Override
    public void run(){
        //线程不应该有其他线程所终止，而是由自己所停止
        //如果线程在运行状态下，中断标志位设置为True; 阻塞状态下（sleep,wait）抛出InterruptedException
        //所以用while(!interrupted())来判断是否中断
        while(!interrupted()){
            try {
                sleep(2000);
                System.out.println("我是线程"+ getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("Thread 1");
        Demo1 demo2 = new Demo1("Thread 2");

        //User Thread 用户线程  Daemon Thread 守护线程
        //用户线程跑完了，Daemon线程就没有任何存在的必要
        demo1.setDaemon(true);
        demo2.setDaemon(true);
        demo1.start();
        demo2.start();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        demo1.interrupt();  //在demo1 线程运行的时候interrupt 跑的时候才有用，sleep的时候就没有什么意义了

    }

}
