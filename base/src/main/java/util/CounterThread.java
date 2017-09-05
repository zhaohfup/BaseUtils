package util;

/**
 * Created by bst on 2017/9/4.
 */
public class CounterThread extends Thread {
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter.incr();
    }
}
