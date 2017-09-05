package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bst on 2017/9/4.
 * 除了内存，数据还会被缓存在CPU的寄存器以及各级缓存中，当访问一个变量时，可能直接从寄存器或CPU缓存中获取，而不一定到内存中去取
 */
public class ShareMemoryDemo {
    public static int shared = 0;
    public static  void incShared(){
        shared++;
    }
    static class ChildThread extends Thread{
        List<String> list;
        public ChildThread(List<String> list){
                this.list = list;
        }
        public void run(){
            incShared();
            list.add(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        ChildThread thread1 = new ChildThread(list);
        ChildThread thread2 = new ChildThread(list);
        thread1.start();
        thread2.start();
        try {
            //主线程在子线程结束后再退出
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(shared);
        System.out.println(list);
    }
}
