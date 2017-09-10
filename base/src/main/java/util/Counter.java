package util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bst on 2017/9/4.
 */
public class Counter {
    private AtomicInteger counter;
    private int count;

    /**
     * 任意对象都有一个锁和等待队列
     * synchronized实例方法保护的是当前实例对象，即this，this对象有一个锁和一个等待队列，锁只能被一个线程持有，其他试图获得同样锁的线程需要等待，执行synchronized实例方法的过程大概如下：
     * 尝试获得锁，如果能够获得锁，继续下一步，否则加入等待队列，阻塞并等待唤醒
     * 执行实例方法体代码
     * 释放锁，如果等待队列上有等待的线程，从中取一个并唤醒，如果有多个等待的线程，唤醒哪一个是不一定的，不保证公平性
     */
    public synchronized void incr() {
        count++;
    }
    public void inc(){
        synchronized(this){
            count ++;
        }
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) {
        int num = 100;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.getCount());
    }

    public int getAndSet(){
        counter.compareAndSet(0,1);//CAS
        return counter.getAndSet(1);
    }
}
