package threadbase;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bst on 2017/9/9.
 */
public class ReenterLock implements Runnable {

    //重入锁
    public static ReentrantLock lock = new ReentrantLock();
    public static int i;

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(i);
    }
}
