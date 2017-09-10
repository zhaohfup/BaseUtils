package util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bst on 2017/9/5.
 */
public class MyLock {
    private final Lock lock = new ReentrantLock();
    private volatile int count;
    public  void incr(){
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }
    public int get(){
        return  count;
    }
    private AtomicInteger status = new AtomicInteger();
    public void lock(){
        while (!status.compareAndSet(0,1)){
            Thread.yield();
        }
    }
    public void unlock(){
        status.compareAndSet(1,0);
    }
}
