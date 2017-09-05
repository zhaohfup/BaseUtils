package util;

/**
 * Created by bst on 2017/9/4.
 * 线程除了竞争还有协作
 */
public class WaiteThread extends Thread {
    private volatile boolean fire = false;

    /**
     * 调用wait就会把当前线程放到条件队列上并阻塞，表示当前线程执行不下去了，
     * 它需要等待一个条件，这个条件它自己改变不了，需要其他线程改变。当其他线程改变了条件后，应该调用Object的notify方法唤醒
     */
    public synchronized void fire() {
        this.fire = true;
        notify();
    }

    public void run() {
        synchronized (this) {
            while (!fire) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("fired");
    }

    public static void main(String[] args) {
        WaiteThread waiteThread = new WaiteThread();
        waiteThread.start();
        try {
            waiteThread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fire");
        waiteThread.fire();
    }
}
