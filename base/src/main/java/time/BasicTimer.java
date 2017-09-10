package time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by bst on 2017/9/5.
 */
public class BasicTimer {
    /**
     * 在Java中，有两种方式实现定时任务：
     * 使用java.util包中的Timer和TimerTask
     * 使用Java并发包中的ScheduledExecutorService
     */
    static class DelayTask extends TimerTask {
        public void run() {
            System.out.println("delay task");
        }

        public static void main(String[] args) throws InterruptedException {
            Timer timer = new Timer();
            timer.schedule(new DelayTask(), 1000);
            Thread.sleep(2000);
            timer.cancel();
        }
    }
}
