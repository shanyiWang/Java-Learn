package pers.wsy.parrallel.synTest;

/**
 * Created by WSY on 2018/5/10.
 */
public class SynTest {

    public synchronized void a(){
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void b(){
        System.out.println("I'm b");
    }

    public static void main(String[] args) {
        SynTest st = new SynTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                st.a();
            }
        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                st.b();
            }
        }).start();
    }
}
