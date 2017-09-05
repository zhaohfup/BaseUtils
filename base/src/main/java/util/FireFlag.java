package util;

/**
 * Created by bst on 2017/9/4.
 */
public class FireFlag {
    private volatile boolean fired = false;

    public synchronized void waitForFire() throws InterruptedException {
        while (!fired) {
            wait();
        }
    }

    public synchronized void fire() {
        this.fired = true;
        notifyAll();
    }
}
