package util;

/**
 * Created by bst on 2017/9/5.
 */
public class InterruptRunnableDemo extends Thread {
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("interrupted");
        }
        System.out.println("thread is done");
    }

    public static void main(String[] args) {
        InterruptRunnableDemo interruptRunnableDemo = new InterruptRunnableDemo();
        interruptRunnableDemo.start();
        try {
            interruptRunnableDemo.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptRunnableDemo.interrupt();
    }
}
