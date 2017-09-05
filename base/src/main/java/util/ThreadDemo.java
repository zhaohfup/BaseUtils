package util;

/**
 * Created by bst on 2017/9/4.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //当所有线程执行完程序退出
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.setPriority(1);
        System.out.println(myThread.isAlive());
        myThread.start();
        System.out.println(myThread.isAlive());
        System.out.println(myThread.getState());
        System.out.printf(Thread.currentThread().getName());
        Thread hello = new Thread(new MyRunnable());
        hello.start();
        //NEW: 没有调用start的线程状态为NEW
        //TERMINATED: 线程运行结束后状态为TERMINATED
       // RUNNABLE: 调用start后线程在执行run方法且没有阻塞时状态为RUNNABLE，不过，RUNNABLE不代表CPU一定在执行该线程的代码，可能正在执行也可能在等待操作系统分配时间片，只是它没有在等待其他条件
       // BLOCKED、WAITING、TIMED_WAITING：都表示线程被阻塞了，在等待一些条件
        System.out.println(myThread.getState());
        try {
            myThread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends  Thread{

    public void run(){
        System.out.println("hello thread ");
        System.out.println(Thread.currentThread().getId()+"--"+Thread.currentThread().getName());
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("hello my thread");
    }
}