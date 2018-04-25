package pers.wsy.parrallel.createThread;

/**
 * Created by WSY on 2018/4/24.
 */
public class Demo2 {
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                System.out.println("1");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("3");
            }
        }){
            public void run(){
                System.out.println("4");
            }
        }.start();
    }
}
