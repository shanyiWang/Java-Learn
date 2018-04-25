package pers.wsy.parrallel.createThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by WSY on 2018/4/25.
 */
public class Demo4 {

    //定时器的实现方式
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("I'm timer task");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000, 1000);
    }
}
